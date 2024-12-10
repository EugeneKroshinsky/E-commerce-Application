package innowise.internship.onlineshop.servlets.user.cart;

import innowise.internship.onlineshop.mappers.CartItemMapper;
import innowise.internship.onlineshop.services.CartService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cart/add")
public class CartAddServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Inject
    private CartItemMapper cartItemMapper;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            cartService.addToCart(request, cartItemMapper.toDto(request));
            response.sendRedirect(request.getContextPath() + "/cart");
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/user/cart.jsp").forward(request, response);
        }
    }
}
