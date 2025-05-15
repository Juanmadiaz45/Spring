package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.mapper.CourseMapper;
import co.edu.icesi.introspringboot2.mapper.StudentMapper;
import co.edu.icesi.introspringboot2.repository.CourseRepository;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Transactional
    public void createStudent(StudentDTO studentDTO) {
        studentRepository.save(studentMapper.toEntity(studentDTO));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> studentMapper.toDTO(student)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getByProgram(String program){
        return studentRepository.findByProgram(program).stream().map(student -> studentMapper.toDTO(student)).toList();
    }

    @Override
    public Page<StudentDTO> findAll(int page, String sortBy) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        return studentRepository.findAll(pageable).map(student -> studentMapper.toDTO(student));
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(CourseDTO courseDTO) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse(courseMapper.toEntity(courseDTO));
        return enrollments.stream().map(enrollment -> studentMapper.toDTO(enrollment.getStudent())).toList();
    }

    @Override
    public StudentDTO getStudentByID(long id) {
        return studentMapper.toDTO(studentRepository.findById(id).orElseThrow());
    }

    @Override
    public StudentDTO getStudentByCode(String code) {
        return studentMapper.toDTO(studentRepository.findByCode(code).orElseThrow());
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        student.setName(studentDTO.getName() != null ? studentDTO.getName() : student.getName());
        student.setProgram(studentDTO.getProgram() != null ? studentDTO.getProgram() : student.getProgram());
        return studentMapper.toDTO(studentRepository.save(student));
    }

}
