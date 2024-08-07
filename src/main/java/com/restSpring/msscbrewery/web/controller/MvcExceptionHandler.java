package com.restSpring.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class MvcExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
		List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());
		
		ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
		
		return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
		}
}
