package co.edu.icesi.introspringboot2.mapper;

import co.edu.icesi.introspringboot2.dto.ProfessorDTO;
import co.edu.icesi.introspringboot2.entity.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorDTO toDTO(Professor professor);
    Professor toEntity(ProfessorDTO professorDTO);
}

