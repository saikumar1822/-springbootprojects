package com.hcl.ProductDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ProductDemo.model.Product;
import com.hcl.ProductDemo.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("product/{pId}")
	public ResponseEntity<Product> getProduct(@PathVariable int pId ) {
		
		Product product = productService.findById(pId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping("product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
	
		Product product1 = productService.save(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}

	@PutMapping("product")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product product) {
		
		productService.save(product);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("product/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pId) {
		
		productService.delete(pId);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	@GetMapping("products")
	public ResponseEntity<List<Product>> ListAll() {
		List<Product> products = productService.listAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	
}
