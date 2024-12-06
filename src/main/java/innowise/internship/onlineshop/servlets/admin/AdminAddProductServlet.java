package innowise.internship.onlineshop.servlets.admin;

import innowise.internship.onlineshop.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/add/product")
public class AdminAddProductServlet extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categories", categoryService.getAll());
        request.getRequestDispatcher("/admin/admin_add_product.jsp").forward(request, response);
    }
}
