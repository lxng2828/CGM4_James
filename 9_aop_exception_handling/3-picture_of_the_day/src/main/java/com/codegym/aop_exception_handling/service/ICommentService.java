package com.codegym.aop_exception_handling.service;

import java.util.List;

import com.codegym.aop_exception_handling.model.Comment;

public interface ICommentService {
    List<Comment> findAll();

    void save(Comment comment);

    Comment findById(Long id);

    void like(Long id);
}