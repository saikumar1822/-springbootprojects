package com.example.employee.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	private static final String MESSAGE = "message";
	@ExceptionHandler(NoEmployeeDataFoundException.class)
	public ResponseEntity<Object> handleNoEmployeeDataFoundException(NoEmployeeDataFoundException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "No Employee Data found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
