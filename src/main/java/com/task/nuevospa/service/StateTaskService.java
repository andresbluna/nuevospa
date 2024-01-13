package com.task.nuevospa.service;


import com.task.nuevospa.model.StateTask;
import com.task.nuevospa.model.Task;
import com.task.nuevospa.repository.StateTaskRepository;
import com.task.nuevospa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateTaskService {

    private final StateTaskRepository stateTaskRepository;
    private final TaskService taskService;

    @Autowired
    public StateTaskService(StateTaskRepository stateTaskRepository, TaskService taskService) {
        this.stateTaskRepository = stateTaskRepository;
        this.taskService = taskService;
    }

    public Task createNewTask(Task task) {
        return this.taskService.createTask(task);
    }

    public List<Task> retrieveAllTasks() {
        return this.taskService.getAllTasks();
    }

    public List<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    public Task getTaskById(Long id) {
        Optional<StateTask> optionalTask = this.stateTaskRepository.findById(id);

        if (optionalTask.isPresent()) {
            return optionalTask.get().getTask();
        } else {
            throw new UserRepository.ResourceNotFoundException("Task", "id", id);
        }
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<StateTask> optionalTask = this.stateTaskRepository.findById(id);
        if (optionalTask.isPresent()) {
            StateTask stateTask = optionalTask.get();
            Task currentTask = stateTask.getTask();
            if(currentTask != null) {
                currentTask.setName(taskDetails.getName());
                currentTask.setDescription(taskDetails.getDescription());
                this.stateTaskRepository.save(stateTask);
                return currentTask;
            } else {
                throw new UserRepository.ResourceNotFoundException("Task", "id", id);
            }
        } else {
            throw new UserRepository.ResourceNotFoundException("StateTask", "id", id);
        }
    }

    public void deleteTask(Long id) {
        if (this.stateTaskRepository.existsById(id)) {
            this.stateTaskRepository.deleteById(id);
        } else {
            throw new UserRepository.ResourceNotFoundException("Task", "id", id);
        }
    }
}
