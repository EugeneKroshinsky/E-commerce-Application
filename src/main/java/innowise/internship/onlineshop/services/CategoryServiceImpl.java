package innowise.internship.onlineshop.services;


import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.model.CategoryEntity;
import innowise.internship.onlineshop.mapper.CategoryMapper;
import innowise.internship.onlineshop.repository.BaseRepository;
import innowise.internship.onlineshop.repository.BaseRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final BaseRepository<CategoryEntity> categoryRepository;

    public CategoryServiceImpl() {
        this.categoryRepository = new BaseRepositoryImpl<CategoryEntity>(CategoryEntity.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.getAll().stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryDto getById(Long id) {
        return CategoryMapper.toDto(categoryRepository.getById(id));
    }

}
