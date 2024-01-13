package com.task.nuevospa.controller;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.service.StateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        @PostMapping
        public ResponseEntity<Task> createTask (@RequestBody Task task){
            Task savedTask = taskService.createTask(task);
            return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

}
