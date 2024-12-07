package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.mapper.CartMapper;
import innowise.internship.onlineshop.services.CartService;
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
        CartDto cartDto = CartMapper.toDto(request);

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            cartService.addToCart(session, cartDto);
        } else if ("delete".equals(action)) {
            cartService.removeFromCart(session, cartDto);
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
