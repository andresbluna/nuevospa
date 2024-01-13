package com.task.nuevospa.service;

import com.task.nuevospa.model.User;
import com.task.nuevospa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }

        return user;
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new IllegalArgumentException
                ("User not found with id " + id));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserRepository.ResourceNotFoundException("User not found with id " + id));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        userRepository.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long id) {
    }
}