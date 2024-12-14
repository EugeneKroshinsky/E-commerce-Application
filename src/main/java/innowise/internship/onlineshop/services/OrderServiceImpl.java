package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.OrderDto;
import innowise.internship.onlineshop.dto.OrderItemDto;
import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.Order;
import innowise.internship.onlineshop.repository.OrderRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import innowise.internship.onlineshop.utils.HibernateUtil;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Slf4j
public class OrderServiceImpl
        extends BaseServiceImpl<OrderDto, OrderDto, OrderDto, Order> implements OrderService {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Inject
    private ProductService productService;
    @Inject
    public OrderServiceImpl(OrderRepository repository) {
        super(OrderDto.class, repository);
    }
    @Override
    public void save(OrderDto orderDto) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            this.save(orderDto, session);
            for (OrderItemDto item : orderDto.getOrderItems()) {
                ProductDto productDto = productService.getById(item.getProductId(), session);
                productDto.setQuantity(productDto.getQuantity() - item.getQuantity());
                productService.update(productDto, session);
            }
            session.getTransaction().commit();
        }
    }
}
