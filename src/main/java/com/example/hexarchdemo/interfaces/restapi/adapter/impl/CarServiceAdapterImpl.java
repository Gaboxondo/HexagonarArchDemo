package com.example.hexarchdemo.interfaces.restapi.adapter.impl;

import com.example.hexarchdemo.application.CarService;
import com.example.hexarchdemo.interfaces.restapi.adapter.mapper.CarRestApiMapper;
import com.example.hexarchdemo.interfaces.restapi.exceptions.CarsRestAPiErrorCodes;
import com.example.hexarchdemo.config.exceptionhandling.model.BussinessException;
import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.interfaces.restapi.adapter.CarServiceAdapter;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CreateCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceAdapterImpl implements CarServiceAdapter {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRestApiMapper carRestApiMapper;

    @Override
    public CarDTO createCar(CreateCarDTO createCarDTO) {
        if(createCarDTO == null){
            throw new BussinessException( CarsRestAPiErrorCodes.CREATE_CAR_DTO_NULL,"The creation of the car object is null" );
        }
        Car car = carService.createCar( createCarDTO.getModel(), createCarDTO.getCarColor() );
        return carRestApiMapper.fromDomainToDTO( car );
    }
}
