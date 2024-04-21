package com.jsBinary.BookShow.service;

import java.util.List;

import com.jsBinary.BookShow.entity.Author;

public interface AuthorService {
	
	Author getAuthor(Long id);
	Author getAuthor(String firstName);
	List<Author> getAuthors();
	void deleteAuthor(Long id);
	Author saveAuthor(Author author);
	Author updateAuthor(Long id, Author author);

}
