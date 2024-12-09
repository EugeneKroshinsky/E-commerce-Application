package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/search")
public class SearchServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchParam = request.getParameter("search");
        request.setAttribute("products", productService.search(searchParam));
        getServletContext().getRequestDispatcher("/user/index.jsp").forward(request, response);
    }
}
