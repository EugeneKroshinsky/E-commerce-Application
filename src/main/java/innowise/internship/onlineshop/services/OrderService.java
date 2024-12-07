package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
    List<Order> getAll();
    Order getById(int id);
    void update(Order Order);
    void delete(int id);
}
