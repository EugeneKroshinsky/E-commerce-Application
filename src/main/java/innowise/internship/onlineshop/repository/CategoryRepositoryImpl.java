package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.CategoryEntity;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<CategoryEntity> implements CategoryRepository {
    public CategoryRepositoryImpl() {
        super(CategoryEntity.class);
    }
}
