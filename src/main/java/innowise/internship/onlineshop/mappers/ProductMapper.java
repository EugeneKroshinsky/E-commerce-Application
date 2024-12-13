package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.dto.ProductDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ProductMapper {
/*  Тут можно было использовать EntityManger, но он у меня в какой-то момент перестал подгружаться
    @PersistenceContext
    private EntityManager entityManager;*/
    public ProductDto toDto(HttpServletRequest request) {
        try {
            ProductDto productDto = new ProductDto();
            BeanUtils.populate(productDto, request.getParameterMap());
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(productDto.getCategoryId());
            productDto.setCategory(categoryDto);
            return productDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
