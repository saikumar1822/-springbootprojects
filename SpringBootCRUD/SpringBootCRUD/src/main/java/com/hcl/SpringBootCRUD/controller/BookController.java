package com.hcl.SpringBootCRUD.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootCRUD.model.Book;
import com.hcl.SpringBootCRUD.service.BookService;


@RestController
public class BookController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;
	
	@GetMapping("welcome1")
	private String method1(){
		LOGGER.warn("hello");
		return "welcome to spring boot appliction";
	}
	
	
	@GetMapping("book/{id}")
	private Book getBookById(@PathVariable int id){
		return bookService.get(id);
}

	@PostMapping("book")
	private int saveBook(@RequestBody Book book){
		bookService.saveBook(book);
		LOGGER.warn("controller in save method");
		return book.getBookId();
}

	@PutMapping("book")
	private int UpdateBook(@RequestBody Book book){
		bookService.saveBook(book);
		LOGGER.warn("controller in updatebook method");
		return book.getBookId();
}
	
	@DeleteMapping("book/{id}")
	private int deleteBookById(@PathVariable int id){
		bookService.delete(id);
		LOGGER.warn("controller");
		return id;
		
}

	@GetMapping("books")
	private List<Book> getAllBooks(){
		return bookService.listAll();
}


}
