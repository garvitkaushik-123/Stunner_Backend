package com.stunner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())  // disable CSRF for POST requests in Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()   // allow all auth APIs
                        .anyRequest().permitAll()                  // allow everything for now
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // just in case of H2
                .formLogin(form -> form.disable())  // no login form
                .httpBasic(httpBasic -> httpBasic.disable()); // no basic auth

        return http.build();
    }
}
