package com.example.hungerbox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	RestTemplate restTemplate;
    @LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemListRepository orderItemListRepository;

	@Autowired

	EmployeeRepository employeeRepository;

	@Autowired
	ItemRepositroy itemRepositroy;

	public ResponseDto saveOrder(OrderDto orderDto)
			throws EmployeeNotFoundException, ItemNotFoundException, PaymentNotSuccessfulException  {
		
		
		double totalPrice = 0;
		Order order = new Order();
		logger.info("chencking the details of employeee");
		Employee employee = employeeRepository.findById(orderDto.getEmployeeId())
				.orElseThrow(() -> new EmployeeNotFoundException("user with given id not found"));

		order.setEmployee(employee);
		List<Long> itemIds = orderDto.getItemDto().stream().map(m -> m.getItemId()).collect(Collectors.toList());
		List<Integer> quantity = orderDto.getItemDto().stream().map(m -> m.getQuantity()).collect(Collectors.toList());
		for (int i = 0; i < itemIds.size(); i++) {
			logger.info("checking the item details");
			Item item = itemRepositroy.findById(itemIds.get(i))
					.orElseThrow(() -> new ItemNotFoundException("user with given id not found"));
			totalPrice = totalPrice + (quantity.get(i) * item.getUnitPrice());
		}
		try {
			logger.info("processing payment ");

			payment(totalPrice, orderDto.getPhoneNo());
		} catch (Exception e) {
			throw new PaymentNotSuccessfulException("payment was not successfull");
		}

		order = orderRepository.save(order);

		for (int i = 0; i < itemIds.size(); i++) {
			Item item = itemRepositroy.findById(itemIds.get(i)).get();
			OrderItemList orderItemList = new OrderItemList();
			orderItemList.setOrder(order);
			orderItemList.setQuantity(quantity.get(i));
			orderItemList.setItem(item);
			orderItemListRepository.save(orderItemList);
		}
		order.setOrderPrice(totalPrice);
		logger.info("saving order details--------------");
		orderRepository.save(order);
		ResponseDto d = new ResponseDto();
		d.setMessage("order is placed successfully");
		return d;
	}

	public String payment(Double totalPrice, String phoneNo) {

		String amount = "" + totalPrice;
		String url = "http://BANKING-SERVICE/payment";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("phoneNo", phoneNo);
		params.put("toPhoneNo", "9666168535");
		params.put("amount", amount);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		String result = restTemplate.getForObject(builder.toUriString(), String.class);
		return result;

	}
}
