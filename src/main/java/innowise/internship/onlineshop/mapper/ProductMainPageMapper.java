package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.entities.OrderItemEntity;
import innowise.internship.onlineshop.entities.ProductEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ProductMainPageMapper {
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
}
