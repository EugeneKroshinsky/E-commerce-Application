package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.mapper.OrderMapper;
import innowise.internship.onlineshop.services.OrderService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@NoArgsConstructor
@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    @Inject
    private OrderService orderService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderDto orderDto = OrderMapper.toDto(request);
        orderService.save(orderDto);
        session.removeAttribute("cart");
        request.setAttribute("order", orderDto);
        getServletContext().getRequestDispatcher("/user/order_success.jsp").forward(request, response);
    }
}
