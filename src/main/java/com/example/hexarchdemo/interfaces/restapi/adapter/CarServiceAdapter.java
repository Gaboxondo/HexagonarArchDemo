package com.example.hexarchdemo.interfaces.restapi.adapter;

import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CreateCarDTO;

public interface CarServiceAdapter {

    CarDTO createCar(CreateCarDTO createCarDTO);
}
