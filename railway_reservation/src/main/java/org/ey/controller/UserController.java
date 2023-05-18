package org.ey.controller;

import org.apache.catalina.realm.JNDIRealm.User;
import org.ey.helper.ResponseStructure;
import org.ey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/")
	public ResponseStructure<org.ey.dto.User> register(@RequestBody org.ey.dto.User user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public ResponseStructure<String> login(@RequestBody User user) {
		return userService.login(user);
	}

	@GetMapping("/{id}")
	public ResponseStructure<User> fetchById(@PathVariable Long id) {
		return userService.fetchById(id);
	}

	// Add more methods as needed
}