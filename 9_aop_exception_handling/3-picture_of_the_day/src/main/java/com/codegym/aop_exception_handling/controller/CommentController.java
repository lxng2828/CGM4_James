package com.codegym.aop_exception_handling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.codegym.aop_exception_handling.model.Comment;
import com.codegym.aop_exception_handling.service.ICommentService;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "index";
    }

    @PostMapping("/comment")
    public String postComment(@ModelAttribute("newComment") Comment newComment) {
        commentService.save(newComment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String likeComment(@PathVariable("id") Long id) {
        commentService.like(id);
        return "redirect:/";
    }
}