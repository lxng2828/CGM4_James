package com.codegym.aop_exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegym.aop_exception_handling.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}