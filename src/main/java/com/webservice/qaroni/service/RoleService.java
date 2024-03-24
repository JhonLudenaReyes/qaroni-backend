package com.webservice.qaroni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.RoleDaoRepository;
import com.webservice.qaroni.model.entity.Role;
import com.webservice.qaroni.repository.RoleRepository;

@Service
public class RoleService implements RoleRepository{
	
	@Autowired
	private RoleDaoRepository roleDaoRepository;

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleDaoRepository.save(role);
	}

}
