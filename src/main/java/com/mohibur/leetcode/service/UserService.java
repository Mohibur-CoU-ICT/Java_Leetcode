package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    ResponseEntity<User> createUser(User user);

    ResponseEntity<String> registerUser(User user);

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> updateUser(User role);

    ResponseEntity<?> deleteUser(Long id);
}
