package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void allPointCut() {}
	
	@Before("allPointCut()")
	public void printLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 로그] 비즈니스 로직 수행전 동작 >>" + method );
		System.out.println("아큐먼트 정보 >>" + args[0].toString() );
	}
}






