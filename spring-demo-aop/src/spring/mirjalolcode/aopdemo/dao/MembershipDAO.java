package spring.mirjalolcode.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass()+"Doing stuff: Adding a membership account");
		
	}
}
