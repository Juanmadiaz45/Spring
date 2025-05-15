package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.mapper.CourseMapper;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void createCourse(CourseDTO course) {
        var entity = courseMapper.toEntity(course);
        if (courseRepository.findByName(entity.getName()).isEmpty()) {
            courseRepository.save(entity);
        } else {
            throw new RuntimeException("Course already exists");
        }
    }

    @Override
    public List<CourseDTO> listCourseOfStudent(long studentId) {
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream().map(enrollment -> courseMapper.toDTO(enrollment.getCourse())).toList();
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(course -> courseMapper.toDTO(course)).toList();
    }

    @Override
    public CourseDTO getCourseById(long id) {
        return courseMapper.toDTO(
                courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"))
        );
    }

    @Override
    public void deleteCourse(long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    @Override
    public Page<CourseDTO> findByNameContaining(String name, Pageable pageable) {
        return courseRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(courseMapper::toDTO);
    }

}
