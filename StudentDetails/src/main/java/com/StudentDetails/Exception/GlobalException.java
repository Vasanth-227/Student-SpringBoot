package com.StudentDetails.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalException {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> ageExcep(AgeException ae) {
		return new ResponseEntity<Object> (ae.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
