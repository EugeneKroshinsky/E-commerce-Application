package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.entities.OrderItemEntity;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class OrderItemMapper {
    private static final ProductService productService = new ProductServiceImpl();
    public static OrderItemDto toDto(OrderItemEntity orderItemEntity) {
        return new OrderItemDto(
                orderItemEntity.getQuantity(),
                ProductMainPageMapper.toDto(orderItemEntity.getProductEntity())
        );
    }
    public static OrderItemDto toDto(HttpServletRequest request) {
        String quantityParam = request.getParameter("quantity");
        int quantity =  quantityParam != null ? Integer.parseInt(quantityParam) : 0;
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductMainPageDto product = productService.getById(productId);
        return new OrderItemDto(quantity, product);
    }
}
