package innowise.internship.onlineshop.servlets.admin;

import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/product")
public class AdminProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productService.getAll());
        request.getRequestDispatcher("/admin/admin_product.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        if ("delete".equals(action)) {
            int productId = Integer.parseInt(id);
            productService.delete(productId);
        }
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
