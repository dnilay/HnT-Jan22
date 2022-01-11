package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4131122211447736684L;
	

	private String message;
	

}
