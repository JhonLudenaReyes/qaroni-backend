package com.webservice.qaroni.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.qaroni.model.entity.Book;

public interface BookDaoRepository extends JpaRepository<Book, Integer>{
	
	/**
	 * 
	 * Extrae todos los libros registrados que no hayan sido eliminados logicamente.
	 * @param state
	 * @return Optional<List<Book>>
	 */
	Optional<List<Book>> findAllByState(String state);
	
	@Query("select b.bookId, b.title, b.stock, b.price, b.publicationDate, b.state from Book as b where b.state = 'A'")
	Optional<List<Object>> getActiveBooks(String state);
}
