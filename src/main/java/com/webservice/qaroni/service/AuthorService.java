package com.webservice.qaroni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.AuthorDaoRepository;
import com.webservice.qaroni.model.entity.Author;
import com.webservice.qaroni.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorRepository{
	
	@Autowired
	private AuthorDaoRepository authorDaoRepository;

	@Override
	public Optional<List<Author>> getAuthorsAndBooks() {
		// TODO Auto-generated method stub
		return authorDaoRepository.findAllByState("A");
	}

	@Override
	public Author save(Author author) {
		// TODO Auto-generated method stub
		return authorDaoRepository.save(author);
	}

}
