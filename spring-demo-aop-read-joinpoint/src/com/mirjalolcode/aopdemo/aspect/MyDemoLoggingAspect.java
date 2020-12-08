package com.mirjalolcode.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.mirjalolcode.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>> Executing @Before advice on addAccount()");
		
		// display method signature
		MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
		
		// display method arguments
		System.out.println("Method: "+methodSig);
	}
}
