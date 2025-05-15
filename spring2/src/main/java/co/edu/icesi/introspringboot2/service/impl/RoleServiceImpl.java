package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.repository.RoleRepository;
import co.edu.icesi.introspringboot2.repository.UserRepository;
import co.edu.icesi.introspringboot2.service.RoleService;
import co.edu.icesi.introspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;



}
