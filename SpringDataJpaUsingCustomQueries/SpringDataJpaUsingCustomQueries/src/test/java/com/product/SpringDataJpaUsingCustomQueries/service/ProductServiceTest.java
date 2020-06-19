package com.product.SpringDataJpaUsingCustomQueries.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.product.SpringDataJpaUsingCustomQueries.Exception.NoDataFoundException;
import com.product.SpringDataJpaUsingCustomQueries.Exception.ProductNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.repository.ProductRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepository productRepository;

	@Test
	public void testSaveForPositive() {
		Product product = new Product();
		product.setpId(2);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn((product));
		Product resProduct = productService.save(product);
		Assert.assertNotNull(resProduct);
		Assert.assertEquals(product.getpName(), resProduct.getpName());
	}

	@Test(expected = NullPointerException.class)
	public void testSaveForNegitive() {
		Product product=new Product();
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenThrow(NullPointerException.class);
		Product resProduct = productService.save(product);
	}

	@Test
	public void testFindByIdForPositive() throws ProductNotFoundException {
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(product));

		Product resProduct = productService.findById(1);
		Assert.assertNotNull(resProduct);
		Assert.assertEquals(product.getpName(), resProduct.getpName());
	}

	@Test(expected = ProductNotFoundException.class)
	public void testFindByIdForExce() throws ProductNotFoundException {
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		Mockito.when(productRepository.findById(2)).thenReturn(Optional.of(product));

		Product resEmployee = productService.findById(1);

	}

	@Test
	public void testListAllForPosite() {

		List<Product> products = new ArrayList();

		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		 product = new Product();
		product.setpId(2);
		product.setpName("celkon");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(products);
		List<Product> products2 = productService.listAll();
		Assert.assertNotNull(products2);
		Assert.assertEquals(products2.size(), products.size());

	}

	@Test(expected = NoDataFoundException.class)
	public void testListAllForNegative() {
		Mockito.when(productRepository.findAll()).thenThrow(NoDataFoundException.class);
		List<Product> products2 = productService.listAll();
	}

	@Test
	public void testfindbypnameContainingForPositive() {
		List<Product> products = new ArrayList();
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productRepository.findBypNameContaining("samsung")).thenReturn(products);

		List<Product> products2 = productService.findByPNameContaining("samsung");
		Assert.assertNotNull(products2);
		Assert.assertEquals(products.size(), products.size());
	}


	@Test(expected = Exception.class)
	public void testfindbypnameContainingForException() {

		Mockito.when(productRepository.findBypNameContaining("calculator")).thenThrow(Exception.class);

		List<Product> products2 = productService.findByPNameContaining("samsung");
	}
	@Test
	public void testfindfindbyPnameLikeForPositive() {
		List<Product> products = new ArrayList();
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productRepository.findBypNameLike("samsung")).thenReturn(products);

		List<Product> products2 = productService.findByPNameLike("samsung");
		Assert.assertNotNull(products2);
		Assert.assertEquals(products.size(), products.size());
	}
	@Test(expected = Exception.class)
	public void testfindfindbyPnameLikeForException() {

		Mockito.when(productRepository.findBypNameLike("box")).thenThrow(Exception.class);

		List<Product> products2 = productService.findByPNameLike("box");
	}
	@Test
	public void testfindByPriceLessThanEqualForPositive() {
		List<Product> products = new ArrayList();
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productRepository.findBypriceLessThanEqual("12356")).thenReturn(products);

		List<Product> products2 = productService.findBypriceLessThanEqual("12356");
		Assert.assertNotNull(products2);
		Assert.assertEquals(products.size(), products.size());
	}
	

}
