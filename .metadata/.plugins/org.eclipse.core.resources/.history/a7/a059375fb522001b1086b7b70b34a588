package com.mirjalolcode.springdemo;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.mirjalolcode.springdemo")
public class SportConfig {
	// define bean for our sad service
	@Bean 
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
  