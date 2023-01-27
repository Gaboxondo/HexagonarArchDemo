package com.example.hexarchdemo.domain.model;

import com.example.hexarchdemo.domain.model.enums.CarColor;
import com.example.hexarchdemo.domain.model.enums.CarModel;
import lombok.Data;

@Data
public class Car {

    public CarColor color;

    public CarModel model;

    public String carPlate;
}
