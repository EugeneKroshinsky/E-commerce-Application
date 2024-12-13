package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.FilterDto;
import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.services.base.BaseService;

import java.util.List;

public interface ProductService extends BaseService<ProductDto, ProductDto, ProductDto> {
    List<ProductDto> search(String phrase);
    void reduceQuantity(List<OrderItemDto> orderItems);
    List<ProductDto> filter(FilterDto filterDto);
}
