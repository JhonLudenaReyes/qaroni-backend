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
	
	
	/**
	 * Busqueda de libro por Id
	 * @param bookId
	 * @param state
	 * @return Optional<Book>
	 */
	Optional<Book> findByBookIdAndState(Integer bookId, String state);
	
	/**
	 * Obtiene una lista de libros con su descripción
	 * @param state
	 * @return Optional<List<Book>>
	 */
	@Query("select b from Book as b where b.state = 'A'")
	Optional<List<Book>> getActiveBooks(String state);
	
	@Query("select count(*) from Book as b where b.state = 'A'")
	Integer getTotalBooks();
}
