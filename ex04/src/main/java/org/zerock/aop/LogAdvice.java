package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {
	
//	@Before("execution(* org.zerock.service.SampleService*.*(..))")
//	@After("execution(* org.zerock.service.SampleService*.*(..))")
//	@AfterReturning("execution(* org.zerock.service.SampleService*.*(..))")
//	@AfterThrowing("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("Bofore===========================");
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		log.info("Target >> " + pjp.getTarget());
		log.info("Param >> " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		log.info("time >> " + (end-start));
		
		return result;
	}
	
	
	
	
}
