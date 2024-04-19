package com.jsBinary.BookShow;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsBinary.BookShow.entity.Book;
import com.jsBinary.BookShow.repository.BookRepository;

@SpringBootApplication
public class BookShowApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BookShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookShowApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Book> books = Arrays.asList(
				new Book("Frankenstein", "Science Fiction", "Lackington, Hughes, Harding, Mavor, & Jones", 1818),
				new Book("Ford","Mustang","Red",2021)
				);
		bookRepository.saveAll(books);
		// Fetch all books and log to console
		
		
	}

}
