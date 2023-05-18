package org.ey.service;

import org.ey.dto.*;
import org.ey.dao.UserDao;
import org.ey.helper.ResponseStructure;
import org.ey.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	JwtUtil jwtUtil;

	public ResponseStructure<User> register(User user) {
		User savedUser = userDao.save(user);
		ResponseStructure<User> response = new ResponseStructure<>();
		response.setMessage("User registered successfully");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(savedUser);
		return response;
	}

	public ResponseStructure<String> login(User user) {
		User fetchedUser = userDao.findByUsername(user.getUsername());
		ResponseStructure<String> response = new ResponseStructure<>();
		if (fetchedUser != null && fetchedUser.getPassword().equals(user.getPassword())) {
			String token = jwtUtil.generateToken(fetchedUser);
			response.setMessage("User logged in successfully");
			response.setStatusCode(HttpStatus.OK.value());
			response.setData(token);
		} else {
			response.setMessage("Invalid username or password");
			response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		}
		return response;
	}

}
