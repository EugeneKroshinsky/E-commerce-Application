package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.entities.ProductEntity;
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
                productEntity.getCategoryEntity().getName(),
                productEntity.getImageUrl(),
                productEntity.getQuantity()
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
}
