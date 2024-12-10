package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.OrderItem;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import org.hibernate.Session;

import java.util.List;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository{
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> search(String phrase) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("from Product where name like :phrase or description like :phrase", Product.class)
                    .setParameter("phrase", "%" + phrase + "%")
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
        public void reduceQuantity(List<OrderItem> orderItems) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            for (OrderItem item : orderItems) {
                Product product = session.get(Product.class, item.getId());
                if (product == null) {
                    throw new IllegalArgumentException("Product with ID " + item.getId() + " not found.");
                }
                if (product.getQuantity() < item.getQuantity()) {
                    throw new IllegalStateException("Not enough quantity available for product with ID " + item.getId());
                }
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
            session.getTransaction().commit();
        }
    }

}
