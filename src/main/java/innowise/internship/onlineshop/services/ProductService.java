package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.ProductEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProductService {
    private final GenericRepositoryImpl<ProductEntity> productDao;

    public ProductService() {
        this.productDao = new GenericRepositoryImpl<>(ProductEntity.class);
    }

    public List<ProductEntity> getAll() {
        log.info("Fetching all products");
        List<ProductEntity> productEntities = productDao.getAll();
        log.info("Fetched {} products", productEntities.size());
        return productEntities;
    }

    public ProductEntity getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching product by ID: {}", id);
        ProductEntity productEntity = productDao.getById(id);
        if (productEntity == null) {
            log.warn("Product with ID {} not found", id);
        } else {
            log.info("Fetched product: {}", productEntity);
        }
        return productEntity;
    }

    public void save(ProductEntity productEntity) {
        if (productEntity == null) {
            log.error("Attempted to save null product");
            throw new IllegalArgumentException("Product must not be null");
        }
        log.info("Saving product: {}", productEntity);
        productDao.save(productEntity);
        log.info("Product saved successfully");
    }

    public void update(int id, ProductEntity productEntity) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (productEntity == null) {
            log.error("Attempted to update with null product");
            throw new IllegalArgumentException("Product must not be null");
        }
        log.info("Updating product with ID {}: {}", id, productEntity);
        productEntity.setId(id);
        productDao.update(productEntity);
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
