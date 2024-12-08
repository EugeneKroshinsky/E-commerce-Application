package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Category;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category> implements CategoryRepository {
    public CategoryRepositoryImpl() {
        super(Category.class);
    }
}
