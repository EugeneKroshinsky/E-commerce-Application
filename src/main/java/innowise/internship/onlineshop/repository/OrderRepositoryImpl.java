package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Order;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository{
    public OrderRepositoryImpl() {
        super(Order.class);
    }
}
