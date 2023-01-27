package com.example.hexarchdemo.interfaces.restapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarDTO {

    private String carColor;

    private String model;

}
