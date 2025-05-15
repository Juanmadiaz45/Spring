package co.edu.icesi.introspringboot2.mapper;

import co.edu.icesi.introspringboot2.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.icesi.introspringboot2.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
}
