package innowise.internship.onlineshop.servlets.manager.order;

import innowise.internship.onlineshop.services.OrderService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/manager/order")
public class ManagerOrderServlet extends HttpServlet {
    @Inject
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("orders", orderService.getAll());
        request.getRequestDispatcher("/manager/manager_orders.jsp").forward(request, response);
    }
}