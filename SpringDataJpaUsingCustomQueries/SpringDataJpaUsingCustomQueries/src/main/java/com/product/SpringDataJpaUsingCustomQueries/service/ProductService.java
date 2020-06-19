package com.product.SpringDataJpaUsingCustomQueries.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.SpringDataJpaUsingCustomQueries.Exception.NoDataFoundException;
import com.product.SpringDataJpaUsingCustomQueries.Exception.ProductNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product findById(int pId) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(pId);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new ProductNotFoundException(pId);
		}
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public String delete(int pId) {
		productRepository.deleteById(pId);
		return "succeess";
	}

	public List<Product> listAll() {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty()) {
			throw new NoDataFoundException();
		}
		return products;
	}

	public List<Product> findByPNameContaining(String pName) {

		return productRepository.findBypNameContaining(pName);
	}

	public List<Product> findByPNameLike(String pName) {

		return productRepository.findBypNameLike(pName);
	}

	public List<Product> findBypriceLessThanEqual(String price) {

		return productRepository.findBypriceLessThanEqual(price);
	}

	public List<Product> findBypriceGreaterThanEqual(String price) {

		return productRepository.findBypriceGreaterThanEqual(price);
	}

	public List<Product> findBypNameStartingWith(String pName) {

		return productRepository.findBypNameStartingWith(pName);
	}

}
