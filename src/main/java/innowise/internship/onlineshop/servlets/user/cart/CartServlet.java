package innowise.internship.onlineshop.servlets.user.cart;

import innowise.internship.onlineshop.services.CartService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cart", cartService.getCart(request));
        request.getRequestDispatcher("/user/cart.jsp").forward(request, response);
    }
}
