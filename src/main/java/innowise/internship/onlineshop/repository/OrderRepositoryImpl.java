package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.OrderEntity;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class OrderRepositoryImpl extends BaseRepositoryImpl<OrderEntity> implements OrderRepository{
    public OrderRepositoryImpl() {
        super(OrderEntity.class);
    }
}
