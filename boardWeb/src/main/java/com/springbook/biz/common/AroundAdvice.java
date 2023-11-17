package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] >> 비즈니스 메소드 실행전");
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method + "메소드 수행에 걸린시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		System.out.println("[AFTER] >> 비즈니스 메소드 실행후");
		return returnObj;
	}
}
