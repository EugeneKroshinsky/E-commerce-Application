package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.Order;
import innowise.internship.onlineshop.entities.OrderEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final GenericRepositoryImpl<OrderEntity> orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new GenericRepositoryImpl<>(OrderEntity.class);
    }

    @Override
    public void save(Order order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Order getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Order Order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
