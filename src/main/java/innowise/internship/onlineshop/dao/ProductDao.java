package innowise.internship.onlineshop.dao;

import innowise.internship.onlineshop.entities.Product;
import innowise.internship.onlineshop.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao {
    private final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveProduct(Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }
    public List<Product> getAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("select p from Product p", Product.class)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
    public Product getById(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }
    public void update(int id, Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            product.setId(id);
            session.merge(product);
            session.getTransaction().commit();
        }
    }
    public void delete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
