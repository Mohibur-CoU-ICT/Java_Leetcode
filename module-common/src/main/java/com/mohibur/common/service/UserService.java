package com.mohibur.common.service;

import com.mohibur.common.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    ResponseEntity<User> createUser(User role);

    ResponseEntity<String> registerUser(User user);

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> updateUser(User role);

    ResponseEntity<?> deleteUser(Long id);
}
