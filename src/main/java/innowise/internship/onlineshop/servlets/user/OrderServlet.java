package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.entities.*;
import innowise.internship.onlineshop.services.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    private final OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderEntity orderEntity = createOrder(request, session);
        try {
            //orderServiceImpl.save(orderEntity);
        } catch (Exception e) {
            log.error("Failed to save order", e);
            getServletContext().getRequestDispatcher("/user/order_error.jsp").forward(request, response);
            return;
        }
        session.removeAttribute("cart");
        request.setAttribute("order", orderEntity);
        getServletContext().getRequestDispatcher("/user/order_success.jsp").forward(request, response);
    }

    //TODO: Реализовать логику удаления заказанных товраов из базы данных

    private OrderEntity createOrder(HttpServletRequest request, HttpSession session) {
        List<OrderItemEntity> cart = (List<OrderItemEntity>) session.getAttribute("cart");
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setItems(cart);
        orderEntity.setUserEntity(null);
        orderEntity.setAddress(request.getParameter("address"));
        orderEntity.setComment(request.getParameter("comment"));
        orderEntity.setFirstName(request.getParameter("firstName"));
        orderEntity.setLastName(request.getParameter("lastName"));
        orderEntity.setEmail(request.getParameter("email"));
        orderEntity.setPhone(request.getParameter("phone"));
        orderEntity.setTotalPrice(cart.stream()
                .map(ct -> ct.getProductEntity().getPrice() * ct.getQuantity())
                .mapToDouble(el-> el).sum());
        log.info("Order: {}", orderEntity);
        return orderEntity;
    }
}
