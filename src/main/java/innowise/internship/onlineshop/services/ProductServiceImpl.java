package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ReduceDto;
import innowise.internship.onlineshop.model.ProductFilter;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.OrderItem;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.ProductRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;
import org.hibernate.Session;

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
    public List<ProductDto> filter(ProductFilter productFilter) {
        return productRepository.filter(productFilter).stream()
                .map(entity -> getMapper().map(entity, ProductDto.class))
                .toList();
    }
}
