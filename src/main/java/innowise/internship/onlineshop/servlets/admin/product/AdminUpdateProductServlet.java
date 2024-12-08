package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.mapper.AdminProductMapper;
import innowise.internship.onlineshop.mapper.ProductMapper;
import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.services.CategoryService;
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
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@NoArgsConstructor
@WebServlet(value = "/admin/update/product/*")
public class AdminUpdateProductServlet extends HttpServlet {
    @Inject
    private CategoryService categoryService;
    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDto productDto = ProductMapper.toDto(request);
        request.setAttribute("product", productService.getById(productDto.getId()));
        request.setAttribute("categories", categoryService.getAll());
        getServletContext().getRequestDispatcher("/admin/admin_update_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDto productDto = AdminProductMapper.toDto(request);
        productService.update(productDto);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
