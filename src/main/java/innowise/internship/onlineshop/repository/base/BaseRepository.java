package innowise.internship.onlineshop.repository.base;

import org.hibernate.Session;

import java.util.List;


public interface BaseRepository<T>{
    void save(T object, Session session);
    void save(T object);
    List<T> getAll(Session session);
    List<T> getAll();
    T getById(Long id, Session session);
    T getById(Long id);
    void update(T object, Session session);
    void update(T object);
    void delete(Long id, Session session);
    void delete(Long id);
    Class<T> getEntityClass();
}
