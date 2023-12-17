package com.pizzamanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagementsystem.dto.UserDTO;
import com.pizzamanagementsystem.entity.User;
import com.pizzamanagementsystem.exception.UserNotFoundException;
import com.pizzamanagementsystem.repository.UserRepository;
import com.pizzamanagementsystem.service.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/registeruser")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO user) {
		for (User u1 : userRepository.findAll()) {
			if (u1.getUserName().equals(user.getUserName())) {
				throw new UserNotFoundException("User is already exists");
			}
		}
		UserDTO newUser = userService.registerUser(user);
		return new ResponseEntity<UserDTO>(newUser, HttpStatus.OK);
	}

	@GetMapping("/signin/{userName}")
	public ResponseEntity<UserDTO> signIn(@PathVariable String userName, String password) {
		UserDTO newUser = userService.signIn(userName, password);
		return new ResponseEntity<UserDTO>(newUser, HttpStatus.OK);
	}

	@GetMapping("/signout")
	public ResponseEntity<String> signOut() {
		String newUser = userService.signOut();
		return new ResponseEntity<String>(newUser, HttpStatus.OK);
	}
}
