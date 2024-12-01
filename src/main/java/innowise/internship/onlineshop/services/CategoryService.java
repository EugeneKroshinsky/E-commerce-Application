package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dao.GenericDaoImpl;
import innowise.internship.onlineshop.entities.Category;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CategoryService {
    private final GenericDaoImpl<Category> categoryDao;

    public CategoryService() {
        this.categoryDao = new GenericDaoImpl<>(Category.class);
    }

    public List<Category> getAll() {
        log.info("Fetching all categories");
        List<Category> categories = categoryDao.getAll();
        log.info("Fetched {} categories", categories.size());
        return categories;
    }

    public Category getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching category by ID: {}", id);
        Category category = categoryDao.getById(id);
        if (category == null) {
            log.warn("Category with ID {} not found", id);
        } else {
            log.info("Fetched category: {}", category);
        }
        return category;
    }

    public void save(Category category) {
        if (category == null) {
            log.error("Attempted to save null category");
            throw new IllegalArgumentException("Category must not be null");
        }
        log.info("Saving category: {}", category);
        categoryDao.save(category);
        log.info("Category saved successfully");
    }

    public void update(int id, Category category) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (category == null) {
            log.error("Attempted to update with null category");
            throw new IllegalArgumentException("Category must not be null");
        }
        log.info("Updating category with ID {}: {}", id, category);
        categoryDao.update(category);
        log.info("Category updated successfully");
    }

    public void delete(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Deleting category with ID {}", id);
        categoryDao.delete(id);
        log.info("Category deleted successfully");
    }
}
