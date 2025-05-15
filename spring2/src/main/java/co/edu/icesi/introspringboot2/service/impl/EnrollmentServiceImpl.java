package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {


    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    @Transactional
    public void enrollStudent(long studentId, long coursId) {
        var course = new Course();
        course.setId(coursId);

        var student = new Student();
        student.setId(studentId);

        var enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        enrollmentRepository.save(enrollment);

    }

    @Override
    public void deleteEnrollmentById(long enrollmentId) {
        if (!enrollmentRepository.existsById(enrollmentId)) {
            throw new RuntimeException("Enrollment with id " + enrollmentId + " not found");
        }
        enrollmentRepository.deleteById(enrollmentId);
    }
}
