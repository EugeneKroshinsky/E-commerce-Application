package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.dto.FilterDto;
import innowise.internship.onlineshop.model.OrderItem;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepository;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> search(String phrase);
    void reduceQuantity(List<OrderItem> orderItems);
    List<Product> filter(FilterDto filterDto);
}
