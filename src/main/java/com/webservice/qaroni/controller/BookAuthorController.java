package com.webservice.qaroni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.BookAuthor;
import com.webservice.qaroni.service.BookAuthorService;

@RestController
@RequestMapping("/books-authors")
public class BookAuthorController {

	@Autowired
	private BookAuthorService bookAuthorService;

	/**
	 * Registra los datos con la relacion que existe entre autores y libros,
	 * tomando en cuenta que la relacion entre autores y libros es de muchos a muchos
	 * @param bookAuthor
	 * @return BookAuthor
	 */
	@PostMapping("/save-book-author")
	public ResponseEntity<BookAuthor> save(@RequestBody BookAuthor bookAuthor) {
		return new ResponseEntity<>(bookAuthorService.save(bookAuthor), HttpStatus.CREATED);
	}
}
