package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.dto.UserDto;
import innowise.internship.onlineshop.services.LoginService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private LoginService loginService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (loginService.authenticate(req.getParameter("email"), req.getParameter("password"), req)){
            HttpSession session = req.getSession();
            UserDto userDto = (UserDto) session.getAttribute("user");
            req.setAttribute("user", userDto);
            getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Invalid email or password");
            req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
        }

    }
}
