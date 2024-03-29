package com.mohibur.leetcode.serviceImpl;

import com.mohibur.leetcode.entity.User;
import com.mohibur.leetcode.repository.UserRepository;
import com.mohibur.leetcode.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<User> createUser(User user) {
        User user1 = userRepository.save(user);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(user1, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(users, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            BeanUtils.copyProperties(user, user1);
            userRepository.save(user1);
            return new ResponseEntity<>(user1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No user found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
