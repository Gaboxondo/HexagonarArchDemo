package com.example.hexarchdemo.config.exceptionhandling.model;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;
import lombok.Data;

@Data
public class BaseException extends RuntimeException{

    private String errorCode;
    private String descriptionMessage;

    public BaseException(BaseErrorCode errorCode, String descriptionMessage){
        this.errorCode = errorCode.getCode();
        this.descriptionMessage = descriptionMessage;
    }

}
