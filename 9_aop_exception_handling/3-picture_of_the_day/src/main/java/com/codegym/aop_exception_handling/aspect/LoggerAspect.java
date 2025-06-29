package com.codegym.aop_exception_handling.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codegym.aop_exception_handling.exception.BadWordException;
import com.codegym.aop_exception_handling.model.Comment;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @AfterThrowing(pointcut = "execution(* vn.codegym.pictureoftheday.service.ICommentService.save(..)) && args(comment)", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Comment comment, Exception e) {
        if (e instanceof BadWordException) {
            String logMessage = String.format(
                    "[BAD WORD DETECTED]\n\t- Author: %s\n\t- Feedback: '%s'\n\t- Timestamp: %s",
                    comment.getAuthor(),
                    comment.getFeedback(),
                    LocalDateTime.now());
            logger.warn(logMessage);
        }
    }
}