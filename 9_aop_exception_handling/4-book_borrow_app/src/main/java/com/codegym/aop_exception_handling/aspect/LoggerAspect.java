package com.codegym.aop_exception_handling.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    private long visitorCount = 0;

    @Pointcut("execution(* com.example.booklibrary.service.BookService.*(..))")
    public void bookServiceMethods() {
    }

    @After("execution(* com.example.booklibrary.service.BookService.borrowBook(..)) || execution(* com.example.booklibrary.service.BookService.returnBook(..))")
    public void logStatusChange(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out
                .println("LOG: [" + LocalDateTime.now() + "] Trạng thái sách đã thay đổi do hành động: " + methodName);
    }

    @Pointcut("within(com.example.booklibrary.controller.BookController)")
    public void allControllerMethods() {
    }

    @Before("allControllerMethods()")
    public void logVisitor() {
        visitorCount++;
        System.out.println("LOG: [" + LocalDateTime.now() + "] Lượt truy cập thứ: " + visitorCount);
    }
}