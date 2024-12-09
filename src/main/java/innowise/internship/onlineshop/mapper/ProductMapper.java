package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.dto.ProductDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ProductMapper {
    public static ProductDto toDto(HttpServletRequest request) {
        try {
            ProductDto productDto = new ProductDto();
            BeanUtils.populate(productDto, request.getParameterMap());
            productDto.setCategory(createCategoryDto(request));
            return productDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private static CategoryDto createCategoryDto(HttpServletRequest request) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(Long.parseLong(request.getParameter("categoryId")));
        return categoryDto;
    }
}
