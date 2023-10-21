package com.mohibur.leetcode.config;

import com.mohibur.leetcode.interfaces.UrlConstant;
import com.mohibur.leetcode.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Autowired
    UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Inside configure(HttpSecurity http) method of SecurityConfig class");
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/public/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .formLogin()
//                .and()
//                .logout()
        ;

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Inside configure(AuthenticationManagerBuilder auth) method of SecurityConfig class");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        System.out.println("Inside authenticationManagerBean() method of SecurityConfig class");
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("Inside passwordEncoder() method of SecurityConfig class");
        return new BCryptPasswordEncoder();
    }
}
