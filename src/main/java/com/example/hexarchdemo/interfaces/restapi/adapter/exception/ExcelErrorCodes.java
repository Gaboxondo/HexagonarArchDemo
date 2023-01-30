package com.example.hexarchdemo.interfaces.restapi.adapter.exception;

import com.example.hexarchdemo.config.exceptionhandling.errorCodes.BaseErrorCode;

public enum ExcelErrorCodes implements BaseErrorCode {

    ERROR_READING_MULTIPART( Prefix.EXCEL_BUSSINES_PREFIX + "00"),
    ERROR_CREATING_WORKBOOK_FROM_MULTIPART( Prefix.EXCEL_BUSSINES_PREFIX + "01"),
    ERROR_CLOSING_MULTIPART( Prefix.EXCEL_BUSSINES_PREFIX + "02"),;

    public String code;

    ExcelErrorCodes(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    public static class Prefix {
        static final String EXCEL_BUSSINES_PREFIX = "excel.restapi.error.";
    }
}
