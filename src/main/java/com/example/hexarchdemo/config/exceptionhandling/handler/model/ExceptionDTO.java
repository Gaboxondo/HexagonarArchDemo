package com.example.hexarchdemo.config.exceptionhandling.handler.model;

public class ExceptionDTO {

    public ExceptionDTO(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode;

    public String errorMessage;
}
