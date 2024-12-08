package innowise.internship.onlineshop.repository;

import java.util.List;


public interface BaseRepository<T>{
    void save(T object);
    List<T> getAll();
    T getById(Long id);
    void update(T object);
    void delete(Long id);
}
