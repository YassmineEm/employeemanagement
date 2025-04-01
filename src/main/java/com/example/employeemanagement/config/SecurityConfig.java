package com.example.employeemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.POST, "/employees/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin();  // Active un formulaire de connexion basique
    }
}
