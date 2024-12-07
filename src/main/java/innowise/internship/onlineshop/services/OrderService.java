package innowise.internship.onlineshop.services;

import java.util.List;

public interface OrderService {
    void save(Object order);
    List<Object> getAll();
    Object getById(int id);
    void update(Object order);
    void delete(int id);
}
