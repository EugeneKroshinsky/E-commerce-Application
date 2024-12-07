package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    void save(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    void update(CategoryDto categoryDto);
    void delete(Long id);
}
