package com.task.nuevospa.controller;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.service.StateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateTaskController {
    private final StateTaskService stateTaskService;

    @Autowired
    public StateTaskController(StateTaskService stateTaskService) {
        this.stateTaskService = stateTaskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = stateTaskService.createNewTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = stateTaskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = stateTaskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = stateTaskService.updateTask(id, taskDetails);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        stateTaskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
