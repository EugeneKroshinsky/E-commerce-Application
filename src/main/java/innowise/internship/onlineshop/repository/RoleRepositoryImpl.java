package innowise.internship.onlineshop.repository;

import innowise.internship.onlineshop.model.Role;
import innowise.internship.onlineshop.repository.base.BaseRepositoryImpl;

public class RoleRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository {
    public RoleRepositoryImpl() {
        super(Role.class);
    }
}
