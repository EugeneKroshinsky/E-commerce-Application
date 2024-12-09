package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CartService {
    List<OrderItemDto> getCart(HttpServletRequest request);
    void addToCart(HttpServletRequest request, OrderItemDto item);
    void removeFromCart(HttpServletRequest request, Long orderItemId);
    void removeCart(HttpServletRequest request);
}
