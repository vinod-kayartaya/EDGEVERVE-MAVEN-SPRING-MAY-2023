package com.infosys.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	public LoggerAspect() {
		System.out.println("LoggerAspect constructor called");
	}
	
	// Aspect consists of solutions to the concerns in the form of 
	// functions, annotated with @Before/ @After/ @AfterReturning/ @AfterThrowing/ @Around
	// These annotations are supposed to be applied at some join-points (method invocations)
	// denoted using the AspectJ pointcut expression language
	
	@Before("execution(public * com.infosys.dao.ProductDao.*(..))")
	public void logBefore() {
		System.out.println("Entering _______ method");
	}
	
	@After("execution(public * com.infosys.dao.ProductDao.*(..))")
	public void logAfter() {
		System.out.println("Exiting _______ method");
	}
}
