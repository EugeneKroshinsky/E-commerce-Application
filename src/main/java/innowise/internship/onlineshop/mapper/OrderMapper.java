package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.dto.CartDto;
import innowise.internship.onlineshop.model.OrderEntity;
import innowise.internship.onlineshop.model.OrderItemEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class OrderMapper {
    public static OrderDto toDto(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setAddress(orderEntity.getAddress());
        orderDto.setFirstName(orderEntity.getFirstName());
        orderDto.setLastName(orderEntity.getLastName());
        orderDto.setPhone(orderEntity.getPhone());
        orderDto.setEmail(orderEntity.getEmail());
        orderDto.setComment(orderEntity.getComment());
        orderDto.setStatus(orderEntity.getStatus());
        orderDto.setTotalPrice(orderEntity.getTotalPrice());
        orderDto.setCreatedAt(orderEntity.getCreatedAt());
        List<CartDto> orderItems = orderEntity.getItems().stream()
                .map(CartMapper::toDto)
                .toList();
        orderDto.setOrderItems(orderItems);
        orderDto.setUser(UserMapper.toDto(orderEntity.getUserEntity()));
        return orderDto;
    }
    public static OrderDto toDto(HttpServletRequest request) {
        HttpSession session = request.getSession();
        OrderDto orderDto = new OrderDto();
        List<CartDto> cart = (List<CartDto>) session.getAttribute("cart");
        orderDto.setOrderItems(cart);
        orderDto.setUser(null);
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
        return orderDto;
    }
    public static OrderEntity toEntity(OrderDto orderDto) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setAddress(orderDto.getAddress());
            orderEntity.setFirstName(orderDto.getFirstName());
            orderEntity.setLastName(orderDto.getLastName());
            orderEntity.setPhone(orderDto.getPhone());
            orderEntity.setEmail(orderDto.getEmail());
            orderEntity.setComment(orderDto.getComment());
            orderEntity.setStatus(orderDto.getStatus());
            orderEntity.setTotalPrice(orderDto.getTotalPrice());
            orderEntity.setCreatedAt(orderDto.getCreatedAt());
            orderEntity.setUserEntity(UserMapper.toEntity(orderDto.getUser()));

            List<OrderItemEntity> orderItemEntities = orderDto.getOrderItems().stream()
                .map(el -> CartMapper.toEntity(el, orderEntity))
                .toList();
            orderEntity.setItems(orderItemEntities);
            return orderEntity;
        }
}
