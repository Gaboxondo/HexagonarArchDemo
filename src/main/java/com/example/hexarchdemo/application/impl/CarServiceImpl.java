package com.example.hexarchdemo.application.impl;

import com.example.hexarchdemo.application.CarService;
import com.example.hexarchdemo.domain.factory.CarFactory;
import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired private CarFactory carFactory;

    @Autowired private  CarsRepository carsRepository;

    @Override
    @Transactional
    public Car createCar(String carModel, String carColor) {
        Car car = carFactory.createCar( carModel, carColor );
        car = carsRepository.saveCar( car );
        return car;
    }
}
