package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.ui.ErrorResponseModel;

@RestControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleProductNotFoundException(ProductNotFoundException e) {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
		errorResponseModel.setMessage(e.getMessage());
		errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ErrorResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}

}
