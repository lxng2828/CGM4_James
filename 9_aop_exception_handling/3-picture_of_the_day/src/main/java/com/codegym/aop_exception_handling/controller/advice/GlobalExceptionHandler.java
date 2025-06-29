package com.codegym.aop_exception_handling.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codegym.aop_exception_handling.exception.BadWordException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadWordException.class)
    public String handleBadWordException(BadWordException ex, Model model) {
        model.addAttribute("errorMessage",
                "Bình luận của bạn chứa từ ngữ không phù hợp. Vui lòng không nói bậy và thử lại.");
        return "error"; 
    }
}