package com.cg.cars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error,HttpStatus.OK);
		
	}
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleAppointmentNotFoundException(AppointmentNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error,HttpStatus.OK);
		
	}
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleAddressNotFoundException(AddressNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error,HttpStatus.OK);
		
	}
	
	@ExceptionHandler(CardNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCardNotFoundException(CardNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error,HttpStatus.OK);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity(error,HttpStatus.OK);
		
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
