package com.bookstore.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookStoreExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ObjResponseEntity> handleException( ObjNotFoundException exc ){
		
		ObjResponseEntity err = new ObjResponseEntity(exc.getMessage(),
																HttpStatus.NOT_FOUND.value(),
																System.currentTimeMillis() );
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ObjResponseEntity> handleException( Exception exc ){
		
		ObjResponseEntity err = new ObjResponseEntity(exc.getMessage(),
																HttpStatus.BAD_REQUEST.value(),
																System.currentTimeMillis() );
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
}
