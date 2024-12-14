package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.model.Order;
import innowise.internship.onlineshop.model.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;

import java.util.List;

@Slf4j
public class OrderCustomConverter implements CustomConverter {
    @Override
    public Object convert(Object dest, Object source, Class<?> arg3, Class<?> arg4) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        if (source == null) {
            return null;
        }
        if (source instanceof Order) {
            return mapper.map(source, OrderDto.class);
        } else if (source instanceof OrderDto) {
            OrderDto orderDto = (OrderDto) source;
            Order order = mapper.map(source, Order.class);
            List<OrderItem> orderItems = orderDto.getOrderItems().stream()
                    .map(orderItemDto -> mapper.map(orderItemDto, OrderItem.class))
                    .peek(orderItem -> orderItem.setOrder(order))
                    .peek(orderItem -> log.info("Order item: {}", orderItem))
                    .toList();
            order.setOrderItems(orderItems);
            log.info("Order: {}", order);
            return order;
        }
        return null;
    }
}
