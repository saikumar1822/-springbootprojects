package com.hcl.SpringBootCRUD.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.SpringBootCRUD.controller.BookController;
import com.hcl.SpringBootCRUD.model.Book;
import com.hcl.SpringBootCRUD.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;
	
	 public List<Book> listAll() {
	        return  bookRepository.findAll();
	    }
	     
	    public void saveBook(Book book) {
	    	bookRepository.save(book);
	    	LOGGER.warn("in service layer");
	    	
	    }
	     
	    public Book get(int id) {
	        return bookRepository.findById(id).get();
	    }
	     
	    public void delete(int id) {
	    	bookRepository.deleteById(id);
	    	
	    }

}
