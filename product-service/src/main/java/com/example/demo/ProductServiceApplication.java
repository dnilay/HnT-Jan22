package com.example.demo;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.model.ProductType;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final ProductDao productDao;

	public ProductServiceApplication(ProductDao productDao) {

		this.productDao = productDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productDao.createNewProduct(new Product(UUID.randomUUID().toString(), "Pencil", ProductType.HOUSE_HOLD));
		productDao.createNewProduct(
				new Product(UUID.randomUUID().toString(), "Mobile", ProductType.CONSUMER_ELECTRONICS));
		productDao.createNewProduct(new Product(UUID.randomUUID().toString(), "Book", ProductType.HOUSE_HOLD));
		productDao.createNewProduct(new Product(UUID.randomUUID().toString(), "Foot Ball", ProductType.TOY));
		productDao.createNewProduct(
				new Product(UUID.randomUUID().toString(), "Desktop", ProductType.CONSUMER_ELECTRONICS));

	}
	
	
	

}
