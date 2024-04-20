package com.jsBinary.BookShow.repository;

import org.springframework.data.repository.CrudRepository;

import com.jsBinary.BookShow.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	

}
