package com.youcode.live_coding_gathergrid.service;

import com.youcode.live_coding_gathergrid.model.User;
import com.youcode.live_coding_gathergrid.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        validate(user);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private void validate(User user) {
        if (user.getFirstName().isBlank() || user.getLastName().isBlank() || user.getEmail().isBlank() || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("All fields needed");
        }
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email not valid");
        }
        if (!isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("password not valid");
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && !userRepository.isEmailTaken(email);
    }

    private boolean isValidPassword(String password) {
        return password.length() > 3;
    }
}
