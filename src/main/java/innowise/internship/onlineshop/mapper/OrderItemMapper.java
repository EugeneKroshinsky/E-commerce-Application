package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ProductDto;
import jakarta.servlet.http.HttpServletRequest;

public class OrderItemMapper {
    public static OrderItemDto toDto(HttpServletRequest request, ProductDto productDto) {
        String quantityParam = request.getParameter("quantity");
        int quantity =  quantityParam != null ? Integer.parseInt(quantityParam) : 0;
        return new OrderItemDto(quantity, productDto);
    }
}
