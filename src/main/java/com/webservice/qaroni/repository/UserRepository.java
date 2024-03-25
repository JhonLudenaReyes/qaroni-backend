package com.webservice.qaroni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.User;

@Repository
public interface UserRepository {
	
	Optional<User> getUserById(Integer userId);
	
	Optional<List<User>> getActiveUsers();
	User save(User user);

}
