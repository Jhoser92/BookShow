package com.jsBinary.BookShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.jsBinary.BookShow.entity.Author;
import com.jsBinary.BookShow.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Author getAuthor(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with id: " + id));
	}

	@Override
	public Author getAuthor(String firstName) {
		return authorRepository.findAuthorByFirstName(firstName)
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with name: " + firstName));
	}

	@Override
	public List<Author> getAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author updateAuthor(Long id, Author author) {
		Optional<Author> optionalAuthor = authorRepository.findById(id);
		if (optionalAuthor.isPresent()) {
			optionalAuthor.get().setAuthorId(id);
			optionalAuthor.get().setFirstName(author.getFirstName());
			optionalAuthor.get().setLastName(author.getLastName());
			
			return authorRepository.save(optionalAuthor.get());
		}else throw new ResourceNotFoundException("Owner not found with id: " + id);
	}
}

