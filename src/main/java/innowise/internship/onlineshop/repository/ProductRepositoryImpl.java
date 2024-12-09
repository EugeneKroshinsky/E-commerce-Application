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
}
