package com.mohibur.security.entity;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
