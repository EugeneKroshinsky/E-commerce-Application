package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.UserEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserService {
    private final GenericRepositoryImpl<UserEntity> userDao;

    public UserService() {
        this.userDao = new GenericRepositoryImpl<>(UserEntity.class);
    }

    public List<UserEntity> getAll() {
        log.info("Fetching all users");
        List<UserEntity> userEntities = userDao.getAll();
        log.info("Fetched {} users", userEntities.size());
        return userEntities;
    }

    public UserEntity getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching user by ID: {}", id);
        UserEntity userEntity = userDao.getById(id);
        if (userEntity == null) {
            log.warn("User with ID {} not found", id);
        } else {
            log.info("Fetched user: {}", userEntity);
        }
        return userEntity;
    }

    public void save(UserEntity userEntity) {
        if (userEntity == null) {
            log.error("Attempted to save null user");
            throw new IllegalArgumentException("User must not be null");
        }
        log.info("Saving user: {}", userEntity);
        userDao.save(userEntity);
        log.info("User saved successfully");
    }

    public void update(int id, UserEntity userEntity) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (userEntity == null) {
            log.error("Attempted to update with null user");
            throw new IllegalArgumentException("User must not be null");
        }
        log.info("Updating user with ID {}: {}", id, userEntity);
        userDao.update(userEntity);
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
