package innowise.internship.onlineshop.servlets.admin.product;

import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.services.CategoryServiceImpl;
import innowise.internship.onlineshop.services.ProductServiceImpl;
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
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    private final CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categories", categoryServiceImpl.getAll());
        request.getRequestDispatcher("/admin/admin_add_product.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getParameter("name"));
        productEntity.setDescription(request.getParameter("description"));
        productEntity.setPrice(Double.parseDouble(request.getParameter("price")));
        productEntity.setCategoryEntity(categoryServiceImpl.getById(Integer.parseInt(request.getParameter("categoryId"))));
        productEntity.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        //TODO: реализовать добавление картинок
        productEntity.setImageUrl("https://via.placeholder.com/150");
        log.info("Product: {}", productEntity);
        productServiceImpl.save(productEntity);
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
