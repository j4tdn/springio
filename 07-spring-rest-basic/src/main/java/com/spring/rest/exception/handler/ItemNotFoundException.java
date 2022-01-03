package com.spring.rest.exception.handler;

public class ItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2937032489705343406L;

	public ItemNotFoundException(String message) {
		super(message);
	}
	
}
