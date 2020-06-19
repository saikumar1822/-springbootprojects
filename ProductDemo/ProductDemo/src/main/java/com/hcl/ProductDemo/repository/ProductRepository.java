package com.hcl.ProductDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ProductDemo.model.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	List<Product> findBypNameContaining(String PName);
	
	List<Product> findBypNameStartingWith(String PName);
	
	List<Product> findBypNameLike(String PName);
	
	List<Product> findBypriceLessThanEqual(String price);
	
	List<Product> findBypriceGreaterThanEqual(String price);
}
