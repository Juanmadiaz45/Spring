package co.edu.icesi.introspringboot2.controller.api;

import co.edu.icesi.introspringboot2.dto.EnrollmentRequest;
import co.edu.icesi.introspringboot2.dto.MessageResponse;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentRestController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity enrollStudent(@RequestBody EnrollmentRequest request) {
        enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable long id) {
        enrollmentService.deleteEnrollmentById(id);
        return ResponseEntity.noContent().build();
    }

}
