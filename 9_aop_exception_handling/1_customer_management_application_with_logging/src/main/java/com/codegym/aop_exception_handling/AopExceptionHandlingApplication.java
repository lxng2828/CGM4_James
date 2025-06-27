package com.codegym.aop_exception_handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class AopExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopExceptionHandlingApplication.class, args);
	}

}
