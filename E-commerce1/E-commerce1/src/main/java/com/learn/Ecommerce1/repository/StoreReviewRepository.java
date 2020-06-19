package com.learn.Ecommerce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce1.model.Store;
import com.learn.Ecommerce1.model.StoreReview;

public interface StoreReviewRepository extends JpaRepository<StoreReview, Long> {
	

	List<StoreReview> findByStore(Store s);
}
