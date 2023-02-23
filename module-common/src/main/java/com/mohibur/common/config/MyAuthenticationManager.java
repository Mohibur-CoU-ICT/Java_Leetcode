package com.mohibur.common.config;

import com.mohibur.common.entity.User;
import com.mohibur.common.exceptions.AccountNotVerifiedException;
import com.mohibur.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyAuthenticationManager implements AuthenticationManager {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new BadCredentialsException("Invalid username or password");
        }

        User user = optionalUser.get();
        if (!user.isVerified()) {
            throw new AccountNotVerifiedException("Your account has not been verified yet.");
        }

        if (checkPassword(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    public String generateToken(String username) {
        return jwtTokenProvider.createToken(username);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
