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

import com.webservice.qaroni.model.entity.Author;
import com.webservice.qaroni.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/list-authors-and-books")
	public ResponseEntity<List<Author>> getAuthorsAndBooks() {
		return authorService.getAuthorsAndBooks().map(authors -> new ResponseEntity<>(authors, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save-author")
	public ResponseEntity<Author> save(@RequestBody Author author) {
		return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
	}

}
