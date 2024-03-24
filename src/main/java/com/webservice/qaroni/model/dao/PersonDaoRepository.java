package com.webservice.qaroni.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.qaroni.model.entity.Person;

public interface PersonDaoRepository extends JpaRepository<Person, Integer>{

	@Query("select p from Person as p where p.state = 'A' and (p.identificationCard like %:search% or p.name like %:search% or p.lastName like %:search%)")
	Optional<List<Person>> searchByDniNameOrLastname(String search);
}
