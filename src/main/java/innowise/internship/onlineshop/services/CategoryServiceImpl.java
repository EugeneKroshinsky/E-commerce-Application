package innowise.internship.onlineshop.services;


import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.model.CategoryEntity;
import innowise.internship.onlineshop.mapper.CategoryMapper;
import innowise.internship.onlineshop.repository.GenericRepository;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final GenericRepository<CategoryEntity> categoryRepository;

    public CategoryServiceImpl() {
        this.categoryRepository = new GenericRepositoryImpl<CategoryEntity>(CategoryEntity.class);
    }
    @Override
    public void save(CategoryDto categoryDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.getAll().stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryDto getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(CategoryDto categoryDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }
}
