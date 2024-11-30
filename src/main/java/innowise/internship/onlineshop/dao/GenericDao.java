package innowise.internship.onlineshop.dao;

import java.util.List;

public interface GenericDao<T>{
    void save(T object);
    List<T> getAll();
    T getById(int id);
    void update(T object);
    void delete(int id);
}
