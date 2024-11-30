package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.UserDao;
import innowise.internship.onlineshop.entities.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao(); // Можно заменить на Dependency Injection
    }

    public List<User> getAll() {
        List<User> users = userDao.getAll();
        return users;
    }

    public User getById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        return userDao.getById(id);
    }

    public void saveUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        userDao.save(user);
    }

    public void update(int id, User user) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        userDao.update(id, user);
    }
    public void delete(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        userDao.delete(id);
    }
}
