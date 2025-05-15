package co.icesi.taskManager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.icesi.taskManager.model.Task;
import co.icesi.taskManager.model.User;
import co.icesi.taskManager.repositories.TaskRepository;
import co.icesi.taskManager.repositories.UserRepository;
import co.icesi.taskManager.services.interfaces.TaskService;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        Task existingTask = taskRepository.findById(task.getId()).orElse(null);
        if (existingTask != null) {
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            existingTask.setNotes(task.getNotes());
            existingTask.setPriority(task.getPriority());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public void deleteTask(long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            taskRepository.delete(task);
        }
        else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }

    @Override
    public void assignTask(long taskId, long userId) {
        User user = userRepository.findById(userId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        if (user != null && task != null) {
            task.getAssignedUsers().add(user);
            user.getTasks().add(task);
            taskRepository.save(task);
            userRepository.save(user);
        }
    }

    @Override
    public void unassignTask(long taskId, long userId) {
        User user = userRepository.findById(userId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        if (user != null && task != null) {
            task.getAssignedUsers().remove(user);
            user.getTasks().remove(task);
            taskRepository.save(task);
            userRepository.save(user);
        }
        
    }

    @Override
    public Task getTaskById(long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    
}
