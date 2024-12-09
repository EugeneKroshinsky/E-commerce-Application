package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.OrderDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class OrderMapper {
    public OrderDto toDto(HttpServletRequest request) {
        try {
            OrderDto orderDto = new OrderDto();
            BeanUtils.populate(orderDto, request.getParameterMap());
            orderDto.setOrderItems((List<OrderItemDto>) request.getSession().getAttribute("cart"));
            return orderDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
