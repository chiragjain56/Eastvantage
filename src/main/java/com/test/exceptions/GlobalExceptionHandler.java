package com.test.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp,
			WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.METHOD_NOT_ALLOWED);
	}


	@ExceptionHandler(UserException.class)
	public ResponseEntity<?> handleUserException(UserException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<?> handleAppointmentException(AppointmentException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.METHOD_NOT_ALLOWED);
	}

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest req) {
//		List<String> details = new ArrayList<>();
//		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//			details.add(error.getDefaultMessage());
//		}
//		MyErrorDetails error = new MyErrorDetails(LocalDateTime.now(), details.toString(), req.getDescription(false));
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}

}

