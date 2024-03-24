package com.webservice.qaroni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.Book;

@Repository
public interface BookRepository {
	
	Optional<List<Book>> getActiveBooksAuthor();
	
	Optional<List<Object>> getListActiveBooks();
	
	Book save(Book book);

}
