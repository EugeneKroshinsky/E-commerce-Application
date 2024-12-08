/*
package innowise.internship.onlineshop.services.base;

import innowise.internship.onlineshop.repository.BaseRepository;

import java.util.List;

public abstract class BaseServiceImpl<TDto, TCreationDto, TUpdateDto, TEntity>
        implements BaseService<TDto, TCreationDto, TUpdateDto>{

    private final BaseRepository<TEntity> repository;

    @Override
    public void save(TCreationDto creationDto) {
        //mapping
        repository.save(toEntity(creationDto));
    }

    @Override
    public List<TDto> getAll() {
        repository.getAll().stream()
                .map(this::toDto)  //mapping
                .toList();
    }

    @Override
    public TDto getById(Long id) {
        repository.getById(id); //mapping
    }

    @Override
    public void update(TUpdateDto dto) {
        repository.update(toEntity(dto)); //mapping
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
*/
