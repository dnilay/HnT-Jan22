package com.example.demo.exception;

import com.example.demo.ui.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(UserNotFoundException e)
    {
        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
        errorResponseModel.setMessage(e.getMessage());
        errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
        return ResponseEntity.status(errorResponseModel.getStatusCode()).body(errorResponseModel);
    }
}
