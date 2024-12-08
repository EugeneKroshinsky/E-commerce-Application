package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.dto.ProductEditDto;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.ProductRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;


public class ProductServiceImpl
        extends BaseServiceImpl<ProductDto, ProductEditDto, ProductEditDto, Product> implements ProductService {

    @Inject
    public ProductServiceImpl(ProductRepository repository) {
        super(ProductDto.class, repository);
    }
}
