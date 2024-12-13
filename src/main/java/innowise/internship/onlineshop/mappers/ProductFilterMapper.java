package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.model.ProductFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@ApplicationScoped
public class ProductFilterMapper {
    public ProductFilter toDto(HttpServletRequest request) {
        try {
            ProductFilter productFilter = new ProductFilter();
            BeanUtils.populate(productFilter, request.getParameterMap());
            if (productFilter.getMaxPrice() == 0) {
                productFilter.setMaxPrice(100000);
            }
            return productFilter;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
