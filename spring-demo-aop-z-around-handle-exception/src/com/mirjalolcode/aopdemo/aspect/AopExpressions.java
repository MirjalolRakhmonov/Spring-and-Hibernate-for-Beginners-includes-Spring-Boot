package com.mirjalolcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* spring.mirjalolcode.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* spring.mirjalolcode.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* spring.mirjalolcode.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create point: include package...exclude getter/setter
	@Pointcut("forDaoPackage() && ! (getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
