package com.codegym.app.service;

import com.codegym.app.model.Blog;
import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);
}