package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.UserDto;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    @Inject
    private UserService userService;

    public boolean authenticate(String login, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Optional<UserDto> userDto = userService.authenticate(login, password);
        if (userDto.isEmpty()) {
            return false;
        }
        if (session.getAttribute("user") == null) {
           session.setAttribute("user", userDto.get());
        }
        return true;
    }
}
