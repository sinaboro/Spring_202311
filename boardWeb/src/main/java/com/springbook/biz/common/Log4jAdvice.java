package com.springbook.biz.common;

public class Log4jAdvice {
	public void pringLogging() {
		System.out.println("1[공통 로그1 Log4j] 비즈니스 로직 수행전 동작");
	}
	public void pringLogging2() {
		System.out.println("[공통 로그2 Log4j] 비즈니스 로직 수행전 동작");
	}
	public void pringLogging3() {
		System.out.println("[공통 로그3 Log4j] 비즈니스 로직 수행전 동작");
	}
}
