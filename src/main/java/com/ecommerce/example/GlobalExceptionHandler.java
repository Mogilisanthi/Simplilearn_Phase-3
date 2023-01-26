package com.ecommerce.example;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	//general exception handler
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<?> handleNotFoundException(Exception exception,WebRequest request){
		ErrorMsg details=new ErrorMsg(new Date(),exception.getMessage(),request.getDescription(false) );
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
