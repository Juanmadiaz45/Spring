package co.edu.icesi.introspringboot2.repository;


import co.edu.icesi.introspringboot2.entity.Role;
import co.edu.icesi.introspringboot2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> { }
