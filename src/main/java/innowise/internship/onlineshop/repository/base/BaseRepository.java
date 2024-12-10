package innowise.internship.onlineshop.repository.base;

import java.util.List;
import java.util.UUID;


public interface BaseRepository<T>{
    void save(T object);
    List<T> getAll();
    T getById(Long id);
    void update(T object);
    void delete(Long id);
    Class<T> getEntityClass();
}
