package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.FilterDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@ApplicationScoped
public class FilterMapper {
    public FilterDto toDto(HttpServletRequest request) {
        try {
            FilterDto filterDto = new FilterDto();
            BeanUtils.populate(filterDto, request.getParameterMap());
            if (filterDto.getMaxPrice() == 0) {
                filterDto.setMaxPrice(100000);
            }
            return filterDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
