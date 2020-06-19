package com.example.hungerbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hungerbox.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
