package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class OrderMapper {
    public OrderDto toDto(HttpServletRequest request) {
        try {
            OrderDto orderDto = new OrderDto();
            BeanUtils.populate(orderDto, request.getParameterMap());
            orderDto.setOrderItems((List<OrderItemDto>) request.getSession().getAttribute("cart"));
            orderDto.setStatus("In process"); // возможно можно использовать аннотацию для генерации дефолтного значения
            return orderDto;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
