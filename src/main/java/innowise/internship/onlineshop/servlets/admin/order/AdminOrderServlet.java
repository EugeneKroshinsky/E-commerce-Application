package innowise.internship.onlineshop.servlets.admin.order;

import innowise.internship.onlineshop.services.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/order2")
public class AdminOrderServlet extends HttpServlet {
    private final OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("orders", orderServiceImpl.getAll());
        request.getRequestDispatcher("/admin/admin_orders.jsp").forward(request, response);
    }
}
