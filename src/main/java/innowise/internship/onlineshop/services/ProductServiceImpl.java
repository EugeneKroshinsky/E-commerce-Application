package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.model.ProductEntity;
import innowise.internship.onlineshop.mapper.ProductMapper;
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
    public void save(ProductDto productDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.getAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        return ProductMapper.toDto(productRepository.getById(id));
    }

    @Override
    public void update(ProductDto productDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
