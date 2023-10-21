package com.mohibur.leetcode.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class MyAuditorAware implements AuditorAware<String> {

    static String user = "SYSTEM";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(user);
    }
}
