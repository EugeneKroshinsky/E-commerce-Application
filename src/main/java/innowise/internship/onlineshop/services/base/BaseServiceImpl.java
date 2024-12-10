package innowise.internship.onlineshop.services.base;

import innowise.internship.onlineshop.repository.base.BaseRepository;
import jakarta.inject.Inject;
import lombok.Getter;
import org.dozer.DozerBeanMapper;

import java.util.List;


public abstract class BaseServiceImpl<TDto, TCreationDto, TUpdateDto, TEntity>
        implements BaseService<TDto, TCreationDto, TUpdateDto>{

    private Class<TDto> dtoType;
    private BaseRepository<TEntity> repository;

    @Inject
    @Getter
    private DozerBeanMapper mapper;


    public BaseServiceImpl(Class<TDto> dtoType, BaseRepository<TEntity> repository) {
        this.dtoType = dtoType;
        this.repository = repository;
    }

    @Override
    public void save(TCreationDto creationDto) {
       repository.save(mapper.map(creationDto, repository.getEntityClass()));
    }

    @Override
    public List<TDto> getAll() {
        return repository.getAll().stream()
                .map(entity -> mapper.map(entity, dtoType)).toList();
    }

    @Override
    public TDto getById(Long id) {
        return mapper.map(repository.getById(id), dtoType);
    }

    @Override
    public void update(TUpdateDto updateDto) {
        repository.update(mapper.map(updateDto, repository.getEntityClass()));
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
