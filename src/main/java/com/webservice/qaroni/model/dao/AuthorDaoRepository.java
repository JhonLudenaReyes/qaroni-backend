package com.webservice.qaroni.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.qaroni.model.entity.Author;


public interface AuthorDaoRepository extends JpaRepository<Author, Integer>{
	
	
	Optional<List<Author>> findAllByState(String state);
	
	//Optional<List<Book>> findByNameOrLastName(String name, String lastName);

}
