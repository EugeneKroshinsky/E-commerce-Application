package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.ProductDao;
import innowise.internship.onlineshop.entities.Product;

import java.util.List;

public class ProductService {
    private final ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDao(); // Можно заменить на Dependency Injection
    }

    public List<Product> getAll() {
        List<Product> products = productDao.getAll();
        return products;
    }

    public Product getById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        return productDao.getById(id);
    }

    public void saveProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        productDao.saveProduct(product);
    }

    public void update(int id, Product product) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        productDao.update(id, product);
    }
    public void delete(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        productDao.delete(id);
    }
}
