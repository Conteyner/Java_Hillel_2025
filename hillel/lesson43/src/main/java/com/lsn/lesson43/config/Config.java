package com.lsn.lesson43.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("Nick")
                        .password(passwordEncoder.encode("123456"))
                        .roles("USER")
                        .build(),
                User.withUsername("Tomas")
                        .password(passwordEncoder.encode("1984"))
                        .roles("USER")
                        .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/login", "/css/**").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/users", true).permitAll()
                        )
                .logout(
                        logout -> logout
                        .logoutSuccessUrl("/login?logout")
                )
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}
