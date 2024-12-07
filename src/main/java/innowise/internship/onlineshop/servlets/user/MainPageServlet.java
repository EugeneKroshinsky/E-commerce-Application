package innowise.internship.onlineshop.servlets.user;

import java.io.*;
import java.util.List;

import innowise.internship.onlineshop.entities.CategoryEntity;
import innowise.internship.onlineshop.entities.ProductEntity;
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
        List<ProductEntity> productEntities = productService.getAll();
        List<CategoryEntity> categories = categoryService.getAll();
        request.setAttribute("products", productEntities);
        request.setAttribute("categories", categories);
        getServletContext().getRequestDispatcher("/user/index.jsp").forward(request, response);
    }
}