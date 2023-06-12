package com.infosys.dao;

import org.springframework.stereotype.Component;

@Component
public final class DummyDao { // this being a final class, proxy creation will fail 
	// if this name is used in AOP pointcut expression
	// @Pointcut("execution(public * com.infosys.dao.DummyDao.*(..))")
	// error: java.lang.IllegalArgumentException: Cannot subclass final class com.infosys.dao.DummyDao
	public void hello() {
		
	}

}
