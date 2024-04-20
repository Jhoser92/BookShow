package com.jsBinary.BookShow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jsBinary.BookShow.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	// Fetch book by title
	List<Book> findBookByTitle(String title);
	// Fetch book by genre
	List<Book> findBookByGenre(String genre);
	// Fetch book by year published
	List<Book> findBookByPubYear(int pubYear);
	// Fetch book by title and genre
	List<Book> findBookByTitleAndGenre(String title, String genre);
	// Fetch book by genre and sort by year
	List<Book> findBookByGenreOrderByPubYearAsc(String genre);

}
