package com.example.hungerbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hungerbox.dto.OrderDto;
import com.example.hungerbox.dto.ResponseDto;
import com.example.hungerbox.exception.EmployeeNotFoundException;
import com.example.hungerbox.exception.ItemNotFoundException;
import com.example.hungerbox.exception.OrderDetailsNotFoundException;
import com.example.hungerbox.exception.PaymentNotSuccessfulException;
import com.example.hungerbox.service.OrderService;

@RestController
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	 
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<ResponseDto> placeOrder(@RequestBody OrderDto orderDto) throws EmployeeNotFoundException, ItemNotFoundException, PaymentNotSuccessfulException  {
		ResponseDto message =orderService.saveOrder(orderDto);
		logger.info("place order in OrderController");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
