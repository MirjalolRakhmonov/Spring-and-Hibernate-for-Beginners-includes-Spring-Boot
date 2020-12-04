package com.mirjalolcode.aopdemo;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.mirjalolcode.aopdemo.dao.AccountDAO;
import spring.mirjalolcode.aopdemo.dao.MembershipDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.mirjalolcode.aopdemo")
public class DemoConfig {

	@Bean(name = "accountDAO")
	public AccountDAO accDao() {
        return new AccountDAO();
    }
	
	@Bean(name = "membershipDAO")
	public MembershipDAO memDao() {
		return new MembershipDAO();
	}

}
