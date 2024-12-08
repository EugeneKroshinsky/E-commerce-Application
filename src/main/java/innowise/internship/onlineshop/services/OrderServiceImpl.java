package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.model.Order;
import innowise.internship.onlineshop.repository.OrderRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;

public class OrderServiceImpl
        extends BaseServiceImpl<OrderDto, OrderDto, OrderDto, Order> implements OrderService {
    @Inject
    public OrderServiceImpl(OrderRepository repository) {
        super(OrderDto.class, repository);
    }
}
