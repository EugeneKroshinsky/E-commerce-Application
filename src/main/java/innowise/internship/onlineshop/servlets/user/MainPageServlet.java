package innowise.internship.onlineshop.servlets.user;

import java.io.*;

import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.CategoryServiceImpl;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/mainPage")
public class MainPageServlet extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        this.productService = new ProductServiceImpl();
        this.categoryService = new CategoryServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productService.getAll());
        request.setAttribute("categories", categoryService.getAll());
        getServletContext().getRequestDispatcher("/user/index.jsp").forward(request, response);
    }
}