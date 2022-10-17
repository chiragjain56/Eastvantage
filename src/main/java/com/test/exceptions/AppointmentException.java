package com.test.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppointmentException extends Exception {
	public AppointmentException(String message) {
		super(message);
	}
}
