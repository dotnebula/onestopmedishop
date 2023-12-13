package com.mariaj.onestopmedishop.exceptions;

public class UnauthorizedException extends RuntimeException{

	private static final long serialVersionUID = 6250524378271226227L;
	
	public UnauthorizedException(String message) {
		super(message);
	}
}

