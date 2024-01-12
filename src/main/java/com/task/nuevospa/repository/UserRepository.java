package com.task.nuevospa.repository;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    List<User> findByNombreUsuario(String nombreUsuario);

    @Query("SELECT t FROM Task t WHERE t.user = ?1")
    List<Task> findByUsuario(User user);

}
