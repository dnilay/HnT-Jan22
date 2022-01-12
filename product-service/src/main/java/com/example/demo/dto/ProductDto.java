package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
	private String productId;
	private String productName;
	private String productType;
	private Boolean isDeliverable;
	private Double productPrice;
}
