package com.mohibur.leetcode.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;

public class CsrfController {
    /*
     * This endpoint will be used to generate a csrf token which will further used for registering a new user.
     * The csrf token is then sent as a header {"X-XSRF-TOKEN": csrfToken} in the "/users/register" endpoint.
     * For this endpoint to use we have to configure our SecurityConfig class to allow "/csrf/token" this endpoint to be csrf disabled.
     * */
    @GetMapping("/csrf/token")
    public CsrfToken csrfToken(CsrfToken token) {
        return token;
    }
}
