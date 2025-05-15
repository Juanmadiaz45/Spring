package co.edu.icesi.introspringboot2.repository;


import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}