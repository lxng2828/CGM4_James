package com.codegym.application.service;

import java.util.List;
import java.util.Optional;

import com.codegym.application.model.Blog;

public interface BlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);
}