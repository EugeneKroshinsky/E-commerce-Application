package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.GenericDaoImpl;
import innowise.internship.onlineshop.entities.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderService {
    private final GenericDaoImpl<Order> orderDao;

    public OrderService() {
        this.orderDao = new GenericDaoImpl<>(Order.class);
    }

    public List<Order> getAll() {
        log.info("Fetching all orders");
        List<Order> orders = orderDao.getAll();
        log.info("Fetched {} orders", orders.size());
        return orders;
    }

    public Order getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching order by ID: {}", id);
        Order order = orderDao.getById(id);
        if (order == null) {
            log.warn("Order with ID {} not found", id);
        } else {
            log.info("Fetched order: {}", order);
        }
        return order;
    }

    public void save(Order order) {
        if (order == null) {
            log.error("Attempted to save null order");
            throw new IllegalArgumentException("Order must not be null");
        }
        log.info("Saving order: {}", order);
        orderDao.save(order);
        log.info("Order saved successfully");
    }

    public void update(int id, Order order) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (order == null) {
            log.error("Attempted to update with null order");
            throw new IllegalArgumentException("Order must not be null");
        }
        log.info("Updating order with ID {}: {}", id, order);
        orderDao.update(order);
        log.info("Order updated successfully");
    }

    public void delete(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Deleting order with ID {}", id);
        orderDao.delete(id);
        log.info("Order deleted successfully");
    }
}
