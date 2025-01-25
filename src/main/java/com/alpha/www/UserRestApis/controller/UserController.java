package com.alpha.www.UserRestApis.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.UserRestApis.entity.User;
import com.alpha.www.UserRestApis.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
		User user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable Long id, 
			@RequestBody User user){
		user.setId(id);
		User updatedUser = userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}
}
