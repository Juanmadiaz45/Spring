package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.repository.UserRepository;
import co.edu.icesi.introspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username).orElseThrow();
    }

    @Override
    public void createUser(User user) {
        boolean emailExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (emailExists) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
