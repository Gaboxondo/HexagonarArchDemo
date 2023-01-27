package com.example.hexarchdemo.application;

import com.example.hexarchdemo.domain.model.Car;

public interface CarService {

    public Car createCar(String carModel, String carColor);
}
