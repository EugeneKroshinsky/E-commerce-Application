package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.mapper.ProductMapper;
import innowise.internship.onlineshop.services.OrderServiceImpl;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.ProductServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@ApplicationScoped
@WebServlet(value = "/product/*")
public class ProductServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("product", ProductMapper.toDto(request));
        getServletContext().getRequestDispatcher("/user/product.jsp").forward(request, response);
    }
}
