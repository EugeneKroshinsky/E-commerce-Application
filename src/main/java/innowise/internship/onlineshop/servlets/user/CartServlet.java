package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.mappers.OrderItemMapper;
import innowise.internship.onlineshop.services.CartService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Inject
    private OrderItemMapper orderItemMapper;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cart", cartService.getCart(request));
        request.getRequestDispatcher("/user/cart.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cartService.addToCart(request, orderItemMapper.toDto(request));
        } else if ("delete".equals(action)) {
            Long productId = Long.parseLong(request.getParameter("productId"));
            cartService.removeFromCart(request, productId);
        }
        response.sendRedirect(request.getContextPath() + "/cart");
    }

}
