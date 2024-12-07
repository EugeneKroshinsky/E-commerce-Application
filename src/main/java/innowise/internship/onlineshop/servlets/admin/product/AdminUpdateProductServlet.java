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
@WebServlet(value = "/admin/update/product/*")
public class AdminUpdateProductServlet extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final ProductService productService = new ProductService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        try {
            int id = Integer.parseInt(request.getPathInfo().substring(1));
            request.setAttribute("product", productService.getById(id));
            request.setAttribute("categories", categoryService.getAll());
            getServletContext().getRequestDispatcher("/admin/admin_update_product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            log.error("Invalid product ID: {}", pathInfo);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getParameter("name"));
        productEntity.setDescription(request.getParameter("description"));
        productEntity.setPrice(Double.parseDouble(request.getParameter("price")));
        productEntity.setCategoryEntity(categoryService.getById(Integer.parseInt(request.getParameter("categoryId"))));
        productEntity.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        //TODO: реализовать добавление картинок
        productEntity.setImageUrl("https://via.placeholder.com/150");
        log.info("Product: {}", productEntity);
        productService.update(id, productEntity);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
