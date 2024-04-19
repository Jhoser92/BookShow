package com.jsBinary.BookShow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookShowApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BookShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookShowApplication.class, args);
		logger.info("Application started");
	}

}
