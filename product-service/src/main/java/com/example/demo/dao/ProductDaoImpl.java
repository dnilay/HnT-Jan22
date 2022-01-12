package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ProductNotFoundException;
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

	@Override
	@Transactional
	public Product getProductById(String productId) {
		TypedQuery<Product> query = entityManager.createQuery("SELECT P FROM Product P where P.productId=:pId",
				Product.class);
		query.setParameter("pId", productId);
		List<Product> list=query.getResultList();
		
		System.out.println(list);
		if(list.isEmpty())
		{
			throw new ProductNotFoundException("product with id "+productId+" not found");
		}
		return list.get(0);
	}

	@Override
	@Transactional
	public void deleteProductById(String productId) {
		Product product=getProductById(productId);
		entityManager.remove(product);

	}

	@Override
	@Transactional
	public Product updateProductById(Product product, String productId) {
		Product product1=getProductById(productId);
		product1.setProductName(product.getProductName());
		product1.setProductType(product.getProductType());
		entityManager.merge(product1);
		return product1;
	}

}
