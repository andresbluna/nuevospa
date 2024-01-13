package com.task.nuevospa.service;


import com.task.nuevospa.repository.StateTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateTaskService {

    private final StateTaskRepository stateTaskRepository;
    @Autowired
    public StateTaskService(StateTaskRepository stateTaskRepository) {
        this.stateTaskRepository = stateTaskRepository;
    }


}
