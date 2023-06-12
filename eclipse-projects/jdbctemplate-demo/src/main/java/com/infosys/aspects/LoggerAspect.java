package com.infosys.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component // uncomment this to test out the advices from this aspect class
public class LoggerAspect {

	public LoggerAspect() {
		System.out.println("LoggerAspect constructor called");
	}

	// Aspect consists of solutions to the concerns in the form of
	// functions, annotated with @Before/ @After/ @AfterReturning/ @AfterThrowing/
	// @Around
	// These annotations are supposed to be applied at some join-points (method
	// invocations)
	// denoted using the AspectJ pointcut expression language
	
	@Pointcut("execution(public * com..ProductDao.*(..))")
	public void pc1() {}
	

	@Before("pc1()")
	public void logBefore(JoinPoint jp) {
		System.out.printf("Entering %s of %s of %s class using a variable of %s type carrying %s as arguments%n",
				jp.getKind(),
				jp.getSignature().getName(),
				jp.getTarget().getClass().getName(),
				jp.getSignature().getDeclaringTypeName(),
				Arrays.toString(jp.getArgs()));
	}

	@After("pc1()")
	public void logAfter(JoinPoint jp) {
		System.out.printf("Returned after %s of %s of %s class using a variable of %s type carrying %s as arguments%n",
				jp.getKind(),
				jp.getSignature().getName(),
				jp.getTarget().getClass().getName(),
				jp.getSignature().getDeclaringTypeName(),
				Arrays.toString(jp.getArgs()));
	}
}
