package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import innowise.internship.onlineshop.utils.ParsePathUtil;
import jakarta.servlet.http.HttpServletRequest;

public class ProductMapper {
    private static final ProductService productService = new ProductServiceImpl();
    public static ProductDto toDto(ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                CategoryMapper.toDto(productEntity.getCategoryEntity()),
                productEntity.getImageUrl(),
                productEntity.getQuantity()
        );
    }
    public static ProductDto toDto(HttpServletRequest request) {
        Long id = ParsePathUtil.parsePath(request);
        return productService.getById(id);
    }
    public static ProductEntity toEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategoryEntity((CategoryMapper.toEntity(productDto.getCategory())));
        productEntity.setImageUrl(productDto.getImageUrl());
        productEntity.setQuantity(productDto.getQuantity());
        productEntity.setId(productDto.getId());
        return productEntity;
    }
}
