package com.webservice.qaroni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.qaroni.model.entity.User;
import com.webservice.qaroni.service.MailService;
import com.webservice.qaroni.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	MailService mailService;

	/**
	 * Busqueda de usuario por id
	 * @param userId
	 * @return User
	 */
	@GetMapping("/user-by-id")
	public ResponseEntity<User> getUserById(@RequestParam("userId") Integer userId) {
		return userService.getUserById(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Obtiene todos los usuarios activos
	 * @return List<User>
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list-active-users")
	public ResponseEntity<List<User>> getActiveUsers() {
		return userService.getActiveUsers().map(users -> new ResponseEntity<>(users, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Registra un usuario y envia un email de bienvenida al correo que el usario a registrado
	 * @param user
	 * @return User
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save-user")
	public ResponseEntity<User> save(@RequestBody User user) {
		
		mailService.sendMessageUser(user.getEmail(), "Bienvenido al sistema qaroni");
		
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

}
