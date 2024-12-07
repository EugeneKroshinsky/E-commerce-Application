package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.OrderEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final GenericRepositoryImpl<OrderEntity> orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new GenericRepositoryImpl<>(OrderEntity.class);
    }

    @Override
    public void save(Object order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object Order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
