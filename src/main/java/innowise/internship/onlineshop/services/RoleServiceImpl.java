package innowise.internship.onlineshop.services;

import innowise.internship.onlineshop.dto.RoleDto;
import innowise.internship.onlineshop.model.Role;
import innowise.internship.onlineshop.repository.RoleRepository;
import innowise.internship.onlineshop.services.base.BaseServiceImpl;
import jakarta.inject.Inject;

public class RoleServiceImpl  extends BaseServiceImpl<RoleDto, RoleDto, RoleDto, Role> implements RoleService{
    @Inject
    public RoleServiceImpl(RoleRepository repository) {
        super(RoleDto.class, repository);
    }
}
