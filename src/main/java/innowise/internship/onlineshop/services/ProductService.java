package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.ProductMainPageDto;

import java.util.List;

public interface ProductService {
    void save(ProductMainPageDto productMainPageDto);
    List<ProductMainPageDto> getAll();
    ProductMainPageDto getById(int id);
    void update(ProductMainPageDto productMainPageDto);
    void delete(int id);
}
