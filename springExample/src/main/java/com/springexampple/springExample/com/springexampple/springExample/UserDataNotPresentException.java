package com.springexampple.springExample.com.springexampple.springExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserDataNotPresentException extends RuntimeException{

	public UserDataNotPresentException(String message) {
		super(message);
	}

	
}
