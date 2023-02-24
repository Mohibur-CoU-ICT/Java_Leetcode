package com.mohibur.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@SpringBootApplication
        (
                scanBasePackages = {
                        "com.mohibur.common",
                        "com.mohibur.discussion",
                        "com.mohibur.problem_solving",
                        "com.mohibur.security"
                }
        )
public class LeetcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
	}

}
