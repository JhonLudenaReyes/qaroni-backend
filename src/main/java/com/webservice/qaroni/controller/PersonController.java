package com.webservice.qaroni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.Person;
import com.webservice.qaroni.service.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/save-person")
	public ResponseEntity<Person> save(@RequestBody Person person) {
		return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
	}

	@GetMapping("/search-people")
	public ResponseEntity<List<Person>> searchByDniNameOrLastname(@RequestParam("search") String search) {
		return personService.searchByDniNameOrLastname(search)
				.map(people -> new ResponseEntity<>(people, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
