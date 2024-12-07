package innowise.internship.onlineshop.services;


import innowise.internship.onlineshop.entities.CategoryEntity;
import innowise.internship.onlineshop.repository.GenericRepository;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final GenericRepository<CategoryEntity> categoryRepository;

    public CategoryServiceImpl() {
        this.categoryRepository = new GenericRepositoryImpl<CategoryEntity>(CategoryEntity.class);
    }
    @Override
    public void save(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
