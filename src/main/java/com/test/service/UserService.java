package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.exceptions.UserException;
import com.test.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User save(User user) {
		return userRepo.save(user);
	}

	public User findById(Integer id) throws UserException {
		return userRepo.findById(id).orElseThrow(() -> new UserException("Not found!"));
	}

	public List<User> getAll() {
		return userRepo.findAll();
	}
}
