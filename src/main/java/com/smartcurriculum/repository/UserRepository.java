package com.smartcurriculum.repository;


import com.smartcurriculum.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ===================== USER =====================
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByRollNumber(String rollNumber);
    List<User> findByRole(String role);
}

