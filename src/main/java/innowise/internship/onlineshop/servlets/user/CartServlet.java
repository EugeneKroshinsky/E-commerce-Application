package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.mapper.OrderItemMapper;
import innowise.internship.onlineshop.services.CartService;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    private CartService cartService;

    @Override
    public void init() {
        this.cartService = new CartService();
    }

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
        OrderItemDto orderItemDto = OrderItemMapper.toDto(request);

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cartService.addToCart(session, orderItemDto);
        } else if ("delete".equals(action)) {
            cartService.removeFromCart(session, orderItemDto);
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
