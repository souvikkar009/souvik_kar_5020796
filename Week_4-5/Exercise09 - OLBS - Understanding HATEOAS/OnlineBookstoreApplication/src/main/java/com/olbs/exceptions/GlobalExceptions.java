package com.olbs.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ErrorDetails> bookExceptionHandler(BookException bookException, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(bookException.getMessage(), webRequest.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(customerException.getMessage(), webRequest.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
