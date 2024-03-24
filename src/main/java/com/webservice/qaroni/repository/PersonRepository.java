package com.webservice.qaroni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.Person;

@Repository
public interface PersonRepository {
	
	Person save(Person person);
	
	Optional<List<Person>> searchByDniNameOrLastname(String search);

}
