package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.entity.Course;

public interface EnrollmentService {
     void enrollStudent(long studentId, long coursId);
    void deleteEnrollmentById(long id);
}
