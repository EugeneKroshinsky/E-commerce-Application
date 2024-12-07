package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.model.OrderEntity;
import innowise.internship.onlineshop.mapper.OrderMapper;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final GenericRepositoryImpl<OrderEntity> orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new GenericRepositoryImpl<>(OrderEntity.class);
    }

    @Override
    public void save(OrderDto order) {
        orderRepository.save(OrderMapper.toEntity(order));
    }

    @Override
    public List<OrderDto> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public OrderDto getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(OrderDto Order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }
}
