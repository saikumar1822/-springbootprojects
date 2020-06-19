package com.learn.Ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce1.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	public Product findByName(String name);

}
