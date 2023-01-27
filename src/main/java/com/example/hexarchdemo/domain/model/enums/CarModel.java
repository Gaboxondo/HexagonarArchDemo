package com.example.hexarchdemo.domain.model.enums;

public enum CarModel {

    FERRARI("Ferrari"),
    BWM("BWM"),
    SEAT("Seat");

    private String model;

    CarModel(String carModel){
        this.model = carModel;
    }

    public String getModel() {
        return model;
    }

    public static CarModel fromModel(String model){
        for(CarModel carModel : values()){
            if(carModel.model.equals( model )){
                return carModel;
            }
        }
        return null;
    }
}
