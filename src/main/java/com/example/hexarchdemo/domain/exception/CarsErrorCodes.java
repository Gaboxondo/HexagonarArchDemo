package com.example.hexarchdemo.domain.exception;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;

public enum CarsErrorCodes implements BaseErrorCode {

    NOT_VALID_CAR_COLOR( Prefix.CAR_BUSSINES_PREFIX + "00"),
    NOT_VALID_CAR_MODEL( Prefix.CAR_BUSSINES_PREFIX + "01");

    public String code;

    CarsErrorCodes(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    public static class Prefix {
        static final String CAR_BUSSINES_PREFIX = "cars.bussiness.error.";
    }
}
