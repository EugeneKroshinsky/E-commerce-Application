package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericRepositoryImpl <T> implements GenericRepository<T> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Class<T> type;

    public GenericRepositoryImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<T> objects = session
                    .createQuery("select o from " + type.getSimpleName() + " o", type)
                    .getResultList();
            session.getTransaction().commit();
            return objects;
        }
    }

    @Override
    public T getById(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T object = session.get(type, id);
            session.getTransaction().commit();
            return object;
        }
    }

    @Override
    public void update(T object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.merge(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T object = session.get(type, id);
            session.delete(object);
            session.getTransaction().commit();
        }
    }
}