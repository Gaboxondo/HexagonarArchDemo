package com.example.hexarchdemo.interfaces.restapi.controller;

import com.example.hexarchdemo.config.exceptionhandling.handler.model.ExceptionDTO;
import com.example.hexarchdemo.config.swagger.SwaggerProperties;
import com.example.hexarchdemo.interfaces.restapi.adapter.CarServiceAdapter;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CreateCarDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Api(tags = "cars controller")
public class CarsController {

    @Autowired
    private CarServiceAdapter carServiceAdapter;

    @ApiOperation( value = "Creates a new Car")
    @RequestMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST)
    @ApiResponses(value = {
        @ApiResponse( code = 500, response = ExceptionDTO.class,message = SwaggerProperties.GENERIC_ERROR_DEF),
        @ApiResponse( code = 400, response = ExceptionDTO.class, message = SwaggerProperties.BAD_REQUEST_DEF)})
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@RequestBody(required = false) CreateCarDTO createCarDTO) {
        return carServiceAdapter.createCar( createCarDTO );
    }

    @ApiOperation( value = "Creates a new Car")
    @RequestMapping(
        value = "/excel",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST)
    @ApiResponses(value = {
        @ApiResponse( code = 500, response = ExceptionDTO.class,message = SwaggerProperties.GENERIC_ERROR_DEF),
        @ApiResponse( code = 400, response = ExceptionDTO.class, message = SwaggerProperties.BAD_REQUEST_DEF)})
    @ResponseStatus(HttpStatus.CREATED)
    public List<CarDTO> createCarsFromExcel(@RequestParam("file") MultipartFile file) {
        return carServiceAdapter.createCarsFromExcel( file );
    }
}
