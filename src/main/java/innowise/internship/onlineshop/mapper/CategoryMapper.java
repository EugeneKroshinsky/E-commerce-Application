package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.entities.CategoryEntity;

public class CategoryMapper {
    public static CategoryDto toDto(CategoryEntity categoryEntity) {
        return new CategoryDto(
                categoryEntity.getId(),
                categoryEntity.getName()
        );
    }
}
