package com.example.hexarchdemo.interfaces.restapi.exceptions;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;

public enum CarsRestAPiErrorCodes implements BaseErrorCode {

    CREATE_CAR_DTO_NULL( Prefix.CAR_REST_API_PREFIX + "00");

    public String code;

    CarsRestAPiErrorCodes(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    public static class Prefix {
        static final String CAR_REST_API_PREFIX = "cars.restapi.error.";
    }
}
