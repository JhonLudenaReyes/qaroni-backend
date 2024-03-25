package com.webservice.qaroni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.BookAuthorDaoRepository;
import com.webservice.qaroni.model.entity.BookAuthor;
import com.webservice.qaroni.repository.BookAuthorRepository;

@Service
public class BookAuthorService implements BookAuthorRepository{
	
	@Autowired
	private BookAuthorDaoRepository bookAuthorDaoRepository;

	@Override
	public BookAuthor save(BookAuthor bookAuthor) {
		// TODO Auto-generated method stub
		return bookAuthorDaoRepository.save(bookAuthor);
	}
	
	

}
