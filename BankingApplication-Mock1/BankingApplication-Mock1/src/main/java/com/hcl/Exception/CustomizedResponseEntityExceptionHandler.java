package com.hcl.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mysql.cj.protocol.Message;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
		Map<String,Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());
		List<String> errors=ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountNotFound.class)
	public ResponseEntity<Object> AccountNotFound(AccountNotFound ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("TIMESTAmp ", LocalDateTime.now());
		body.put("message", "No Account data found with given account number");
		body.put("status", HttpStatus.NOT_FOUND);

		body.put("stackTrace", ex.getClass());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BanificiaryNotFoundException.class)
	public ResponseEntity<Object> DataNotFoundException(BanificiaryNotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "No Banificiarydata found with given account number");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
    
	
	@ExceptionHandler(UserNotfoundException.class)
	public ResponseEntity<Object> exception(UserNotfoundException exception) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message",exception.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InSufficientBalanceInAccount.class)
	public ResponseEntity<Object> InSufficientBalanceInAccount(InSufficientBalanceInAccount ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("TIMESTAmp ", LocalDateTime.now());
		body.put("message", "no sufficient balance in the Account Plese check the balance and try again");
		body.put("status", HttpStatus.BAD_REQUEST);

		body.put("stackTrace", ex.getClass());
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	
	

}
