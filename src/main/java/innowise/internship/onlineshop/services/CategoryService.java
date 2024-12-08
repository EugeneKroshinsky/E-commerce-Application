package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
}
