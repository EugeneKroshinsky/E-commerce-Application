package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.dto.FilterDto;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.mappers.FilterMapper;
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
    private FilterMapper filterMapper;
    @Inject
    private CategoryService categoryService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FilterDto filterDto = filterMapper.toDto(request);
        List<ProductDto> products =  productService.filter(filterDto);
        request.setAttribute("products", products);
        request.setAttribute("categories", categoryService.getAll());
        request.setAttribute("filterDto", filterDto);
        request.getRequestDispatcher("/user/index.jsp").forward(request, response);
    }
}
