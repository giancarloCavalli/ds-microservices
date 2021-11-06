package com.gcavalli.hruser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcavalli.hruser.entities.User;
import com.gcavalli.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User findById(Long id) {
		Optional<User> result = repo.findById(id);
		User entity = result.orElseThrow(() -> new RuntimeException("Resource not found"));
		return entity;
	}

	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
}
