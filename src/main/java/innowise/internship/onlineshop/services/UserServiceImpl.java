package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.UserEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;


import java.util.List;

public class UserServiceImpl implements UserService {
    private final GenericRepositoryImpl<UserEntity> userRepository;

    public UserServiceImpl() {
        this.userRepository = new GenericRepositoryImpl<>(UserEntity.class);
    }

    @Override
    public void save(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
