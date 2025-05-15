package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.dto.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Professor;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfessorService {
    void createProfessor(ProfessorDTO professor);
    List<ProfessorDTO> getAllProfessor();
}
