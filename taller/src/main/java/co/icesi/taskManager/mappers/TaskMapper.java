package co.icesi.taskManager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.icesi.taskManager.dtos.TaskDto;
import co.icesi.taskManager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    
    TaskDto taskToTaskDto(Task task);

    @Mapping(target = "assignedUsers", ignore = true)
    Task taskDtoToTask(TaskDto task);
}
