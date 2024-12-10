package innowise.internship.onlineshop.repository.base;

import innowise.internship.onlineshop.utils.HibernateUtil;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

@Getter
public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<T> type;

    public BaseRepositoryImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<T> getAll() {
        //БЕЗ ТРАНЗАКЦИИ НЕ РАБОТАЕТ
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
    public T getById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            //БЕЗ ТРАНЗАКЦИИ НЕ РАБОТАЕТ
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
    public void delete(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T object = session.get(type, id);
            session.delete(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public Class<T> getEntityClass() {
        return type;
    }
}