package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.services.CategoryServiceImpl;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;

import java.io.IOException;

@WebServlet(value = "/admin/product")
public class AdminProductServlet extends HttpServlet {
    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productService.getAll());
        request.getRequestDispatcher("/admin/admin_product.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("id"));
        productService.delete(productId);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
