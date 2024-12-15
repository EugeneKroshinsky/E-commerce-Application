package innowise.internship.onlineshop.servlets;


import innowise.internship.onlineshop.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(value = {"/manager/*"})
public class ManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
            UserDto userDto = (UserDto) session.getAttribute("user");
            if (userDto.getRoles().stream()
                    .map(el -> el.getName())
                    .toList()
                    .contains("MANAGER")) {
                filterChain.doFilter(servletRequest, servletResponse);
                response.sendRedirect(request.getContextPath() + "/profile");
            } else {
                request.setAttribute("error", "You don't have permission to access this page");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
