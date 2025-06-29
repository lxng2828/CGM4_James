package com.codegym.aop_exception_handling.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.codegym.aop_exception_handling.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info(">> Entering method: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.codegym.aop_exception_handling.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("<< Method completed: {} | Returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.aop_exception_handling.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("!! Exception in method: {} | Error: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }
}
