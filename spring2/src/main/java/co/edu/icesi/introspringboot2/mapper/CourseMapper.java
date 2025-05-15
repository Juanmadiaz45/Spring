package co.edu.icesi.introspringboot2.mapper;


import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "professor.id", target = "professorId")
    CourseDTO toDTO(Course course);

    @Mapping(source = "professorId", target = "professor.id")
    Course toEntity(CourseDTO dto);

}

