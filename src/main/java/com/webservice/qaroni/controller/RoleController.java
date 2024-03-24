package com.webservice.qaroni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.Role;
import com.webservice.qaroni.service.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * REGISTRA UN NUEVO ROL
	 * @param role
	 * @return Role
	 */
	@PostMapping("/save-role")
	public ResponseEntity<Role> save(@RequestBody Role role) {
		return new ResponseEntity<>(roleService.save(role), HttpStatus.CREATED);
	}

}
