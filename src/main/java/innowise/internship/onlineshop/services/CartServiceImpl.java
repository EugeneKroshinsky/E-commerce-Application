package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderItemDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;


public class CartServiceImpl implements CartService{
    public List<OrderItemDto> getCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<OrderItemDto> cart = (List<OrderItemDto>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void addToCart(HttpServletRequest request, OrderItemDto item) {
        List<OrderItemDto> cart = getCart(request);
        for (OrderItemDto orderItem : cart) {
            if (orderItem.getProduct().getId().equals(item.getProduct().getId())) {
                orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }

    public void removeFromCart(HttpServletRequest request) {
        Long productId = Long.parseLong(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<OrderItemDto> cart = getCart(request);
        cart.removeIf(item -> item.getProduct().getId().equals(productId));
        if(cart.isEmpty()) {
            session.removeAttribute("cart");
        }
    }
    public void removeCart(HttpServletRequest request) {
        request.getSession().removeAttribute("cart");
    }
}
