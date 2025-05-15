package co.edu.icesi.introspringboot2.controller.api;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentRepository enrollmentRepository;



    // Endpoint para obtener todos los cursos con su respectivo profesor
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCoursesWithProfessorId() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/{courseId}/students")
    public List<StudentDTO> getStudentsByCourse(@PathVariable long courseId) {
        var course = courseService.getCourseById(courseId);
        return studentService.getStudentsByCourse(course);
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/enrollment-count")
    public ResponseEntity<List<Map<String, Object>>> getCoursesWithEnrollmentCount() {
        List<CourseDTO> courses = courseService.getAllCourses();
        List<Map<String, Object>> result = courses.stream().map(course -> {
            Map<String, Object> map = new HashMap<>();
            map.put("course", course);
            map.put("enrollmentCount", enrollmentRepository.countByCourseId(course.getId()));
            return map;
        }).toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public Page<CourseDTO> searchCourses(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return courseService.findByNameContaining(name, pageable);
    }


}
