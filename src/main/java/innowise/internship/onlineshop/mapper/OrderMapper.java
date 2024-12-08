package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class OrderMapper {
    public static OrderDto toDto(HttpServletRequest request) {
        HttpSession session = request.getSession();
        OrderDto orderDto = new OrderDto();
        orderDto.setUser(null);
        List<CartDto> cart = (List<CartDto>) session.getAttribute("cart");
        orderDto.setAddress(request.getParameter("address"));
        orderDto.setComment(request.getParameter("comment"));
        orderDto.setFirstName(request.getParameter("firstName"));
        orderDto.setLastName(request.getParameter("lastName"));
        orderDto.setEmail(request.getParameter("email"));
        orderDto.setPhone(request.getParameter("phone"));
        orderDto.setStatus("In process");
        orderDto.setTotalPrice(cart.stream()
                .map(ct -> ct.getProduct().getPrice() * ct.getQuantity())
                .mapToDouble(el-> el).sum());
        orderDto.setOrderItems(cart);
        return orderDto;
    }
}
