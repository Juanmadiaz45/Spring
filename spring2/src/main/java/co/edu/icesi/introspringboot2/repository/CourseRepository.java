package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String name);

    long countByEnrollments_CourseId(Long courseId);

    Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
