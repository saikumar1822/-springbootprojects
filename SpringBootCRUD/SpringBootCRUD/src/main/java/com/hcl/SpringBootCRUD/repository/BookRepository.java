package com.hcl.SpringBootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.SpringBootCRUD.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
