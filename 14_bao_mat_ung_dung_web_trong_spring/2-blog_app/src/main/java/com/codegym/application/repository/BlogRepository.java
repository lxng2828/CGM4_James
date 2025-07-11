package com.codegym.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegym.application.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}