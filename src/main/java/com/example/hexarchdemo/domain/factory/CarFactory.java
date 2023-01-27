package com.example.hexarchdemo.domain.factory;

import com.example.hexarchdemo.config.exceptionhandling.model.BussinessException;
import com.example.hexarchdemo.domain.exception.CarsErrorCodes;
import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.model.enums.CarColor;
import com.example.hexarchdemo.domain.model.enums.CarModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarFactory {

    public Car createCar(String carModelReceived, String carColorreceived) {
        Car createdCar = new Car();

        CarModel carModel = CarModel.fromModel( carModelReceived );
        if (carModel == null) {
            throw new BussinessException( CarsErrorCodes.NOT_VALID_CAR_MODEL,
                "The model " + carModelReceived + " is not valid, only valid colors are [Ferrari, BWM or Seat]" );
        }
        createdCar.setModel( carModel );
        CarColor carColor = CarColor.fromColor( carColorreceived );
        if (carColor == null) {
            throw new BussinessException( CarsErrorCodes.NOT_VALID_CAR_COLOR,
                "The color " + carColorreceived + " is not valid, only valid colors are [blue, red]" );
        }
        createdCar.setColor( carColor );

        String carPlate = UUID.randomUUID().toString();
        createdCar.setCarPlate(carPlate);

        return createdCar;
    }
}
