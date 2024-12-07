package innowise.internship.onlineshop.services;

import java.util.List;

public interface CategoryService {
    void save(Object object);
    List<Object> getAll();
    Object getById(int id);
    void update(Object object);
    void delete(int id);
}
