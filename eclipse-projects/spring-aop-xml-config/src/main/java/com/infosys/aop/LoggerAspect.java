package com.infosys.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect {
	
	private static Logger log = LoggerFactory.getLogger(LoggerAspect.class);

	public void logBefore(JoinPoint jp) {
		log.trace("Entering {} of {} of {} class using a variable of {} type carrying {} as arguments",
				jp.getKind(),
				jp.getSignature().getName(),
				jp.getTarget().getClass().getName(),
				jp.getSignature().getDeclaringTypeName(),
				Arrays.toString(jp.getArgs()));
	}
	
	public void logAfter(JoinPoint jp) {
		log.trace("Returned after {} of {} of {} class using a variable of {} type carrying {} as arguments",
				jp.getKind(),
				jp.getSignature().getName(),
				jp.getTarget().getClass().getName(),
				jp.getSignature().getDeclaringTypeName(),
				Arrays.toString(jp.getArgs()));
	}
}
