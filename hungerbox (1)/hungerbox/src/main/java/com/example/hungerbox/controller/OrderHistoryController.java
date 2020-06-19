package com.example.hungerbox.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hungerbox.dto.OrderItemsListResponseDto;
import com.example.hungerbox.service.OrderHistoryService;


/**
 * 
 * @author GowriSankar
 * @version 1.0
 * this is class for order history
 */
@RestController
@RequestMapping("/orderHistories")
public class OrderHistoryController {
	@Autowired
	OrderHistoryService orderHistoryService;
	
	
	/**
	 * 
	 * @param employeeId
	 * @return List<OrderItemsListResponseDto>
	 */
	@GetMapping("/")
	public ResponseEntity<List<OrderItemsListResponseDto>> showHistory(@Valid @RequestParam long employeeId){
		List<OrderItemsListResponseDto> responseOrders = new ArrayList<>();
		responseOrders = orderHistoryService.showTransaction(employeeId);
		return new ResponseEntity<>(responseOrders,HttpStatus.OK);
	}
}
