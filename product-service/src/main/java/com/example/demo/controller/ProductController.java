package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import com.example.demo.ui.ProductRequestModel;
import com.example.demo.ui.ProductResponseModel;

@RestController
public class ProductController {

	private final Environment environment;
	private final ProductService productService;
	private final ModelMapper modelMapper;

	public ProductController(Environment environment, ProductService productService, ModelMapper modelMapper) {
		this.environment = environment;
		this.productService = productService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/")
	public ResponseEntity<String> getStatus() {
		return ResponseEntity
				.ok("product-ws is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/products")
	public ResponseEntity<ProductResponseModel> createProduct(@RequestBody ProductRequestModel productRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductDto productDto = productService.createProduct(modelMapper.map(productRequestModel, ProductDto.class));

		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(productDto, ProductResponseModel.class));
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductResponseModel> findProductById(@PathVariable("productId") String productId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductResponseModel productResponseModel = modelMapper.map(productService.findProductById(productId),
				ProductResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(productResponseModel);
	}

	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		List<ProductDto> list = productService.getAllProducts();
		List<ProductResponseModel> productResponseModels = new ArrayList<ProductResponseModel>();

		Iterator<ProductDto> iterator = list.iterator();
		while (iterator.hasNext()) {
			productResponseModels.add(modelMapper.map(iterator.next(), ProductResponseModel.class));
		}

		return ResponseEntity.ok(productResponseModels);

	}

}
