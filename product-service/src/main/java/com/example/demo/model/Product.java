package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PRODUCT_TABLE")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "PRODUCT_ID", unique = true)
	private String productId;
	@Column(name = "PRODUCT_NAME", unique = true)
	private String productName;
	@Column(name = "PRODUCT_TYPE")
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	@Column(nullable = false,name = "DELIVERABLE")
	@JsonProperty
	private Boolean isDeliverable;
	@Column(name = "PRODUCT_PRICE",nullable = false)
	private Double productPrice;
	public Product(String productId, String productName, ProductType productType, Boolean isDeliverable,
			Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.isDeliverable = isDeliverable;
		this.productPrice = productPrice;
	}
	

	

}
