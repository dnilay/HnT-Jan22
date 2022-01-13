package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseModel {

    private String message;
    private Long errorReportingTime;
    private Integer statusCode;
}
