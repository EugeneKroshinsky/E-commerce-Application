package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CartService {
    List<OrderItemDto> getCart(HttpSession session);
    void addToCart(HttpSession session, OrderItemDto item);
    void removeFromCart(HttpSession session, OrderItemDto orderItem);
}
