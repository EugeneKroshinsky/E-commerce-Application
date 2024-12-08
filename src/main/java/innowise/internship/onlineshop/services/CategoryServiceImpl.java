package innowise.internship.onlineshop.services;


import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.model.CategoryEntity;
import innowise.internship.onlineshop.repository.CategoryRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;

public class CategoryServiceImpl
        extends BaseServiceImpl<CategoryDto, CategoryDto, CategoryDto, CategoryEntity> implements CategoryService {
    @Inject
    public CategoryServiceImpl(CategoryRepository repository) {
        super(CategoryDto.class, repository);
    }
}
