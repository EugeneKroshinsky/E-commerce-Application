package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.model.ProductFilter;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.mappers.ProductFilterMapper;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/filter")
public class FilterServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    @Inject
    private ProductFilterMapper productFilterMapper;
    @Inject
    private CategoryService categoryService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductFilter productFilter = productFilterMapper.toDto(request);
        List<ProductDto> products =  productService.filter(productFilter);
        request.setAttribute("products", products);
        request.setAttribute("categories", categoryService.getAll());
        request.setAttribute("productFilter", productFilter);
        getServletContext().getRequestDispatcher("/user/index.jsp").forward(request, response);    }
}
