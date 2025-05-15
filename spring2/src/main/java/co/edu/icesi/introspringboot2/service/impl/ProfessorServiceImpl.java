package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.dto.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.mapper.ProfessorMapper;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import co.edu.icesi.introspringboot2.repository.ProfessorRepository;
import co.edu.icesi.introspringboot2.repository.StudentRepository;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public void createProfessor(ProfessorDTO professorDTO) {
        var entity = professorMapper.toEntity(professorDTO);
        var returnedEntity = professorRepository.save(entity);
    }

    @Override
    public List<ProfessorDTO> getAllProfessor() {
        return professorRepository.findAll().stream().map(professor -> professorMapper.toDTO(professor)).collect(Collectors.toList());
    }
}
