package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class ProductRepositoryImpl extends BaseRepositoryImpl<ProductEntity> implements ProductRepository{
    public ProductRepositoryImpl() {
        super(ProductEntity.class);
    }
}
