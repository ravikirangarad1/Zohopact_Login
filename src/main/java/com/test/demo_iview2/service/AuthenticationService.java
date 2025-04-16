package com.test.demo_iview2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo_iview2.entities.User;
import com.test.demo_iview2.repos.UserRepo;

@Service
public class AuthenticationService {
	
	@Autowired
	UserRepo userRepo;
	
	public User registerUser(User user)
	{
		return userRepo.save(user);
	}

	public boolean loginUser(String username, String password)
	{
		return userRepo.findByUserName(username).map(user->user.getPassword().equals(password))
				.orElse(false);
	}
}
