package com.example.hexarchdemo.interfaces.restapi.adapter.mapper;

import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import org.springframework.stereotype.Component;

@Component
public class CarRestApiMapper {

    public CarDTO fromDomainToDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarColor( car.getColor().getColor() );
        carDTO.setCarPlate( car.getCarPlate() );
        carDTO.setCarModel( car.getModel().getModel() );

        return carDTO;
    }
}
