package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    void createCourse(CourseDTO course);
    List<CourseDTO> listCourseOfStudent(long studentId);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(long id);
    void deleteCourse(long courseId);
    Page<CourseDTO> findByNameContaining(String name, Pageable pageable);
}
