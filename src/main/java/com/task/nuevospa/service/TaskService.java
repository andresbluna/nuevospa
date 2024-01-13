package com.task.nuevospa.service;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.repository.TaskRepository;
import com.task.nuevospa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Task updateTaskName(Long id, Task updatedTask) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setName(updatedTask.getName());
            this.taskRepository.save(existingTask);
            return existingTask;
        } else {
            throw new UserRepository.ResourceNotFoundException("Task", "id", id);
        }
    }

    // Delete
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();

            existingTask.setName(updatedTask.getName());
            existingTask.setDescription(updatedTask.getDescription());

            return this.taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }

    }
}
