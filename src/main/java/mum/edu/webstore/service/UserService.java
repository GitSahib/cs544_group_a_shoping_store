package mum.edu.webstore.service;

import mum.edu.webstore.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
