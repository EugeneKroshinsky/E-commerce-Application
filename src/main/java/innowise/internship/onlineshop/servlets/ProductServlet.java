package innowise.internship.onlineshop.servlets;

import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(value = "/product/*")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        try {
            int id = Integer.parseInt(request.getPathInfo().substring(1));
            request.setAttribute("product", productService.getById(id));
            getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            log.error("Invalid product ID: {}", pathInfo);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
        }

    }
}
