package com.codegym.web_service_va_restful.repository;

import com.codegym.web_service_va_restful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}