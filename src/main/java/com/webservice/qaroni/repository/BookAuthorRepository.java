package com.webservice.qaroni.repository;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.BookAuthor;

@Repository
public interface BookAuthorRepository {
	
	BookAuthor save(BookAuthor bookAuthor);

}
