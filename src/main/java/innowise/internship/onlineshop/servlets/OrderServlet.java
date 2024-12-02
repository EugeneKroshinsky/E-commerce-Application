package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.entities.Order;
import innowise.internship.onlineshop.entities.Role;
import innowise.internship.onlineshop.entities.RoleEntity;
import innowise.internship.onlineshop.entities.User;
import innowise.internship.onlineshop.services.OrderService;
import innowise.internship.onlineshop.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/order.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(Role.GUEST);
        user.setRoles(Set.of(roleEntity));
        userService.save(user);
        Order order = new Order();
    }
}
