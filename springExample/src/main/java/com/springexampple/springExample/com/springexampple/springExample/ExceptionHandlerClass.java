package com.springexampple.springExample.com.springexampple.springExample;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest req) {
		ExceptionResponse exceptionRes = new ExceptionResponse(new Date(),req.getDescription(false));
		return new ResponseEntity(exceptionRes,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserDataNotPresentException.class)
	public final ResponseEntity<Object> handleUserDataNotFoundExceptions(Exception e, WebRequest req) {
		ExceptionResponse exceptionRes = new ExceptionResponse(new Date(),e.getMessage());
		return new ResponseEntity(exceptionRes,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exceptionRes = new ExceptionResponse(new Date(),ex.getBindingResult().toString());
		return new ResponseEntity(exceptionRes,HttpStatus.BAD_REQUEST);
	}
}
