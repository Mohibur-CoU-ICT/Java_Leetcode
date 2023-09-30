package com.mohibur.leetcode.config;

import com.mohibur.leetcode.entity.Role;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface TokenProvider {
    String createToken(String username, List<Role> roles);

    String createToken(String username);

    String getUsernameFromToken(String token);

    boolean validateToken(String token, String username);

    Authentication getAuthentication(String token);
}