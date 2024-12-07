package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    void update(ProductDto productDto);
    void delete(Long id);
}
