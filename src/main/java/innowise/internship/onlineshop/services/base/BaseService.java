package innowise.internship.onlineshop.services.base;

import java.util.List;

public interface BaseService<TDto, TCreationDto, TUpdateDto>{
    void save(TCreationDto dto);
    List<TDto> getAll();
    TDto getById(Long id);
    void update(TUpdateDto dto);
    void delete(Long id);
}
