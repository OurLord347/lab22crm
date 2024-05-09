package com.crm.designers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(16);
//    }
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http
                .csrf().disable()
                .formLogin().and()
//                .httpBasic().and()
                .authorizeHttpRequests()
//                .requestMatchers("/place/**").permitAll()
                .anyRequest().authenticated().and()
                .logout().and()
                .build();
    }
}
