package com.webservice.qaroni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.UserDaoRepository;
import com.webservice.qaroni.model.entity.User;
import com.webservice.qaroni.repository.UserRepository;

@Service
public class UserService implements UserRepository{
	
	@Autowired
	private UserDaoRepository userDaoRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDaoRepository.save(user);
	}

	@Override
	public Optional<List<User>> getActiveUsers() {
		// TODO Auto-generated method stub
		return userDaoRepository.findAllByState("A");
	}

}
