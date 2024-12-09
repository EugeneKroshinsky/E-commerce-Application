package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import org.hibernate.Session;

import java.util.List;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository{
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> getByName(String name) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("select p from Product p where p.name = :name", getType())
                    .setParameter("name", name)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
