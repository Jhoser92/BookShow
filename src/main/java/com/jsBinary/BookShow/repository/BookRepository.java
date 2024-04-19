package com.jsBinary.BookShow.repository;

import org.springframework.data.repository.CrudRepository;

import com.jsBinary.BookShow.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
