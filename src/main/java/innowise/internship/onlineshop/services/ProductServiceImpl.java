package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.ProductMainPageDto;
import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.mapper.ProductMainPageMapper;
import innowise.internship.onlineshop.repository.GenericRepository;
import innowise.internship.onlineshop.repository.GenericRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private final GenericRepository<ProductEntity> productRepository;

    public ProductServiceImpl() {
        this.productRepository = new GenericRepositoryImpl<>(ProductEntity.class);
    }

    @Override
    public void save(ProductMainPageDto productMainPageDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ProductMainPageDto> getAll() {
        return productRepository.getAll().stream()
                .map(ProductMainPageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductMainPageDto getById(int id) {
        return ProductMainPageMapper.toDto(productRepository.getById(id));
    }

    @Override
    public void update(ProductMainPageDto productMainPageDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
