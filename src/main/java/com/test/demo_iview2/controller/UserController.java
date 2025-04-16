package com.test.demo_iview2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo_iview2.entities.User;
import com.test.demo_iview2.service.AuthenticationService;

@RestController
@RequestMapping("api/v1/user/auth")
public class UserController {


	@Autowired
	private AuthenticationService authenticationService;
	
	//1
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		return ResponseEntity.ok(authenticationService.registerUser(user));
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user)
	{
		boolean isSuccess=authenticationService.loginUser(user.getUsername(), user.getPassword());
	
		if(isSuccess)
			return  ResponseEntity.ok("User Logged in Successfully!!");
		else
			return ResponseEntity.ok("Login failed!!");
			
	}
}
