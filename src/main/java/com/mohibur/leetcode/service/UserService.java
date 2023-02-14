package com.mohibur.leetcode.service;

import com.mohibur.leetcode.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    ResponseEntity<User> createUser(User role);

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> updateUser(User role);

    ResponseEntity<?> deleteUser(Long id);
}
