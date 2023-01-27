package com.example.hexarchdemo.infrastructure.ddbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSql {

    @Id
    private String carPlate;

    private String carModel;

    private String carColor;
}
