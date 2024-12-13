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

        //TODO: это неправильно сохранять и удалять в разных транзакциях, но чтобы красиво реализовать
        // надо провести небольшой рефакторинг, пока оставлю так
        //TODO: я бы решил эту проблему, каким-то образом вынеся транзакции из repository,
        //TODO: в сервисный слой, т.к. по идее в repository нельзя сделать метод который
        // будет менять две разные сущности (вообще, можно, но с точки зрения архитектуры скорее всего печально)
        orderService.save(orderDto);
        productService.reduceQuantity(orderDto.getOrderItems());

        cartService.removeCart(request);
        request.setAttribute("order", orderDto);
        getServletContext().getRequestDispatcher("/user/order_success.jsp").forward(request, response);
    }
}
