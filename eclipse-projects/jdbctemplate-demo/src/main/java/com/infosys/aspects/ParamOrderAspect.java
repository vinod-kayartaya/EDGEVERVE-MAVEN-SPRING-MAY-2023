package com.infosys.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParamOrderAspect {

	// ProceedingJoinPoint can be used only with @Around advice
	// and hence, any modification to the arguments can be done only in
	// an @Around advice
	@Around("execution(* com..ProductDao.getProductsInPriceRange(double, double))")
	public Object checkAndSwap(ProceedingJoinPoint pjp) throws Throwable {

		// do something before going to the actual target function
		Object[] args = pjp.getArgs(); // arguments supplied to the getProductsInPriceRange method
		double d1 = Double.parseDouble(args[0].toString());
		double d2 = Double.parseDouble(args[1].toString());

		if (d1 > d2) {
			args = new Object[] { d2, d1 };
		}

		Object ret = pjp.proceed(args); // go to the actual target function now (may be with modified args)

		// come back and do something else
		return ret;
	}

}
