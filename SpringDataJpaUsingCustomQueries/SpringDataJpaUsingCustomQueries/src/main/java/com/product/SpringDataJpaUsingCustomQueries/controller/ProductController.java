package com.product.SpringDataJpaUsingCustomQueries.controller;

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

import com.product.SpringDataJpaUsingCustomQueries.Exception.ProductNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.model.User;
import com.product.SpringDataJpaUsingCustomQueries.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	UserController userController;

	@GetMapping("product/{pId}")
	public ResponseEntity<Product> getProduct(@PathVariable int pId ,@RequestParam String userName) {
		userController.isValidUser(userName); 
		Product product = productService.findById(pId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping("product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product,@RequestParam String userName) {
		userController.isValidUser(userName); 
		Product product1 = productService.save(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}

	@PutMapping("product")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product product,@RequestParam String userName) {
		userController.isValidUser(userName);
		productService.save(product);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("product/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pId,@RequestParam String userName) {
		userController.isValidUser(userName);
		productService.delete(pId);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	@GetMapping("products")
	public ResponseEntity<List<Product>> ListAll(@RequestParam String userName) {
		userController.isValidUser(userName);
		List<Product> products = productService.listAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("products1/{pName}")
	public ResponseEntity<List<Product>> findbypnameContaining(@PathVariable String pName,@RequestParam String userName) {
		userController.isValidUser(userName);
		System.out.println(pName);
		List<Product> products = productService.findByPNameContaining(pName);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("products2/{pName}")
	public ResponseEntity<List<Product>> findbypnameLike(@PathVariable String pName,@RequestParam String userName) {
		userController.isValidUser(userName);
		List<Product> products = productService.findByPNameLike(pName);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("products3/{price}")
	public ResponseEntity<List<Product>> findBypriceLessThanEqual(@PathVariable String price,@RequestParam String userName) {
		userController.isValidUser(userName);
		List<Product> products = productService.findBypriceLessThanEqual(price);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@GetMapping("products4/{price}")
	public ResponseEntity<List<Product>> findBypriceGretearThanEqual(@PathVariable String price,@RequestParam String userName) {
		userController.isValidUser(userName);
		List<Product> products = productService.findBypriceGreaterThanEqual(price);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@GetMapping("products5/{pName}")
	public ResponseEntity<List<Product>> findBypNameStartingWith(@PathVariable String pName,@RequestParam String userName) {
		userController.isValidUser(userName); 
		List<Product> products = productService.findBypNameStartingWith(pName);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

}
