package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByProgram(String program);

    Page<Student> findAll(Pageable pageable);


    @Query(value = "SELECT s.id,s.name,s.code,s.program FROM domi_students s JOIN domi_enrollments e ON s.id = e.student_id JOIN domi_courses c ON e.course_id=c.id WHERE c.id = :courseId", nativeQuery = true)
    List<Student> findStudentsInCourse(long courseId);

    Optional<Student> findByCode(String code);
}
