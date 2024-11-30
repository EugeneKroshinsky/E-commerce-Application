package innowise.internship.onlineshop;

import java.io.*;
import java.util.List;

import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ProductService productService = new ProductService();
        List<Product> products = productService.getAll();

        // Hello
        PrintWriter out = response.getWriter();
        for (Product product : products) {
            out.println("<h1>" + product.getName() + "</h1>");
            out.println("<p>" + product.getDescription() + "</p>");
            out.println("<p>" + product.getPrice() + "</p>");
            out.println("<p>" + product.getQuantity() + "</p>");
            out.println("<p>" + product.getCategory() + "</p>");
            out.println("<p>" + product.getImageUrl() + "</p>");
            out.println("<p>" + product.getCreatedAt() + "</p>");
        }
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}