package innowise.internship.onlineshop.servlets;

import java.io.*;
import java.util.List;

import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/mainPage")
public class MainPageServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}