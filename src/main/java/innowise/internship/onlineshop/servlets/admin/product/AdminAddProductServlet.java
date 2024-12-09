package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.mapper.ProductMapper;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@NoArgsConstructor
@WebServlet(value = "/admin/add/product")
public class AdminAddProductServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categories", categoryService.getAll());
        request.getRequestDispatcher("/admin/admin_add_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProductDto productDto = ProductMapper.toDto(request);
        productService.save(productDto);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
