package com.task.nuevospa.model;
import jakarta.persistence.*;

@Entity
@Table(name = "state_task")
public class StateTask {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
}

