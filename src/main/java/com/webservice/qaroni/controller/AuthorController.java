package com.webservice.qaroni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.Author;
import com.webservice.qaroni.model.entity.User;
import com.webservice.qaroni.service.AuthorService;
import com.webservice.qaroni.service.UserService;

@RestController
@RequestMapping("authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private UserService userService;

	/**
	 * Busca Author por Id
	 * 
	 * @param authorId
	 * @return Author
	 */
	@GetMapping("/author-by-id")
	public ResponseEntity<Author> getAuthorById(@RequestParam("authorId") Integer authorId) {
		return authorService.getAuthorById(authorId).map(author -> new ResponseEntity<>(author, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/list-authors-and-books")
	public ResponseEntity<List<Author>> getAuthorsAndBooks() {
		return authorService.getAuthorsAndBooks().map(authors -> new ResponseEntity<>(authors, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Solo usuarios registrados pueden registrar nuevos autores de libros.
	 * 
	 * @param userId
	 * @param author
	 * @return Author
	 */
	@PostMapping("/save-author")
	public ResponseEntity<Author> save(@RequestParam("userId") Integer userId, @RequestBody Author author) {

		Optional<User> user = userService.getUserById(userId);

		if (user.isPresent()) {
			return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Solo usuarios registrados pueden editar autores
	 * @param userId
	 * @param author
	 * @return Author
	 */
	@PutMapping("/update-author")
	public ResponseEntity<Author> update(@RequestParam("userId") Integer userId, @RequestBody Author author) {

		Optional<User> user = userService.getUserById(userId);

		if (user.isPresent()) {

			Optional<Author> authorOptional = authorService.getAuthorById(author.getAuthorId());

			if (authorOptional.isPresent()) {
				return new ResponseEntity<>(authorService.save(author), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
