package com.mohibur.security.serviceImpl;

import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.security.entity.User;
import com.mohibur.security.repository.UserRepository;
import com.mohibur.security.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<User> createUser(User user) {
        User user1 = userRepository.save(user);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(user1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> registerUser(User user) {
        try {
            // Generate a verification token
            String token = UUID.randomUUID().toString();
            user.setVerificationToken(token);
            user.setVerified(false);
            user.setActive(false);
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);

            // Send an email with the verification link
            String from = "no-reply@gmail.com";
            String to = user.getEmail();
            String subject = "Email Verification";
            String verificationUrl = "http://localhost:8080" + UrlConstant.UserUrl.VERIFY + "?token=" + token;
            String text = "Please click the link below to verify your email address:\n" + verificationUrl;

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(text);
            mailSender.send(email);

            return new ResponseEntity<>("A verification link is sent to your email. Please verify your email.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> verifyUser(String token) {
        Optional<User> optionalUser = userRepository.findByVerificationToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(true);
            user.setVerificationToken(null);
            user.setVerified(true);
            userRepository.save(user);
            return new ResponseEntity<>("Email address verified", HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Invalid verification token");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        User user = optionalUser.get();

        return new User(user.getUsername(), user.getPassword(), user.getRoleList());
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
