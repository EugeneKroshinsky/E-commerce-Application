package innowise.internship.onlineshop.servlets.user;

import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.utils.ParsePathUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/product/*")
public class ProductServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = ParsePathUtil.parsePathLong(request);
        request.setAttribute("product", productService.getById(id));
        getServletContext().getRequestDispatcher("/user/product.jsp").forward(request, response);
    }
}
