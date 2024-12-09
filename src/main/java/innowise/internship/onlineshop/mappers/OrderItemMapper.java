package innowise.internship.onlineshop.mappers;

import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.services.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;


@ApplicationScoped
public class OrderItemMapper {
    @Inject
    private ProductService productService;

    public OrderItemDto toDto(HttpServletRequest request)  {
        try {
            OrderItemDto orderItemDto = new OrderItemDto();
            BeanUtils.populate(orderItemDto, request.getParameterMap());
            Long productId = Long.parseLong(request.getParameter("productId"));
            orderItemDto.setProduct(productService.getById(productId));
            return orderItemDto;
        } catch (IllegalAccessException | InvocationTargetException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
