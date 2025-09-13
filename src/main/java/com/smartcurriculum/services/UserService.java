package com.smartcurriculum.services;

import com.smartcurriculum.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> getUserByEmail(String email);
    List<User> getUsersByRole(String role);
    List<User> getAllUsers();
    void deleteUser(String id);
}
