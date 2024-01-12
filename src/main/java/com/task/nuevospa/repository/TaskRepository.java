package com.task.nuevospa.repository;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.user = ?1")
    List<Task> findByUsuario(User user);

    @Query("SELECT t FROM Task t WHERE t.username = ?1")
    List<Task> findByName(String username);

}
