package com.mohibur.common.config;

import com.mohibur.common.interfaces.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Inside configure(HttpSecurity http) method of SecurityConfig class");
        http
                .csrf()
                .ignoringAntMatchers(UrlConstant.UserUrl.REGISTER, UrlConstant.UserUrl.VERIFY, UrlConstant.UserUrl.LOGIN)
                .and()
                .authorizeRequests()
                .antMatchers(UrlConstant.UserUrl.REGISTER, UrlConstant.UserUrl.VERIFY, UrlConstant.UserUrl.LOGIN).permitAll()
                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Inside configure(AuthenticationManagerBuilder auth) method of SecurityConfig class");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
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
