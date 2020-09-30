package com.springexampple.springExample.com.springexampple.springExample;

import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class ExceptionResponse {
	private Date date;
	private String message;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionResponse(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}
	public ExceptionResponse() {
		super();
	}
	
	
}
