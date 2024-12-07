package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.OrderEntity;
import innowise.internship.onlineshop.model.OrderItemEntity;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class CartMapper {
    private static final ProductService productService = new ProductServiceImpl();
    public static CartDto toDto(OrderItemEntity orderItemEntity) {
        return new CartDto(
                orderItemEntity.getQuantity(),
                ProductMapper.toDto(orderItemEntity.getProductEntity())
        );
    }

    public static CartDto toDto(HttpServletRequest request) {
        String quantityParam = request.getParameter("quantity");
        int quantity =  quantityParam != null ? Integer.parseInt(quantityParam) : 0;
        Long productId = Long.parseLong(request.getParameter("productId"));
        ProductDto product = productService.getById(productId);
        return new CartDto(quantity, product);
    }

    public static OrderItemEntity toEntity(CartDto cartDto, OrderEntity orderEntity) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setQuantity(cartDto.getQuantity());
        orderItemEntity.setProductEntity(ProductMapper.toEntity(cartDto.getProduct()));
        orderItemEntity.setOrderEntity(orderEntity);
        return orderItemEntity;
    }

}
