package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.UserDto;
import innowise.internship.onlineshop.model.User;
import innowise.internship.onlineshop.repository.UserRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.data.exceptions.MappingException;
import jakarta.inject.Inject;

import java.util.Optional;

public class UserServiceImpl extends BaseServiceImpl<UserDto, UserDto, UserDto, User> implements UserService {
    private final UserRepository userRepository;
    @Inject
    public UserServiceImpl(UserRepository repository) {
        super(UserDto.class, repository);
        this.userRepository = repository;
    }

    public Optional<UserDto> authenticate(String login, String password) {
            User user = userRepository.findByEmailAndPassword(login, password);
            if (user == null) {
                return Optional.empty();
            } else {
                return Optional.of(getMapper().map(user, UserDto.class));
            }
    }
}
