package com.example.demo.ui;

import com.example.demo.model.ProductType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestModel {

	private String productName;
	
	private ProductType productType;
	
}
