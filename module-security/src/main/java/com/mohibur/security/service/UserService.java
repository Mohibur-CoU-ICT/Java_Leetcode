package com.mohibur.security.service;

import com.mohibur.security.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    ResponseEntity<User> createUser(User role);

    ResponseEntity<String> registerUser(User user);

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> updateUser(User role);

    ResponseEntity<?> deleteUser(Long id);
}
