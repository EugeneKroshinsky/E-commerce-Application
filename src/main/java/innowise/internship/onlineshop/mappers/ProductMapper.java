package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.dto.ProductDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@ApplicationScoped
public class ProductMapper {
    @PersistenceContext
    private  EntityManager entityManager;
    public ProductDto toDto(HttpServletRequest request) {
        try {
            ProductDto productDto = new ProductDto();
            BeanUtils.populate(productDto, request.getParameterMap());
            productDto.setCategory(entityManager.getReference(CategoryDto.class, productDto.getCategoryId()));
            return productDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
