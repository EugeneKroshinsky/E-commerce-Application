package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.ProductFilter;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Slf4j
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository{
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> search(String phrase) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery(
                            "from Product where lower(name) like :phrase or lower(description) like :phrase",
                            Product.class
                    )
                    .setParameter("phrase", "%" + phrase.toLowerCase() + "%")
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }

    }

    //не самый лучший код, но чтобы работало
    @Override
    public List<Product> filter(ProductFilter productFilter) {
        log.info("FilterDto: {}", productFilter);
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            String hql = createHql(productFilter);
            List<Product> products =  getProducts(hql, session, productFilter);
            return products;
        }
    }

    private String createHql(ProductFilter productFilter) {
        StringBuilder hql = new StringBuilder("""
                    FROM Product p WHERE 1=1
                    AND p.price >= :minPrice
                    AND p.price <= :maxPrice
                """);
        if (!productFilter.getCategoryFilter().isEmpty()) {
            hql.append("AND p.category.name like :category");
        }
        switch (productFilter.getSort()) {
            case "price_asc":
                hql.append(" ORDER BY p.price ASC");
                break;
            case "price_desc":
                hql.append(" ORDER BY p.price DESC");
                break;
            case "name":
                hql.append(" ORDER BY p.name ASC");
                break;
            case "date":
                hql.append(" ORDER BY p.createdAt DESC");
                break;
        }
        return hql.toString();
    }
    private List<Product> getProducts(String hql, Session session, ProductFilter productFilter) {
        Query<Product> query = session.createQuery(hql, Product.class);
        if (!productFilter.getCategoryFilter().isEmpty()) {
            query.setParameter("category", productFilter.getCategoryFilter());
        }
        query.setParameter("minPrice", productFilter.getMinPrice());
        query.setParameter("maxPrice", productFilter.getMaxPrice());
        return query.list();
    }
}
