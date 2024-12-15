package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.User;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            User user = session.createQuery("from User where email = :email and password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
            log.info("User: {}", user);
            session.getTransaction().commit();
            return user;
        }
    }
}
