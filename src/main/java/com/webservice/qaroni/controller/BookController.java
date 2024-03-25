package com.webservice.qaroni.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.Book;
import com.webservice.qaroni.model.entity.User;
import com.webservice.qaroni.service.BookService;
import com.webservice.qaroni.service.UserService;

@RestController
@RequestMapping(name = "books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	/**
	 * Busca un libro por id
	 * 
	 * @param bookId
	 * @return Book
	 */
	@GetMapping("/search-book-by-id")
	public ResponseEntity<Book> getBookById(@RequestParam("bookId") Integer bookId) {
		return bookService.getBookById(bookId).map(book -> new ResponseEntity<>(book, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Consulta todos los libros activos con sus respentivos autores Los libros
	 * pueden tener múltiples autores.
	 * 
	 * @return <List<Book>>
	 */
	@GetMapping("/list-books/data-author")
	public ResponseEntity<List<Book>> getActiveBooks() {
		return bookService.getActiveBooksAuthor().map(books -> new ResponseEntity<>(books, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Consulta todos los libros con la descripción de sus propiedades
	 * 
	 * @return <List<Object>>
	 */
	@GetMapping("/list-books/descriptions")
	public ResponseEntity<List<Book>> getListActiveBooks() {
		return bookService.getListActiveBooks().map(books -> new ResponseEntity<>(books, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Solo usuarios registrados pueden registrar nuevos libros
	 * 
	 * @param userId
	 * @param book
	 * @return Book
	 */
	@PostMapping("/save-book")
	public ResponseEntity<Book> save(@RequestParam("userId") Integer userId, @RequestBody Book book) {

		Optional<User> user = userService.getUserById(userId);

		if (user.isPresent()) {
			return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Solo usuarios registrados pueden editar libros
	 * 
	 * @param userId
	 * @param book
	 * @return Book
	 */
	@PutMapping("/update-book")
	public ResponseEntity<Book> update(@RequestParam("userId") Integer userId, @RequestBody Book book) {

		Optional<User> user = userService.getUserById(userId);

		if (user.isPresent()) {

			Optional<Book> bookOptional = bookService.getBookById(book.getBookId());

			if (bookOptional.isPresent()) {
				return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Únicamente los usuarios directivos pueden exportar un excel con un resumen
     * que contiene: Total de libros, total de autores
	 * @param userId
	 * @return InputStreamResource
	 * @throws Exception
	 */
	@GetMapping("/export/all")
	public ResponseEntity<InputStreamResource> exportAllData(@RequestParam("userId") Integer userId) throws Exception {

		Optional<User> user = userService.getUserById(userId);

		if (user.get().getRoleId().equals(1)) {
			ByteArrayInputStream stream = bookService.exportAllData();

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=resumen.xls");

			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
