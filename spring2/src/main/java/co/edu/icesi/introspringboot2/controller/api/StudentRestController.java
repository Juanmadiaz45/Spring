package co.edu.icesi.introspringboot2.controller.api;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.MessageResponse;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<MessageResponse> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDTO> getCoursesByStudent(@PathVariable Long studentId) {
        return courseService.listCourseOfStudent(studentId);
    }

    @PatchMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/search")
    public List<StudentDTO> searchByProgram(@RequestParam("program") String program) {
        return studentService.getByProgram(program);
    }

    @GetMapping("/paged")
    public Page<StudentDTO> getStudentsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "name") String sortBy) {
        return studentService.findAll(page, sortBy);
    }

}
