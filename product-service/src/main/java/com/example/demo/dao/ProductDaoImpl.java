package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;

@Repository
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager;

	@Autowired
	public ProductDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	
	public List<Product> getAllProducts() {
	
		TypedQuery<Product> query = entityManager.createQuery("SELECT P FROM Product P", Product.class);
		List<Product> list = query.getResultList();
		
		return list;
	}

	@Override
	@Transactional
	public Product createNewProduct(Product product) {
		
		entityManager.persist(product);
		
		return product;
	}

}
