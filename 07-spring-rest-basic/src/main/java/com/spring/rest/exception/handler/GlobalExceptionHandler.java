package com.spring.rest.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleCERException(ItemNotFoundException inf) {
		// status code, header, body
		CustomErrorResponse response = new CustomErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(inf.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exception) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
