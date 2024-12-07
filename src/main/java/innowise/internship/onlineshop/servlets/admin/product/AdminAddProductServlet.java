package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.entities.ProductEntity;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet(value = "/admin/add/product")
public class AdminAddProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final CategoryService categoryService = new CategoryService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categories", categoryService.getAll());
        request.getRequestDispatcher("/admin/admin_add_product.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getParameter("name"));
        productEntity.setDescription(request.getParameter("description"));
        productEntity.setPrice(Double.parseDouble(request.getParameter("price")));
        productEntity.setCategoryEntity(categoryService.getById(Integer.parseInt(request.getParameter("categoryId"))));
        productEntity.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        //TODO: реализовать добавление картинок
        productEntity.setImageUrl("https://via.placeholder.com/150");
        log.info("Product: {}", productEntity);
        productService.save(productEntity);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
