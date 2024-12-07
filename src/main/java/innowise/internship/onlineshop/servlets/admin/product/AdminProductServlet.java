package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/product")
public class AdminProductServlet extends HttpServlet {
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productServiceImpl.getAll());
        request.getRequestDispatcher("/admin/admin_product.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            Long productId = Long.parseLong(request.getParameter("id"));
            productServiceImpl.delete(productId);
        }
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
