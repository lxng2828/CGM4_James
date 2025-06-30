package com.codegym.web_service_va_restful.service;

import com.codegym.web_service_va_restful.model.Blog;
import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);
}