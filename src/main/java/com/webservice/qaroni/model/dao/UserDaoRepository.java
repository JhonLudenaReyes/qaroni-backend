package com.webservice.qaroni.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.qaroni.model.entity.User;

public interface UserDaoRepository extends JpaRepository<User, Integer>{

	Optional<List<User>> findAllByState(String state);
}
