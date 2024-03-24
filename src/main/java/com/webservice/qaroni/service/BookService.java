package com.webservice.qaroni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.BookDaoRepository;
import com.webservice.qaroni.model.entity.Book;
import com.webservice.qaroni.repository.BookRepository;

@Service
public class BookService implements BookRepository{
	
	@Autowired
	private BookDaoRepository bookDaoRepository;

	@Override
	public Optional<List<Book>> getActiveBooksAuthor() {
		// TODO Auto-generated method stub
		return bookDaoRepository.findAllByState("A");
	}

	@Override
	public Optional<List<Object>> getListActiveBooks() {
		// TODO Auto-generated method stub
		return bookDaoRepository.getActiveBooks("A");
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookDaoRepository.save(book);
	}
	

}
