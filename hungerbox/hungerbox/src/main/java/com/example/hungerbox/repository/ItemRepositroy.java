package com.example.hungerbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hungerbox.model.Item;

public interface ItemRepositroy extends JpaRepository<Item, Long> {

}
