package com.jsBinary.BookShow;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsBinary.BookShow.entity.Author;
import com.jsBinary.BookShow.entity.Book;
import com.jsBinary.BookShow.repository.AuthorRepository;
import com.jsBinary.BookShow.repository.BookRepository;

@SpringBootApplication
public class BookShowApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BookShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookShowApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author("Mary", "Shelly");
		Author author2 = new Author("J.R.R.", "Tolkien");
		Author author3 = new Author("F.Scott", "Fitzgerald");
		authorRepository.saveAll(Arrays.asList(author1, author2, author3));
		List<Book> books = Arrays.asList(
				new Book("Frankenstein", "Horror Fiction", "Lackington, Hughes, Harding, Mavor, & Jones", 1818, author1),
				new Book("The Lord of The Rings: The Fellowship of The Ring", "Fantasy Fiction", "George Allen & Unwin", 1954, author2),
				new Book("The Lord of The Rings: The Two Towers", "Fantasy Fiction", "George Allen & Unwin", 1954, author2),
				new Book("The Lord of The Rings: The Return of The King", "Fantasy Fiction", "George Allen & Unwin", 1955, author2),
				new Book("The Great Gatsby", "Tragedy", "Charles Scribner's Sons", 1925, author3)
				);
		bookRepository.saveAll(books);
		// Fetch all books and log to console
		bookRepository.findAll().forEach(book -> logger.info(book.getTitle() + " " + book.getGenre()));
		
	}

}
