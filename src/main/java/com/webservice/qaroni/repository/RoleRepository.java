package com.webservice.qaroni.repository;

import org.springframework.stereotype.Repository;

import com.webservice.qaroni.model.entity.Role;

@Repository
public interface RoleRepository {
	
	Role save(Role role);

}
