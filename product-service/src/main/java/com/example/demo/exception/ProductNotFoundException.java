package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7849753540934068963L;

	private String message;

}
