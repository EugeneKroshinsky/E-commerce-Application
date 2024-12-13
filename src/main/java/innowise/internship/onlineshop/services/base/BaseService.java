package innowise.internship.onlineshop.services.base;

import org.hibernate.Session;

import java.util.List;

public interface BaseService<TDto, TCreationDto, TUpdateDto>{
    void save(TCreationDto dto);
    void save(TCreationDto dto, Session session);
    List<TDto> getAll();
    List<TDto> getAll(Session session);
    TDto getById(Long id);
    TDto getById(Long id, Session session);
    void update(TUpdateDto dto);
    void update(TUpdateDto dto, Session session);
    void delete(Long id);
    void delete(Long id, Session session);
}
