package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.entities.CartItem;
import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/cart")
public class CartServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartItem> cart = getCart(session);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String productIdParam = request.getParameter("productId");
        String quantityParam = request.getParameter("quantity");
        if ("add".equals(action)) {
            int productId = Integer.parseInt(productIdParam);
            int quantity = Integer.parseInt(quantityParam);
            Product product = productService.getById(productId);
            addToCart(session, new CartItem(product, quantity));
        } else if ("delete".equals(action)) {
            int productId = Integer.parseInt(productIdParam);
            removeFromCart(session, productId);
        }
        response.sendRedirect(request.getContextPath() + "/cart");
    }
    private List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
    private void addToCart(HttpSession session, CartItem item) {
        List<CartItem> cart = getCart(session);
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getId() == item.getProduct().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }
    private void removeFromCart(HttpSession session, int productId) {
        List<CartItem> cart = getCart(session);
        cart.removeIf(item -> item.getProduct().getId() == productId);
    }
}
