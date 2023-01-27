package com.example.hexarchdemo.infrastructure.ddbb.exception;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;
import com.example.hexarchdemo.domain.exception.CarsErrorCodes;

public enum DatabaseErrorCodes implements BaseErrorCode {

    DATA_H2_ACCESS_ERRRO( DatabaseErrorCodes.Prefix.DATABASE_ERROR_CODE + "00"),;

    public String code;

    DatabaseErrorCodes(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    public static class Prefix {
        static final String DATABASE_ERROR_CODE = "ddbb.error.";
    }
}
