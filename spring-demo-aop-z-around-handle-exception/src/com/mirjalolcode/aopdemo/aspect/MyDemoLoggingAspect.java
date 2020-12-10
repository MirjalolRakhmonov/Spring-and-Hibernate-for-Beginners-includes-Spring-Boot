package com.mirjalolcode.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mirjalolcode.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.mirjalolcode.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin=System.currentTimeMillis();
		
		// now, let's execute the method
		Object result=null;
		
		try {
			result=theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// rethrow exception
			throw e;
		} 
		
		// get end timestamp
		long end=System.currentTimeMillis();
		
		// compute duration and display it
		long duration=end-begin;
		myLogger.info("\n=====>> Duration: "+duration/1000.0+"seconds");
		
		return result;
	}
	
	@After("execution(* spring.mirjalolcode.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we're advising on
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @After (finally) on method: "+method);
		
	}
	
	@AfterThrowing(pointcut = "execution(* spring.mirjalolcode.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
			
		// print out which method we're advising on
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @AfterThrowing on method: "+method);
		
		// log the exception
		myLogger.info("\n=====>> The Exception is: "+theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* spring.mirjalolcode.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we're advising on
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @AfterReturning on method: "+method);
		
		// print out the results of the method call
		myLogger.info("\n=====>> result is: "+result);
		
		// modify "result" list: add, remove, update, etc...
		
		// convert account names to upperCase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=====>> result is: "+result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for(Account tempAccount : result) {
		
		// get uppercase version of name
		String theUpperName=tempAccount.getName().toUpperCase();
		
		// update the name on the account
		tempAccount.setName(theUpperName);	
		}
	}

	@Before("com.mirjalolcode.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>> Executing @Before advice on addAccount()");
		
		// display method signature
		MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: "+methodSig);
		
		// display method arguments
		
		// get args
		Object[] args=theJoinPoint.getArgs();
		
		// look through args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount=(Account) tempArg;
				myLogger.info("Account name: "+theAccount.getName());
				myLogger.info("Account name: "+theAccount.getLevel());
			}
		}
	}
}
