package com.example.BankingApplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingApplication1.dto.CustomerDto;
import com.example.BankingApplication1.exceptions.CustomerNotFoundException;
import com.example.BankingApplication1.exceptions.CustomerNotLoggedIn;
import com.example.BankingApplication1.exceptions.InavalidCredentials;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.service.CustomerService;
import com.example.BankingApplication1.utility.PasswordGeneration;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	PasswordGeneration  password = new PasswordGeneration();
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/registration")
	public ResponseEntity<CustomerDto> customerRegistration(@RequestBody Customer customer) {
		Customer customer1 = new Customer();
		CustomerDto customerDto=new CustomerDto();
		if (customer.getPassword() == null) {
			String pass = password.generatePassword(10);
			customer.setPassword(pass);

			 customerDto = customerService.customerRegistration(customer);
		}

		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody CustomerDto customerDto) {
		Customer customer = customerService.customerLogin(customerDto);
		if (customerDto.getPassword().equals(customer.getPassword())) {
			customer.setEnabled(true);
			customerService.UpdateCustomer(customer);
			return new ResponseEntity<String>("logged in successfully", HttpStatus.OK);
		} else {
			throw new InavalidCredentials();
		}
	}

	public ResponseEntity<String> isValidCustomer(@RequestParam long id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer.isEnabled()) {
			return new ResponseEntity<String>("user logged in successfully", HttpStatus.OK);
		} else {
			throw new CustomerNotLoggedIn();
		}
	}
	@GetMapping("/phoneno/{phoneNumber}")

	 public ResponseEntity<Customer> viewPhoneNo(@PathVariable String phoneNumber) throws CustomerNotFoundException {

	 Customer customer = customerService.getCustomerByPhonumber(phoneNumber);

	 return new ResponseEntity<Customer>(customer,HttpStatus.OK);

	 }

}
