package com.example.BankingApplication1.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplication1.dto.CustomerDto;
import com.example.BankingApplication1.exceptions.CustomerNotFoundException;
import com.example.BankingApplication1.exceptions.DuplicateEntryException;
import com.example.BankingApplication1.exceptions.InavalidCredentials;
import com.example.BankingApplication1.exceptions.InsufficientCustomerDetails;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	private CustomerDto customerDto = new CustomerDto();

	public CustomerDto customerRegistration(Customer customer) {
		if (customer.getPassword() != null) {

			try {
				customer = customerRepository.save(customer);
			} catch (Exception e) {
				throw new DuplicateEntryException();
			}
			BeanUtils.copyProperties(customer, customerDto);
			return customerDto;
		} else {
			throw new InsufficientCustomerDetails();
		}
	}

	public Customer UpdateCustomer(Customer customer) {
		if (customer.getPassword() != null) {
			return customerRepository.save(customer);
		} else {
			throw new InsufficientCustomerDetails();
		}
	}

	public Customer customerLogin(CustomerDto customerDto) {

		Customer customer = customerRepository.findByEmailAndPassword(customerDto.getEmail(),
				customerDto.getPassword());
		if (customer == null) {
			throw new InavalidCredentials();
		}
		System.out.println("------------" + customer.getEmail() + " " + customer.getPassword());
		return customer;
	}

	public Customer getCustomerById(long id) {

		return customerRepository.findById(id).get();
	}

	public Customer getCustomerByPhonumber(String phoneNumber) throws CustomerNotFoundException {

		Customer customer = customerRepository.findByPhoneNumber(phoneNumber);

		if (customer == null) {

			throw new CustomerNotFoundException(phoneNumber);

		} else {

			return customer;

		}

	}
}
