package com.codegym.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.codegym.application.model.User;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User save(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}