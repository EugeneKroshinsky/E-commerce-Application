package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.entities.CategoryEntity;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CategoryService {
    private final GenericRepositoryImpl<CategoryEntity> categoryDao;

    public CategoryService() {
        this.categoryDao = new GenericRepositoryImpl<>(CategoryEntity.class);
    }

    public List<CategoryEntity> getAll() {
        log.info("Fetching all categories");
        List<CategoryEntity> categories = categoryDao.getAll();
        log.info("Fetched {} categories", categories.size());
        return categories;
    }

    public CategoryEntity getById(int id) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        log.info("Fetching category by ID: {}", id);
        CategoryEntity categoryEntity = categoryDao.getById(id);
        if (categoryEntity == null) {
            log.warn("Category with ID {} not found", id);
        } else {
            log.info("Fetched category: {}", categoryEntity);
        }
        return categoryEntity;
    }

    public void save(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            log.error("Attempted to save null category");
            throw new IllegalArgumentException("Category must not be null");
        }
        log.info("Saving category: {}", categoryEntity);
        categoryDao.save(categoryEntity);
        log.info("Category saved successfully");
    }

    public void update(int id, CategoryEntity categoryEntity) {
        if (id < 0) {
            log.error("Invalid ID: {}", id);
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        if (categoryEntity == null) {
            log.error("Attempted to update with null category");
            throw new IllegalArgumentException("Category must not be null");
        }
        log.info("Updating category with ID {}: {}", id, categoryEntity);
        categoryDao.update(categoryEntity);
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
