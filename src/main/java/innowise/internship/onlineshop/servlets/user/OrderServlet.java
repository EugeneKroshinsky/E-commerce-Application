package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.mappers.OrderMapper;
import innowise.internship.onlineshop.services.CartService;
import innowise.internship.onlineshop.services.OrderService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    @Inject
    private OrderService orderService;
    @Inject
    private OrderMapper orderMapper;
    @Inject
    private CartService cartService;
    @Inject
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDto orderDto = orderMapper.toDto(request);
        orderService.save(orderDto);
        cartService.removeCart(request);
        request.setAttribute("order", orderDto);
        getServletContext().getRequestDispatcher("/user/order_success.jsp").forward(request, response);
    }
}
