package com.jsBinary.BookShow.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jsBinary.BookShow.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	Optional<Author> findAuthorByFirstName(String firstName);
	

}
