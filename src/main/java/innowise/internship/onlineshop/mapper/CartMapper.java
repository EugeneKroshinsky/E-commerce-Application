package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.entities.OrderItemEntity;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class CartMapper {
    private static final ProductService productService = new ProductServiceImpl();
    public static CartDto toDto(OrderItemEntity orderItemEntity) {
        return new CartDto(
                orderItemEntity.getQuantity(),
                ProductMainPageMapper.toDto(orderItemEntity.getProductEntity()),
                OrderMapper.toDto(orderItemEntity.getOrderEntity())
        );
    }
    public static CartDto toDto(HttpServletRequest request) {
        String quantityParam = request.getParameter("quantity");
        int quantity =  quantityParam != null ? Integer.parseInt(quantityParam) : 0;
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductMainPageDto product = productService.getById(productId);
        return new CartDto(quantity, product, null);
    }
    public static OrderItemEntity toEntity(CartDto cartDto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setQuantity(cartDto.getQuantity());
        orderItemEntity.setProductEntity(ProductMainPageMapper.toEntity(cartDto.getProduct()));
        //orderItemEntity.setOrderEntity(OrderMapper.toEntity(orderItemDto.getOrderDto()));
        return orderItemEntity;
    }
}
