package innowise.internship.onlineshop.repository.base;

import innowise.internship.onlineshop.utils.HibernateUtil;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Getter
public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<T> type;

    public BaseRepositoryImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T object, Session session) {
        session.persist(object);
    }


    @Override
    public void save(T object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            save(object,session);
            session.getTransaction().commit();
        }
    }
    @Override
    public List<T> getAll(Session session) {
        List<T> objects = session
                .createQuery("from " + type.getSimpleName(), type)
                .getResultList();
        return objects;
    }
    @Override
    public List<T> getAll() {
        //БЕЗ ТРАНЗАКЦИИ НЕ РАБОТАЕТ
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            return getAll(session);
        }
    }
    @Override
    public T getById(Long id, Session session) {
        return session.get(type, id);
    }
    @Override
    public T getById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            //БЕЗ ТРАНЗАКЦИИ НЕ РАБОТАЕТ
            session.beginTransaction();
            return getById(id, session);
        }
    }

    @Override
    public void update(T object, Session session) {
        session.merge(object);
    }
    @Override
    public void update(T object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            update(object, session);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id, Session session) {
        T object = session.get(type, id);
        session.delete(object);
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            delete(id, session);
            session.getTransaction().commit();
        }
    }

    @Override
    public Class<T> getEntityClass() {
        return type;
    }
}