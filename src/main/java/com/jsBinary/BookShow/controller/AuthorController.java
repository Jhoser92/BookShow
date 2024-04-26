package com.jsBinary.BookShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsBinary.BookShow.entity.Author;
import com.jsBinary.BookShow.service.AuthorService;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("all")
	public ResponseEntity<List<Author>> getAuthors() {
		return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
		return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<Author> getAuthor(@PathVariable String name) {
		return new ResponseEntity<>(authorService.getAuthor(name), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		return new ResponseEntity<>(authorService.updateAuthor(id, author), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
