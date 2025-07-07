package com.codegym.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegym.spring_security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}