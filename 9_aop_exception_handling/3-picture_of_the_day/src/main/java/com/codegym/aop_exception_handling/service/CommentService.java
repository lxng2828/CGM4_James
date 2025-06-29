package com.codegym.aop_exception_handling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegym.aop_exception_handling.exception.BadWordException;
import com.codegym.aop_exception_handling.model.Comment;
import com.codegym.aop_exception_handling.repository.CommentRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    private final List<String> badWords = Arrays.asList("cấm", "xấu", "tệ", "dở tệ");

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {

        for (String word : badWords) {
            if (comment.getFeedback().toLowerCase().contains(word)) {
                throw new BadWordException("Feedback contains a forbidden word.");
            }
        }
        commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void like(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            comment.setLikes(comment.getLikes() + 1);
            commentRepository.save(comment);
        }
    }
}