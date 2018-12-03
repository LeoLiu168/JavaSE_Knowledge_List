package org.leo.demo.db.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/*
 * 使用@Aspect注解定义一个切面
 */
@Aspect
public class Audience {
	
	//定义pointcut, 精简代码
	@Pointcut("execution(** org.leo.demo.db.aop.Performance.perform(..))")
	public void performance() {
		
	}
	//使用环绕通知
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("taking seats");
			jp.proceed();
			System.out.println("papapapapa");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("refund!");
		}
	}

	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}
	@Before("performance()")
	public void takeSeats() {
		System.out.println("taking seats");
	}
	@AfterReturning("performance()")
	public void applause() {
		System.out.println("papapapapa");
	}
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("refund!");
	}
}
