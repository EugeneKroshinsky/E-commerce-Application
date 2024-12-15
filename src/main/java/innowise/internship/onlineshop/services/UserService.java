package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.UserDto;
import innowise.internship.onlineshop.services.base.BaseService;

import java.util.Optional;

public interface UserService extends
        BaseService<UserDto, UserDto, UserDto> {
    Optional<UserDto> authenticate(String login, String password);
}
