package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.dto.ProductDto;
import jakarta.servlet.http.HttpServletRequest;

public class CartMapper {
    public static CartDto toDto(HttpServletRequest request, ProductDto productDto) {
        String quantityParam = request.getParameter("quantity");
        int quantity =  quantityParam != null ? Integer.parseInt(quantityParam) : 0;
        Long productId = Long.parseLong(request.getParameter("productId"));
        return new CartDto(quantity, productDto);
    }
}
