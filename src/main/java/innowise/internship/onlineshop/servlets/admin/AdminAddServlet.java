package innowise.internship.onlineshop.servlets.admin;

import innowise.internship.onlineshop.mappers.UserMapper;
import innowise.internship.onlineshop.services.RoleService;
import innowise.internship.onlineshop.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/add")
public class AdminAddServlet extends HttpServlet {
    @Inject
    private RoleService roleService;
    @Inject
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", roleService.getAll());
        req.getRequestDispatcher("/admin/admin_add.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.save(UserMapper.toDto(req));
        req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
    }
}
