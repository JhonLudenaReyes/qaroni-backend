package com.webservice.qaroni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.PersonDaoRepository;
import com.webservice.qaroni.model.entity.Person;
import com.webservice.qaroni.repository.PersonRepository;

@Service
public class PersonService implements PersonRepository{
	
	@Autowired
	private PersonDaoRepository personDaoRepository;

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personDaoRepository.save(person);
	}

	@Override
	public Optional<List<Person>> searchByDniNameOrLastname(String search) {
		// TODO Auto-generated method stub
		return personDaoRepository.searchByDniNameOrLastname(search);
	}

}
