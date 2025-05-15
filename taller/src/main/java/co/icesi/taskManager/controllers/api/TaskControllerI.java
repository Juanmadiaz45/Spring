package co.icesi.taskManager.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.icesi.taskManager.dtos.TaskDto;
import co.icesi.taskManager.mappers.TaskMapper;
import co.icesi.taskManager.model.Task;
import co.icesi.taskManager.services.interfaces.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskControllerI implements TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('VIEW_TASK')")
    public ResponseEntity<?> findAllTask() {
        List<TaskDto> taskDtos = taskService.getAllTask().stream().map(taskMapper::taskToTaskDto).toList();
        return ResponseEntity.ok(taskDtos);
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_TASK')")
    public ResponseEntity<?> addTask(@RequestBody TaskDto dto) {
        TaskDto taskDto = taskMapper.taskToTaskDto(taskService.createTask(taskMapper.taskDtoToTask(dto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto); 
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('UPDATE_TASK')")
    public ResponseEntity<?> updateTask(@RequestBody TaskDto dto) {
        Task task = taskService.updateTask(taskMapper.taskDtoToTask(dto));
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
        TaskDto taskDto = taskMapper.taskToTaskDto(task);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_TASK')")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        try{
        taskService.deleteTask(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('VIEW_TASK')")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Task task = taskService.getTaskById(id);
        if(task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Task not found"));
        }
        TaskDto taskDto = taskMapper.taskToTaskDto(task);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);        
    }
    
}
