package com.codegym.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegym.spring_security.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}