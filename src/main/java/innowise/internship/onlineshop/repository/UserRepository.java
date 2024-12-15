package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.User;
import innowise.internship.onlineshop.repository.base.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    User findByEmailAndPassword(String login, String password);
}
