package com.example.demo.ui;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

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

	@NotNull
	@Length(min = 4, max = 50, message = "length must be between 4 to 50")
	private String productName;

	private ProductType productType;
	private Boolean isDeliverable;
	@NotNull
	@Range(min = 1, max = 1000)
	private Double productPrice;

}
