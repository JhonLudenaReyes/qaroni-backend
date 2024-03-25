package com.webservice.qaroni.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.qaroni.model.entity.Author;


public interface AuthorDaoRepository extends JpaRepository<Author, Integer>{
	
	/**
	 * Busca Autor por Id
	 * @param authorID
	 * @param state
	 * @return Optional<Author>
	 */
	Optional<Author> findByAuthorIdAndState(Integer authorID, String state);
	
	/**
	 * Busca todos los autores activos
	 * @param state
	 * @return Optional<List<Author>>
	 */
	Optional<List<Author>> findAllByState(String state);
	
	/**
	 * Trae el total de autores
	 * @return Integer
	 */
	@Query("select count(*) from Author as a where a.state = 'A'")
	Integer getTotalAuthors();

}
