package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.entities.*;
import innowise.internship.onlineshop.services.OrderService;
import innowise.internship.onlineshop.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = createOrder(request, session);
        try {
            orderService.save(order);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/order_error.jsp").forward(request, response);
            return;
        }
        session.removeAttribute("cart");
        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/order_success.jsp").forward(request, response);
    }

    private Order createOrder(HttpServletRequest request, HttpSession session) {
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        Order order = new Order();
        order.setItems(cart);
        order.setUser(null);
        order.setAddress(request.getParameter("address"));
        order.setComment(request.getParameter("comment"));
        order.setFirstName(request.getParameter("firstName"));
        order.setLastName(request.getParameter("lastName"));
        order.setEmail(request.getParameter("email"));
        order.setPhone(request.getParameter("phone"));
        order.setTotalPrice(cart.stream()
                .map(ct -> ct.getProduct().getPrice() * ct.getQuantity())
                .mapToDouble(el-> el).sum());
        return order;
    }
}
