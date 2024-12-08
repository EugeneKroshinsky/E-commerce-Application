package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void save(OrderDto order);
    List<OrderDto> getAll();
}
