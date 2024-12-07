package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    public List<OrderItemDto> getCart(HttpSession session) {
        List<OrderItemDto> cart = (List<OrderItemDto>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void addToCart(HttpSession session, OrderItemDto item) {
        List<OrderItemDto> cart = getCart(session);
        for (OrderItemDto orderItem : cart) {
            if (orderItem.getProduct().getId() == item.getProduct().getId()) {
                orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }

    public void removeFromCart(HttpSession session, OrderItemDto orderItem) {
        List<OrderItemDto> cart = getCart(session);
        cart.removeIf(item -> item.getProduct().getId() == orderItem.getProduct().getId());
    }
}
