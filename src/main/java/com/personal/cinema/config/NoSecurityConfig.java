package com.personal.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("no-security")
@EnableMethodSecurity(prePostEnabled = false)
public class NoSecurityConfig {

    @Bean
    public SecurityFilterChain filter(final HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests().anyRequest().permitAll().and().csrf().disable().build();
    }
}
