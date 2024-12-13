package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.model.ProductFilter;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.services.base.BaseService;

import java.util.List;

public interface ProductService extends BaseService<ProductDto, ProductDto, ProductDto> {
    List<ProductDto> search(String phrase);
    List<ProductDto> filter(ProductFilter productFilter);
}
