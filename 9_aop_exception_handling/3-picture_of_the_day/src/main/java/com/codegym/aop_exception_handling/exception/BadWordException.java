package com.codegym.aop_exception_handling.exception;

public class BadWordException extends RuntimeException {
    public BadWordException(String message) {
        super(message);
    }
}