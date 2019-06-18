package com.sapient.test.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sapient.test.response.Meta;
import com.sapient.test.response.ResponseEntity;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { InvalidMatchIdException.class })
	protected ResponseEntity<Object> handleInvalidMatchIdException(InvalidMatchIdException ex) {
		return new ResponseEntity<Object>(new Meta(ex.getErrorCode(), ex.getErrorMessage()), null);
	}
	
	@ExceptionHandler(value = { InternalServerException.class })
	protected ResponseEntity<Object> handleInvalidMatchIdException(InternalServerException ex) {
		return new ResponseEntity<Object>(new Meta(ex.getErrorCode(), ex.getErrorMessage()), null);
	}
}
