package innowise.internship.onlineshop;

import java.io.*;
import java.util.List;

import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.entities.User;
import innowise.internship.onlineshop.services.ProductService;
import innowise.internship.onlineshop.services.UserService;
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
        UserService userService = new UserService();
        List<User> users = userService.getAll();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (User user : users) {
            out.println("<h1>" + user.getFirstName() + "</h1>");
            out.println("<h2>" + user.getLastName() + "</h2>");
            out.println("<h3>" + user.getEmail() + "</h3>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}