package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.User;

public interface UserService {
    User findByEmail(String username);
    void createUser(User user);
}
