package com.webservice.qaroni.repository;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.Book;

@Repository
public interface BookRepository {
	
	Optional<Book> getBookById(Integer bookId);
	
	Optional<List<Book>> getActiveBooksAuthor();
	
	Optional<List<Book>> getListActiveBooks();
	
	Book save(Book book);
	
	Integer getTotalBooks();
	
	ByteArrayInputStream exportAllData() throws Exception;

}
