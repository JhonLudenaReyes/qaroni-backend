package com.webservice.qaroni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.Author;

@Repository
public interface AuthorRepository {
	
	Optional<Author> getAuthorById(Integer authorId);
	
	Optional<List<Author>> getAuthorsAndBooks();
	
	Author save(Author author);
	
	Integer getTotalAuthors();

}
