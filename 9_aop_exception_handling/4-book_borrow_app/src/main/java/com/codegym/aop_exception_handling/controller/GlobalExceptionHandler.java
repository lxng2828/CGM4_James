package com.codegym.aop_exception_handling.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.codegym.aop_exception_handling.exception.InvalidCodeException;
import com.codegym.aop_exception_handling.exception.OutOfStockException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ OutOfStockException.class, InvalidCodeException.class })
    public ModelAndView handleError(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}