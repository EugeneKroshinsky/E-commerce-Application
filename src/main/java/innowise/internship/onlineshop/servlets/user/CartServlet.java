package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.OrderItemDto;
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
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    @Inject
    private CartService cartService;
    @Inject
    private ProductService productService;
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
        Long productId = Long.parseLong(request.getParameter("productId"));
        OrderItemDto orderItemDto = OrderItemMapper.toDto(request, productService.getById(productId));

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cartService.addToCart(session, orderItemDto);
        } else if ("delete".equals(action)) {
            cartService.removeFromCart(session, orderItemDto);
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
