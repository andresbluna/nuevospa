package com.task.nuevospa.service;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Read
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Update
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setNombre(updatedTask.getNombre());
            existingTask.setDescription(updatedTask.getDescription());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    // Delete
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
