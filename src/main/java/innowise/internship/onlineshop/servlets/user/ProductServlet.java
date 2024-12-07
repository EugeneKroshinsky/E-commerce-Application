package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.mapper.ProductMainPageMapper;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/product/*")
public class ProductServlet extends HttpServlet {
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("product", ProductMainPageMapper.toDto(request));
        getServletContext().getRequestDispatcher("/user/product.jsp").forward(request, response);
    }
}
