package com.infosys.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.infosys.dao.DaoException;

@Aspect
@Component
public class ExceptionAspect {
	@AfterThrowing(pointcut = "execution(* com..ProductDao.*(..))", throwing = "ex")
	public void convertToDaoException(Exception ex) {
		throw new DaoException(ex);
	}
}
