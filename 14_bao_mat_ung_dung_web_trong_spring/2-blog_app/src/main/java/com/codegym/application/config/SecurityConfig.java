package com.codegym.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.codegym.application.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Autowired
        private UserService userService;

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests()
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/blogs")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/blogs/view/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/blogs/create")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/blogs/save")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/blogs/edit/**")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/blogs/delete/**")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/api/**")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                .anyRequest().authenticated();
                http.formLogin()
                                .loginPage("/login")
                                .defaultSuccessUrl("/blogs", true)
                                .permitAll();
                http.logout()
                                .logoutSuccessUrl("/blogs")
                                .permitAll();
                http.csrf().disable();
                return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
                return http.getSharedObject(AuthenticationManagerBuilder.class)
                                .userDetailsService(userService)
                                .passwordEncoder(passwordEncoder())
                                .and()
                                .build();
        }
}