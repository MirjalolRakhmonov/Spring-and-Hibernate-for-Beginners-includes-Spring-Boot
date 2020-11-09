package com.mirjalolcode.springdemo;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.mirjalolcode.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// define bean f or our sad service
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
  