package com.example.imdb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
@Order(Integer.MIN_VALUE)
public class ProfilingAspect {
	private final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);

//	@Around("execution(* com.example.imdb..*(..))")
//	@Around("@target(profiling)") // class-level
//	@Before
//	@After
//	@AfterReturning
//	@AfterThrowing
	@Around("imdbPackage() && ( methodIsProfilingAnnotated() || classIsProfilingAnnotated() )") // method-level
	public Object profiling(ProceedingJoinPoint pjp) throws Throwable {
		var start = System.nanoTime();
		var result = pjp.proceed();
		var stop = System.nanoTime();
		var duration = stop-start;
		logger.info("%s runs %d ns.",pjp.getSignature().getName(), duration);
		return result;
	}
	
	@Pointcut("@annotation(com.example.imdb.aop.Profiling)")
	public void methodIsProfilingAnnotated() {}
	
	@Pointcut("within(@com.example.imdb.aop.Profiling *)")
	public void classIsProfilingAnnotated() {}
	
	@Pointcut("execution(* com.example.imdb..*(..))")
	public void imdbPackage() {}
	
	
}
