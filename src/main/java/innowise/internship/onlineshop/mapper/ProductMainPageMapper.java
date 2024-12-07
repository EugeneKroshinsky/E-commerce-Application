package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class ProductMainPageMapper {
    private static final ProductService productService = new ProductServiceImpl();
    public static ProductMainPageDto toDto(ProductEntity productEntity) {
        return new ProductMainPageDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                CategoryMapper.toDto(productEntity.getCategoryEntity()),
                productEntity.getImageUrl(),
                productEntity.getQuantity(),
                productEntity.getCreatedAt()
        );
    }
    public static ProductMainPageDto toDto(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        return productService.getById(id);
    }
    public static ProductEntity toEntity(ProductMainPageDto productMainPageDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productMainPageDto.getName());
        productEntity.setDescription(productMainPageDto.getDescription());
        productEntity.setPrice(productMainPageDto.getPrice());
        productEntity.setCategoryEntity((CategoryMapper.toEntity(productMainPageDto.getCategory())));
        productEntity.setImageUrl(productMainPageDto.getImageUrl());
        productEntity.setQuantity(productMainPageDto.getQuantity());
        productEntity.setId(productMainPageDto.getId());
        productEntity.setCreatedAt(productMainPageDto.getCreatedAt());
        return productEntity;
    }
}
