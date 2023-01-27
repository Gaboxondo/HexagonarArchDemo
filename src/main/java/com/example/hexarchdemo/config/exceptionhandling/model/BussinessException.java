package com.example.hexarchdemo.config.exceptionhandling.model;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;

public class BussinessException extends BaseException {
    public BussinessException(BaseErrorCode errorCode, String errorMessage) {
        super( errorCode,errorMessage );
    }
}
