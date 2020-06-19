package com.learn.Ecommerce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.Store;
import com.learn.Ecommerce1.model.StoreProduct;
import com.learn.Ecommerce1.model.StoreReview;

public interface StoreProductRepository extends JpaRepository<StoreProduct,Long> {

	List<StoreProduct> findByProduct(Product product);
	

}
