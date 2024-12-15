package innowise.internship.onlineshop.servlets.admin;

import innowise.internship.onlineshop.dto.UserDto;
import innowise.internship.onlineshop.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {
    @Inject
    private UserService userService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
    }
}
