package com.product.SpringDataJpaUsingCustomQueries.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.product.SpringDataJpaUsingCustomQueries.Exception.ProductNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.service.ProductService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testListAllMvc() throws Exception {

		List<Product> products = new ArrayList();

		Product product = new Product();
		product.setpId(2);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");

		Mockito.when(productService.listAll()).thenReturn(products);

		MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/products")).andReturn();
		String content = response.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void testSaveForPositive() {
		Product product = new Product();
		product.setpId(2);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		Mockito.when(productService.save(Mockito.any(Product.class))).thenReturn((product));
		ResponseEntity<Product> resProduct = productController.saveProduct(product, null);
		Assert.assertNotNull(resProduct);
		Assert.assertEquals("samsung", product.getpName());
	}

	@Test(expected = Exception.class)
	public void testSaveForExc() {
		Product product = new Product();
		Mockito.when(productService.save(Mockito.any(Product.class))).thenThrow(Exception.class);
		ResponseEntity<Product> resProduct = productController.saveProduct(product, null);
	}

	@Test
	public void testFindByIdForPositive() {
		Product product = new Product();
		product.setpId(1);
		product.setpName("samsung");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		Mockito.when(productService.findById(Mockito.anyInt())).thenReturn(product);

		ResponseEntity<Product> resProduct = productController.getProduct(1, null);
		Assert.assertNotNull(resProduct);
		Assert.assertEquals("samsung", product.getpName());
		Assert.assertEquals("2000", product.getPrice());
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
		Mockito.when(productService.findByPNameContaining("samsung")).thenReturn(products);
		ResponseEntity<List<Product>> products2 = productController.findbypnameContaining("samsung", null);
		Assert.assertNotNull(products2);
		Assert.assertEquals(((List<Product>) products2).size(), products.size());
	}

	@Test(expected = Exception.class)
	public void testfindbypnameContainingForException() {
		Mockito.when(productService.findByPNameContaining("calculator")).thenThrow(Exception.class);
		ResponseEntity<List<Product>> products2 = productController.findbypnameContaining("calculator", null);
	}

	@Test
	public void testfindbypnameLikeForPositive() {
		List<Product> products = new ArrayList();

		Product product = new Product();
		product.setpId(1);
		product.setpName("redmi");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productService.findByPNameLike("redmi")).thenReturn(products);
		ResponseEntity<List<Product>> products2 = productController.findbypnameLike("redmi", null);
		Assert.assertNotNull(products2);
		Assert.assertEquals(products.size(), ((List<Product>) products2).size());
	}

	@Test(expected = NullPointerException.class)
	public void testfindbypnameLikeForException() {
		Mockito.when(productService.findByPNameLike("iphone")).thenThrow(NullPointerException.class);
		ResponseEntity<List<Product>> products2 = productController.findbypnameLike("iphone", null);
	}

	@Test
	public void testfindBypriceLessThanEqualForPositive() {
		List<Product> products = new ArrayList();

		Product product = new Product();
		product.setpId(1);
		product.setpName("realme");
		product.setDescription("very good battery backup");
		product.setPrice("2000");
		product.setDate("1/2/2019");
		products.add(product);
		Mockito.when(productService.findBypriceLessThanEqual("1234")).thenReturn(products);
		ResponseEntity<List<Product>> products2 = productController.findBypriceLessThanEqual("1234", null);
		Assert.assertNotNull(products2);
		Assert.assertEquals(products.size(), ((List<Product>) products2).size());
	}

	@Test(expected = NumberFormatException.class)
	public void testfindBypriceLessThanEqualForExc() {
		Mockito.when(productService.findBypriceLessThanEqual("one hundard")).thenThrow(NumberFormatException.class);
		ResponseEntity<List<Product>> products2 = productController.findBypriceLessThanEqual("one hundard", null);

	}

	@Test
	public void testDeleteForPositive() throws Exception {
		Mockito.when(productService.delete(1)).thenReturn("succeess");
		mockMvc.perform(MockMvcRequestBuilders.delete("/product/1")).andExpect(status().isOk());
	}
}
