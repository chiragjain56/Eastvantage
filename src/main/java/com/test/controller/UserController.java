package com.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.exceptions.UserException;
import com.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<?> byId(@RequestParam Integer id) throws UserException {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}
}
