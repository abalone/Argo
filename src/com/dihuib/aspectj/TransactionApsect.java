/**
 * 
 */
package com.dihuib.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Dihui Bao 
 *
 */
@Aspect
public class TransactionApsect {
	
	@Pointcut("execution(@com.dihuib.aspectj.annotation.Transactional * *(..))")
	public void transactionalAnnotation() {}
	
	@Around("transactionalAnnotation()")
	public Object doTransation(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		System.out.println("Start Transaction");
		Object ret = null;
		ret = thisJoinPoint.proceed();
		System.out.println("End Transaction");
		return ret;
	}
}
