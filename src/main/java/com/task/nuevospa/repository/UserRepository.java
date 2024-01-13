package com.task.nuevospa.repository;

import com.task.nuevospa.model.Task;
import com.task.nuevospa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    List<User> findByNombreUsuario(String nombreUsuario);

    @Query("SELECT t FROM Task t WHERE t.user = ?1")
    List<Task> findByUsuario(User user);

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String message) {
            super(message);
        }

    }
}
