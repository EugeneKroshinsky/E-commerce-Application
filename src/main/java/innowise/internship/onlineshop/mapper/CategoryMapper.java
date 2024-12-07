package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.model.CategoryEntity;

public class CategoryMapper {
    public static CategoryDto toDto(CategoryEntity categoryEntity) {
        return new CategoryDto(
                categoryEntity.getId(),
                categoryEntity.getName()
        );
    }

    public static CategoryEntity toEntity(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDto.getName());
        categoryEntity.setId(categoryDto.getId());
        return categoryEntity;
    }
}
