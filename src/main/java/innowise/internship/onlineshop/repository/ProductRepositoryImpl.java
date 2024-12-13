package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.dto.FilterDto;
import innowise.internship.onlineshop.model.OrderItem;
import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;
import jakarta.servlet.http.HttpSession;
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
                Product product = session.get(Product.class, item.getProduct().getId());
                if (product == null) {
                    throw new IllegalArgumentException("Product with ID " + item.getId() + " not found.");
                }
                if (product.getQuantity() < item.getQuantity()) {
                    throw new IllegalStateException("Not enough quantity available for product with ID " + product.getId());
                }
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
            session.getTransaction().commit();
        }
    }

    //не самый лучший код, но чтобы работало
    @Override
    public List<Product> filter(FilterDto filterDto) {
        log.info("FilterDto: {}", filterDto);
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            String hql = createHql(filterDto);
            List<Product> products =  getProducts(hql, session, filterDto);
            return products;
        }
    }

    private String createHql(FilterDto filterDto) {
        StringBuilder hql = new StringBuilder("""
                    FROM Product p WHERE 1=1
                    AND p.price >= :minPrice
                    AND p.price <= :maxPrice
                """);
        if (!filterDto.getCategoryFilter().isEmpty()) {
            hql.append("AND p.category.name like :category");
        }
        switch (filterDto.getSort()) {
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
    private List<Product> getProducts(String hql, Session session, FilterDto filterDto) {
        Query<Product> query = session.createQuery(hql, Product.class);
        if (!filterDto.getCategoryFilter().isEmpty()) {
            query.setParameter("category", filterDto.getCategoryFilter());
        }
        query.setParameter("minPrice", filterDto.getMinPrice());
        query.setParameter("maxPrice", filterDto.getMaxPrice());
        return query.list();
    }
}
