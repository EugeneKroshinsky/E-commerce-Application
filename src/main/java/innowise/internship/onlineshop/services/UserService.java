package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.GenericDaoImpl;
import innowise.internship.onlineshop.entities.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserService {
    private final GenericDaoImpl<User> userDao;

    public UserService() {
        this.userDao = new GenericDaoImpl<>(User.class);
    }

    public List<User> getAll() {
        log.info("Fetching all users");
        List<User> users = userDao.getAll();
        log.info("Fetched {} users", users.size());
        return users;
    }

    public User getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching user by ID: {}", id);
        User user = userDao.getById(id);
        if (user == null) {
            log.warn("User with ID {} not found", id);
        } else {
            log.info("Fetched user: {}", user);
        }
        return user;
    }

    public void save(User user) {
        if (user == null) {
            log.error("Attempted to save null user");
            throw new IllegalArgumentException("User must not be null");
        }
        log.info("Saving user: {}", user);
        userDao.save(user);
        log.info("User saved successfully");
    }

    public void update(int id, User user) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (user == null) {
            log.error("Attempted to update with null user");
            throw new IllegalArgumentException("User must not be null");
        }
        log.info("Updating user with ID {}: {}", id, user);
        userDao.update(user);
        log.info("User updated successfully");
    }

    public void delete(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Deleting user with ID {}", id);
        userDao.delete(id);
        log.info("User deleted successfully");
    }
}
