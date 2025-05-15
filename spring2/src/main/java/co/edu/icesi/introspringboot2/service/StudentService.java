package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    void createStudent(StudentDTO student);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> getByProgram(String program);
    Page<StudentDTO> findAll(int page, String sortBy);
    List<StudentDTO> getStudentsByCourse(CourseDTO course);
    StudentDTO getStudentByID(long id);
    StudentDTO getStudentByCode(String code);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
}
