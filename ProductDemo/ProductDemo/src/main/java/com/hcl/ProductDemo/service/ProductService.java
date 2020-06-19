package com.hcl.ProductDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ProductDemo.model.Product;
import com.hcl.ProductDemo.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product findById(int pId)  {
		return productRepository.findById(pId).get();
		
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public String delete(int pId) {
		productRepository.deleteById(pId);
		return "succeess";
	}

	public List<Product> listAll() {
		return productRepository.findAll();
		
	}

}
