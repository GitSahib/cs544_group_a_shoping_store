package mum.edu.webstore.service;

import mum.edu.webstore.model.Role;

public interface RoleService {
    void save(Role role);
    Role findRoleByName(String name);
}
