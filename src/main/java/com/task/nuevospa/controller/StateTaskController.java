package com.task.nuevospa.controller;

import com.task.nuevospa.service.StateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateTaskController {
    private final StateTaskService stateTaskService;

    @Autowired
    public StateTaskController(StateTaskService stateTaskService) {
        this.stateTaskService = stateTaskService;
    }

}
