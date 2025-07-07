package com.codegym.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                                .username("user")
                                .password("password")
                                .roles("USER")
                                .build();
                UserDetails admin = User.withDefaultPasswordEncoder()
                                .username("admin")
                                .password("password")
                                .roles("ADMIN")
                                .build();
                UserDetails dba = User.withDefaultPasswordEncoder()
                                .username("dba")
                                .password("password")
                                .roles("DBA", "ADMIN")
                                .build();
                return new InMemoryUserDetailsManager(user, admin, dba);
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests()
                                .requestMatchers("/db/**").hasRole("DBA")
                                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "DBA")
                                .requestMatchers("/client/**").hasAnyRole("USER", "ADMIN", "DBA")
                                .requestMatchers("/", "/home", "/access-denied").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .formLogin()
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                                .and()
                                .logout()
                                .logoutSuccessUrl("/home")
                                .permitAll()
                                .and()
                                .exceptionHandling()
                                .accessDeniedPage("/access-denied");

                return http.build();
        }
}