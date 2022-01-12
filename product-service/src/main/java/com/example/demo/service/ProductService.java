package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;

public interface ProductService {

	public ProductDto createProduct(ProductDto productDto);

	public List<ProductDto> getAllProducts();
	
	public ProductDto findProductById(String productId);
	
	public void deleteProduct(String productId);
	
	public ProductDto updateProductById(ProductDto productDto,String productId);

}
