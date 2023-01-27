package com.example.hexarchdemo.config.exceptionhandling.handler;

import com.example.hexarchdemo.config.exceptionhandling.handler.model.ExceptionDTO;
import com.example.hexarchdemo.config.exceptionhandling.model.BaseException;
import com.example.hexarchdemo.config.exceptionhandling.model.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {

    private final Logger LOGGER = LoggerFactory.getLogger( ExceptionHandlerController.class);


    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO handleException(BussinessException ex) {
        return new ExceptionDTO(ex.getErrorCode(),ex.getDescriptionMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDTO handleException(Exception ex) {
        LOGGER.error( "context: ",ex );
        return new ExceptionDTO("generic.error","Generic error, contact with support Team");
    }
}
