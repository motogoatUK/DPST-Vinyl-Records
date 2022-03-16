package com.qa.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VinylRecordsApplication {
	public static Logger LOGGER = LogManager.getLogger();
	
	public static void main(String[] args) {
		SpringApplication.run(VinylRecordsApplication.class, args);
	}

}
