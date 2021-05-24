package com.cg.cars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {



	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
