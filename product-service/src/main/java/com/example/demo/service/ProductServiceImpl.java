package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;
	private final ModelMapper modelMapper;

	public ProductServiceImpl(ProductDao productDao, ModelMapper modelMapper) {
		this.productDao = productDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		productDto.setProductId(UUID.randomUUID().toString());
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product=modelMapper.map(productDto, Product.class);
		
		return modelMapper.map(productDao.createNewProduct(product),ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	List<Product> list=productDao.getAllProducts();
	List<ProductDto> dtos=new ArrayList<ProductDto>();
	for(Product p:list)
	{
		dtos.add(modelMapper.map(p, ProductDto.class));
	}
		return dtos;
	}

}
