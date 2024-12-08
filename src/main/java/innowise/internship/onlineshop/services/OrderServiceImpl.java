package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.model.OrderEntity;
import innowise.internship.onlineshop.mapper.OrderMapper;
import innowise.internship.onlineshop.repository.BaseRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final BaseRepositoryImpl<OrderEntity> orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new BaseRepositoryImpl<>(OrderEntity.class);
    }

    @Override
    public void save(OrderDto order) {
        orderRepository.save(OrderMapper.toEntity(order));
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.getAll().stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

}
