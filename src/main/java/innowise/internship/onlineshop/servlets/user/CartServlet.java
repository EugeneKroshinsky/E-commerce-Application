package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.entities.OrderItemEntity;
import innowise.internship.onlineshop.entities.ProductEntity;
import innowise.internship.onlineshop.services.ProductServiceImpl;
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
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderItemEntity> cart = getCart(session);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/user/cart.jsp").forward(request, response);
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
            //ProductEntity productEntity = productServiceImpl.getById(productId);
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setQuantity(quantity);
            //orderItemEntity.setProductEntity(productEntity);
            addToCart(session, orderItemEntity);
        } else if ("delete".equals(action)) {
            int productId = Integer.parseInt(productIdParam);
            removeFromCart(session, productId);
        }
        response.sendRedirect(request.getContextPath() + "/cart");
    }
    private List<OrderItemEntity> getCart(HttpSession session) {
        List<OrderItemEntity> cart = (List<OrderItemEntity>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
    private void addToCart(HttpSession session, OrderItemEntity item) {
        List<OrderItemEntity> cart = getCart(session);
        for (OrderItemEntity orderItemEntity : cart) {
            if (orderItemEntity.getProductEntity().getId() == item.getProductEntity().getId()) {
                orderItemEntity.setQuantity(orderItemEntity.getQuantity() + item.getQuantity());
                return;
            }
        }
        cart.add(item);
    }
    private void removeFromCart(HttpSession session, int productId) {
        List<OrderItemEntity> cart = getCart(session);
        cart.removeIf(item -> item.getProductEntity().getId() == productId);
    }
}
