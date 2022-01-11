package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@RestController
public class ProductController {
	
	
	private ProductDao productDao;
	private Environment environment;

	@Autowired
	public ProductController(ProductDao productDao,Environment environment) {
		this.productDao = productDao;
		this.environment=environment;
	}
	
	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("product-ws is up and running on port: "+environment.getProperty("local.server.port"));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return ResponseEntity.ok( productDao.getAllProducts());
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		product.setProductId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(productDao.createNewProduct(product));
	}
	

}
