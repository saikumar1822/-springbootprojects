package com.example.hungerbox.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.hungerbox.dto.OrderDto;
import com.example.hungerbox.dto.ResponseDto;
import com.example.hungerbox.exception.EmployeeNotFoundException;
import com.example.hungerbox.exception.ItemNotFoundException;
import com.example.hungerbox.exception.PaymentNotSuccessfulException;
import com.example.hungerbox.model.Employee;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.model.Order;
import com.example.hungerbox.model.OrderItemList;
import com.example.hungerbox.repository.EmployeeRepository;
import com.example.hungerbox.repository.ItemRepositroy;
import com.example.hungerbox.repository.OrderItemListRepository;
import com.example.hungerbox.repository.OrderRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderServiceTest {

	@Mock
	OrderRepository orderRepository;

	@Mock
	OrderItemListRepository orderItemListRepository;

	@Mock

	EmployeeRepository employeeRepository;

	@Mock
	ItemRepositroy itemRepositroy;

	@InjectMocks
	OrderService orderService;

	ResponseDto responseDto = new ResponseDto();
	Employee employee = new Employee();
	OrderDto orderDto = new OrderDto();

	@Test(expected = NoSuchElementException.class)
	public void testSaveOrderForPositive() throws Exception {

		employee.setEmail("@gmail.com");
		employee.setEmployeeId(1l);
		employee.setEmployeeName("kumar");
		employee.setPassword("yerg");
		employee.setPhone("123456789");

		responseDto.setMessage("sucessful");
		responseDto.getMessage();

		Order order = new Order();
		order.setOrderId(1l);
		order.setEmployee(employee);
		Mockito.when(employeeRepository.findById(orderDto.getEmployeeId()).get()).thenReturn(employee);

		order.setEmployee(employee);

		Mockito.when(orderRepository.save(order)).thenReturn(order);

		Mockito.when(orderRepository.save(order)).thenReturn(order);
		ResponseDto responseDto1 = orderService.saveOrder(orderDto);

	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testSaveOrderForExceptio() throws Exception {
		employee.setEmail("@gmail.com");
		employee.setEmployeeId(1l);
		employee.setEmployeeName("kumar");
		employee.setPassword("yerg");
		employee.setPhone("123456789");
		responseDto.setMessage("sucessful");
		responseDto.getMessage();
		Order order = new Order();
		order.setOrderId(1l);
		order.setEmployee(employee);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		ResponseDto responseDto1 = orderService.saveOrder(orderDto);

	}

}
