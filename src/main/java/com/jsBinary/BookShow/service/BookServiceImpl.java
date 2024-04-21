package com.jsBinary.BookShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.jsBinary.BookShow.entity.Book;
import com.jsBinary.BookShow.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
		
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		}else {
			throw new ResourceNotFoundException("Oops! Book with " + id + " does not exist in our database");
			
		}
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			optionalBook.get().setTitle(book.getTitle());
			optionalBook.get().setGenre(book.getGenre());
			optionalBook.get().setPublisher(book.getPublisher());
			optionalBook.get().setPubYear(book.getPubYear());
			optionalBook.get().setAuthor(book.getAuthor());
			
			bookRepository.save(optionalBook.get());
			
			return optionalBook.get();
		}else {
			throw new ResourceNotFoundException("Book with " + id + " does not exist");
		}
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
}
