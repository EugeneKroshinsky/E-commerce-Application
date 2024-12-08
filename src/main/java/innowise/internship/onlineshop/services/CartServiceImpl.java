package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.CartDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;


public class CartServiceImpl implements CartService{

    public List<CartDto> getCart(HttpSession session) {
        List<CartDto> cart = (List<CartDto>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void addToCart(HttpSession session, CartDto item) {
        List<CartDto> cart = getCart(session);
        for (CartDto orderItem : cart) {
            if (orderItem.getProduct().getId() == item.getProduct().getId()) {
                orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }

    public void removeFromCart(HttpSession session, CartDto orderItem) {
        List<CartDto> cart = getCart(session);
        cart.removeIf(item -> item.getProduct().getId() == orderItem.getProduct().getId());
        if(cart.isEmpty()) {
            session.removeAttribute("cart");
        }
    }
}
