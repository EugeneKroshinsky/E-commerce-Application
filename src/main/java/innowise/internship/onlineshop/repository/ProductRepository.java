package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Product;
import innowise.internship.onlineshop.repository.base.BaseRepository;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> search(String phrase);
}
