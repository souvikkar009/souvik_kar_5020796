package com.library.aspects;

import java.lang.System.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@After("execution(* com.library.services.BookService.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("This is after advice.");
	}

	@Before("execution(* com.library.services.BookService.*(..))")
	public void beforeAdevice(JoinPoint joinPoint) {
		System.out.println("This is before advice");
	}
}
