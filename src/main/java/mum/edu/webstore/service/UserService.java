package mum.edu.webstore.service;

import mum.edu.webstore.model.Role;
import mum.edu.webstore.model.User;

public interface UserService {
    void save(User user);
    Role findRoleByName(String name);
    User findByUsername(String username);
}
