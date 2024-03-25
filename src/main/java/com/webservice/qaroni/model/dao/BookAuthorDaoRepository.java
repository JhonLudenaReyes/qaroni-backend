package com.webservice.qaroni.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.qaroni.model.entity.BookAuthor;
import com.webservice.qaroni.model.entity.BookAuthorId;

public interface BookAuthorDaoRepository extends JpaRepository<BookAuthor, BookAuthorId>{

}
