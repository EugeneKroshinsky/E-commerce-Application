package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.dto.UserDto;
import innowise.internship.onlineshop.model.Role;
import innowise.internship.onlineshop.model.User;
import lombok.extern.slf4j.Slf4j;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;

@Slf4j
public class RoleCustomConverter implements CustomConverter {
    @Override
    public Object convert(Object dest, Object source, Class<?> arg3, Class<?> arg4) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        if (source == null) {
            return null;
        }
        if (source instanceof Role) {
            return ((Role) source).getName();
        }
        return null;
    }
}
