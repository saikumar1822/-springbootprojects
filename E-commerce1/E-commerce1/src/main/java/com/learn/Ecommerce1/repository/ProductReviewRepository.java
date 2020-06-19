package com.learn.Ecommerce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.ProductRating;

public interface ProductReviewRepository extends JpaRepository<ProductRating,Long>{
	
	List<ProductRating> findByProduct(Product product);
}
