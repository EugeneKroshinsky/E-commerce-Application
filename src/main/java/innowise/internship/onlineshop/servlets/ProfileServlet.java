package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/auth/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
        } else {
            UserDto userDto = (UserDto) session.getAttribute("user");
            req.setAttribute("user", userDto);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
    }
}
