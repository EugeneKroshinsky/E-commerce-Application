package innowise.internship.onlineshop.dao;

import innowise.internship.onlineshop.entities.User;
import innowise.internship.onlineshop.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Slf4j
public class UserDao {

    private final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void save(User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }
    public List<User> getAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<User> users = session
                    .createQuery("select o from User o", User.class)
                    .getResultList();
            session.getTransaction().commit();
            return users;
        }
    }
    public User getById(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
    }
    public void update(int id, User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            user.setId(id);
            session.merge(user);
            session.getTransaction().commit();
        }
    }
    public void delete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}
