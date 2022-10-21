package com.test.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserException extends Exception {
	public UserException(String message) {
		super(message);
	}
}
