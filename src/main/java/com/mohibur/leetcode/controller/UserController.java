package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.User;
import com.mohibur.leetcode.interfaces.UrlConstant;
import com.mohibur.leetcode.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping(UrlConstant.UserUrl.GET)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping(UrlConstant.UserUrl.REGISTER)
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping(UrlConstant.UserUrl.VERIFY)
    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
        return userService.verifyUser(token);
    }

    @GetMapping(UrlConstant.UserUrl.GET + UrlConstant.ID)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(UrlConstant.UserUrl.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(UrlConstant.UserUrl.GET)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(UrlConstant.UserUrl.GET + UrlConstant.ID)
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
