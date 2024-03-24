package com.webservice.qaroni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.Book;
import com.webservice.qaroni.service.BookService;

@RestController
@RequestMapping(name = "books")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Consulta todos los libros activos con sus respentivos autores
	 * @return <List<Book>>
	 */
	@GetMapping("/list-books/data-author")
	public ResponseEntity<List<Book>> getActiveBooks() {
		return bookService.getActiveBooksAuthor().map(books -> new ResponseEntity<>(books, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	/**
	 * Consulta todos los libros con la descripción de sus propiedades
	 * @return <List<Object>>
	 */
	@GetMapping("/list-books/descriptions")
	public ResponseEntity<List<Object>> getListActiveBooks() {
		return bookService.getListActiveBooks().map(books -> new ResponseEntity<>(books, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save-book")
	public ResponseEntity<Book> save(@RequestBody Book book){
		return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
	}

}
