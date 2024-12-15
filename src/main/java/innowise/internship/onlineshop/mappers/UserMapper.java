package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.RoleDto;
import innowise.internship.onlineshop.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserMapper {
    public static UserDto toDto(HttpServletRequest request) {
        try {
            UserDto userDto = new UserDto();
            BeanUtils.populate(userDto, request.getParameterMap());
            String[] rolesId = request.getParameterValues("list_roles");
/*            RoleDto roleDto = new RoleDto();
            roleDto.setId(Long.parseLong(roles));
            userDto.setRoles(List.of(roleDto));*/
            List<RoleDto> roleDtos = new ArrayList<>();
            for (String id : rolesId) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(Long.parseLong(id));
                roleDtos.add(roleDto);
            }
            userDto.setRoles(roleDtos);
            log.info("userDto: {}", userDto);
            return userDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
