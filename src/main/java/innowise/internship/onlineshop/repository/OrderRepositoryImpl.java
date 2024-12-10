package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Order;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import innowise.internship.onlineshop.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository{
    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            String hql = "SELECT DISTINCT o " +
                    "FROM Order o " +
                    "LEFT JOIN FETCH o.user " +
                    "LEFT JOIN FETCH o.orderItems oi " +
                    "LEFT JOIN FETCH oi.product";
            List<Order> orders = session.createQuery(hql, Order.class).getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }
}
