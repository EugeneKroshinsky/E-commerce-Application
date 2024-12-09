package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.mappers.ProductMapper;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.utils.ParsePathUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin/update/product/*")
public class AdminUpdateProductServlet extends HttpServlet {
    @Inject
    private CategoryService categoryService;
    @Inject
    private ProductService productService;
    @Inject
    private ProductMapper productMapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = ParsePathUtil.parsePath(request);
        request.setAttribute("product", productService.getById(id));
        request.setAttribute("categories", categoryService.getAll());
        getServletContext().getRequestDispatcher("/admin/admin_update_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        productService.update(productMapper.toDto(request));
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
