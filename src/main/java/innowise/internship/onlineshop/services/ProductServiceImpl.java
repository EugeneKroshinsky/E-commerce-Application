package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.OrderItem;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.ProductRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;

import java.util.List;

public class ProductServiceImpl
        extends BaseServiceImpl<ProductDto, ProductDto, ProductDto, Product> implements ProductService {
    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        super(ProductDto.class, productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> search(String phrase) {
        return productRepository.search(phrase).stream()
                .map(entity -> getMapper().map(entity, ProductDto.class)).toList();
    }

    @Override
    public void reduceQuantity(List<OrderItemDto> orderItems) {
        productRepository.reduceQuantity(
                orderItems.stream()
                .map(orderItemDto -> getMapper().map(orderItemDto, OrderItem.class))
                .toList()
        );
    }
}
