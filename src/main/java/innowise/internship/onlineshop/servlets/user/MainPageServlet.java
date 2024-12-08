package innowise.internship.onlineshop.servlets.user;

import java.io.*;

import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.NoArgsConstructor;

@WebServlet(value = "/mainPage")
public class MainPageServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productService.getAll());
        request.setAttribute("categories", categoryService.getAll());
        getServletContext().getRequestDispatcher("/user/index.jsp").forward(request, response);
    }
}