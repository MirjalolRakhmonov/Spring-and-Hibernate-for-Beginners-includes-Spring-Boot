package com.mirjalolcode.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create array of  strings
	private String[] data= {
			"Beware of wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// Create a random number generator
	private Random myRandom=new Random();
	
	
	@Override
	public String getFortune() {
		// pick a random string from array
		int index=myRandom.nextInt(data.length);
		
		// grab a fortune from the array
		String theFortune=data[index];
		
		return theFortune;
	}

}
