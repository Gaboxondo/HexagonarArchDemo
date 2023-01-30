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
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public List<CarDTO> createCarsFromExcel(MultipartFile file) {
        List<CarDTO> carsCharacteristic = carRestApiMapper.fromExcelToDTO( file );
        List<Car> cars = new ArrayList<>();
        for(CarDTO carDTO : carsCharacteristic){
            Car car = carService.createCar( carDTO.getCarModel(), carDTO.getCarColor() );
            cars.add( car );
        }

        return cars.stream().map(carRestApiMapper::fromDomainToDTO).collect( Collectors.toList());
    }
}
