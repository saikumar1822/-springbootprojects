package com.example.hungerbox.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hungerbox.dto.OrderItemsListResponseDto;
import com.example.hungerbox.exceptions.EmployeeNotFoundException;
import com.example.hungerbox.model.Employee;
import com.example.hungerbox.model.Order;
import com.example.hungerbox.model.OrderItemList;
import com.example.hungerbox.repository.EmployeeRepository;
import com.example.hungerbox.repository.OrderItemListRepository;
import com.example.hungerbox.repository.OrderRepository;

@Service
public class OrderHistoryService {
	
	@Autowired
	OrderItemListRepository orderItemListRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<OrderItemsListResponseDto> showTransaction(long employeeId){
		//Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("employee with given id not found"));
		//List<Order> order = orderRepository.findOrderByEmployee(employee);
		List<Order> order=lastFiveTransactions(employeeId);
		List<OrderItemsListResponseDto> resultOrderList = new ArrayList<>();
		for(int i=0;i<order.size();i++) {
			
			OrderItemsListResponseDto orderDto = new OrderItemsListResponseDto();
			List<OrderItemList> orderList = orderItemListRepository.findOrderItemListByOrder(order.get(i));
			orderDto.setOrderId(order.get(i).getOrderId());
			 orderDto.setItems(orderList); 
			 resultOrderList.add(orderDto);
		} 
		return resultOrderList;
	}
	
	public List<Order> lastFiveTransactions(long employeeId){
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("employee with given id not found"));
		List<Order> order = orderRepository.findOrderByEmployee(employee);
		Collections.reverse(order);
		List<Order> order1 = order.stream().limit(5).collect(Collectors.toList());
		return order1;
	}
}
