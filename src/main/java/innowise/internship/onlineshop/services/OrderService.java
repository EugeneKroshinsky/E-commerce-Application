package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.GenericDaoImpl;
import innowise.internship.onlineshop.entities.Order;

import java.util.List;

public class OrderService {
    private final GenericDaoImpl<Order> orderDao;

    public OrderService() {
        this.orderDao = new GenericDaoImpl<>(Order.class);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public Order getById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        return orderDao.getById(id);
    }

    public void save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
        orderDao.save(order);
    }

    public void update(int id, Order order) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
        orderDao.update(order);
    }

    public void delete(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        orderDao.delete(id);
    }
}

