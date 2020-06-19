package com.hcl.RestTemplateDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public String listAllProducts() {
		String result=restTemplate.getForObject("http://localhost:8082/products" ,String.class);
		return result;
}
	public String getProductByPathVar(String userId) {
		System.out.println(userId+"jckdfbvkfhjbvj");
		String result=restTemplate.getForObject("http://localhost:8082/product/"+userId ,String.class);
		return result;
}

}
