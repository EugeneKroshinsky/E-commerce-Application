package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.repository.GenericRepositoryImpl;
import innowise.internship.onlineshop.entities.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProductService {
    private final GenericRepositoryImpl<Product> productDao;

    public ProductService() {
        this.productDao = new GenericRepositoryImpl<>(Product.class);
    }

    public List<Product> getAll() {
        log.info("Fetching all products");
        List<Product> products = productDao.getAll();
        log.info("Fetched {} products", products.size());
        return products;
    }

    public Product getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching product by ID: {}", id);
        Product product = productDao.getById(id);
        if (product == null) {
            log.warn("Product with ID {} not found", id);
        } else {
            log.info("Fetched product: {}", product);
        }
        return product;
    }

    public void save(Product product) {
        if (product == null) {
            log.error("Attempted to save null product");
            throw new IllegalArgumentException("Product must not be null");
        }
        log.info("Saving product: {}", product);
        productDao.save(product);
        log.info("Product saved successfully");
    }

    public void update(int id, Product product) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (product == null) {
            log.error("Attempted to update with null product");
            throw new IllegalArgumentException("Product must not be null");
        }
        log.info("Updating product with ID {}: {}", id, product);
        productDao.update(product);
        log.info("Product updated successfully");
    }

    public void delete(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Deleting product with ID {}", id);
        productDao.delete(id);
        log.info("Product deleted successfully");
    }
}
