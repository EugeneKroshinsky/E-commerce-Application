package innowise.internship.onlineshop.servlets;

import java.io.*;
import java.util.List;

import innowise.internship.onlineshop.entities.Category;
import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/mainPage")
public class MainPageServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final CategoryService categoryService = new CategoryService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        response.getWriter().println("Categories: " + categories.size());
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}