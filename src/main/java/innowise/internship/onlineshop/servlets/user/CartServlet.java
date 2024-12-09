package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.mapper.OrderItemMapper;
import innowise.internship.onlineshop.services.CartService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Inject
    private ProductService productService;
    @Inject
    private OrderItemMapper orderItemMapper;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("cart", cartService.getCart(session));
        request.getRequestDispatcher("/user/cart.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cartService.addToCart(session, orderItemMapper.toDto(request));
        } else if ("delete".equals(action)) {
            Long productId = Long.parseLong(request.getParameter("productId"));
            cartService.removeFromCart(session, productId);
        }
        response.sendRedirect(request.getContextPath() + "/cart");
    }

}
