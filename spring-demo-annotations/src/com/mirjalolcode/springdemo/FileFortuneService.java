package com.mirjalolcode.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName="C:/Users/e6530/workspace/spring-demo-annotations/src/fortune-data";
	private List<String> theFortunes;
	
	private Random myRandom=new Random();
	
	public FileFortuneService() {
	}
		
	@PostConstruct
	private void loadTheFortunesFile() {
		File theFile=new File(fileName);
	// Your fortune service should read the fortunes from a file.  
			System.out.println("Reading fortunes from file: "+theFile);
			System.out.println("File exists: "+theFile.exists());
				
			// The fortune service should load the fortunes into an array
			theFortunes=new ArrayList<String>();
				
			// read fortunes from file
				
			try (BufferedReader br=new BufferedReader(new FileReader(theFile))){
				
				String tempLine;
				while ((tempLine=br.readLine())!=null) {
					theFortunes.add(tempLine);			
					}
				} catch (IOException e) {
				e.printStackTrace();
			}
		}

	@Override
	public String getFortune() {
		int index=myRandom.nextInt(theFortunes.size());
		
		String tempFortune=theFortunes.get(index);
		
		return tempFortune;
	}

}
