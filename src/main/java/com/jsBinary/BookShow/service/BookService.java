package com.jsBinary.BookShow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsBinary.BookShow.entity.Book;

@Service
public interface BookService {
	
	// Get all books
	List<Book> getBooks();
	// Find book by id
	Book getBookById(Long id);
	// Add new book
	Book saveBook(Book book);
	// Update a book
	Book updateBook(Long id, Book book);
	// Delete a book
	void deleteBook(Long id);

}
