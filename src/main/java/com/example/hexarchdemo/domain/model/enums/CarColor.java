package com.example.hexarchdemo.domain.model.enums;

public enum CarColor {

    BLUE("blue"),
    RED("red");

    private String color;

    CarColor(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static CarColor fromColor(String color){
        for(CarColor carColor : values()){
            if(carColor.color.equals( color )){
                return carColor;
            }
        }
        return null;
    }
}
