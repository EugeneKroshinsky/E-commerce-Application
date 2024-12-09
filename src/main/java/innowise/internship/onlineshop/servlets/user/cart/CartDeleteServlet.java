package innowise.internship.onlineshop.servlets.user.cart;

import innowise.internship.onlineshop.services.CartService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cart/delete")
public class CartDeleteServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        cartService.removeFromCart(request);
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
