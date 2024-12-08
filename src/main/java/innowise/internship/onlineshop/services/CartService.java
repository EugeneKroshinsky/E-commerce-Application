package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.CartDto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CartService {
    List<CartDto> getCart(HttpSession session);
    void addToCart(HttpSession session, CartDto item);
    void removeFromCart(HttpSession session, CartDto orderItem);
}
