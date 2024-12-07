package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.OrderEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderService {
    private final GenericRepositoryImpl<OrderEntity> orderDao;

    public OrderService() {
        this.orderDao = new GenericRepositoryImpl<>(OrderEntity.class);
    }

    public List<OrderEntity> getAll() {
        log.info("Fetching all orders");
        List<OrderEntity> orderEntities = orderDao.getAll();
        log.info("Fetched {} orders", orderEntities.size());
        return orderEntities;
    }

    public OrderEntity getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching order by ID: {}", id);
        OrderEntity orderEntity = orderDao.getById(id);
        if (orderEntity == null) {
            log.warn("Order with ID {} not found", id);
        } else {
            log.info("Fetched order: {}", orderEntity);
        }
        return orderEntity;
    }

    public void save(OrderEntity orderEntity) {
        if (orderEntity == null) {
            log.error("Attempted to save null order");
            throw new IllegalArgumentException("Order must not be null");
        }
        log.info("Saving order: {}", orderEntity);
        orderDao.save(orderEntity);
        log.info("Order saved successfully");
    }

    public void update(int id, OrderEntity orderEntity) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (orderEntity == null) {
            log.error("Attempted to update with null order");
            throw new IllegalArgumentException("Order must not be null");
        }
        log.info("Updating order with ID {}: {}", id, orderEntity);
        orderDao.update(orderEntity);
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
