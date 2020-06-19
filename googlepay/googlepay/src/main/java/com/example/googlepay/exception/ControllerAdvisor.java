package com.example.googlepay.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	private static final String MESSAGE = "message";

	@ExceptionHandler(TransactionNotFound.class)

	public ResponseEntity<Object> handleTransactionNotFoundException(TransactionNotFound ex,

			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();

		body.put(MESSAGE, "transaction details are not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AmountNotFoundException.class)
	public ResponseEntity<Object> handleAmountNotFoundException(AmountNotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "please enter the money");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InsufficientBalance.class)
	public ResponseEntity<Object> handleInsufficientBalance(InsufficientBalance ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "entered amount is the greater than the available balance");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PhoneNumberNotFoundException.class)
	public ResponseEntity<Object> handlePhoneNumberNotFoundException(PhoneNumberNotFoundException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "check your phone numbers");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)

	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,

			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();

		body.put("timestamp", LocalDateTime.now());

		body.put("message", "user phoneno not registered in bank service");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(RegistarionFailedException.class)

	public ResponseEntity<Object> handleRegistarionFailedException(RegistarionFailedException ex,

			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();

		body.put("timestamp", LocalDateTime.now());

		body.put("message", "registration already done");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

	}

}
