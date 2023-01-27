package com.example.hexarchdemo.infrastructure.ddbb.adapter.mapper;

import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.model.enums.CarColor;
import com.example.hexarchdemo.domain.model.enums.CarModel;
import com.example.hexarchdemo.infrastructure.ddbb.entity.CarSql;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import org.springframework.stereotype.Component;

@Component
public class CarSqlMapper {

    public CarSql fromDomainToSql(Car car){
        CarSql carSql = new CarSql();
        carSql.setCarColor( car.getColor().getColor() );
        carSql.setCarPlate( car.getCarPlate() );
        carSql.setCarModel( car.getModel().getModel() );

        return carSql;
    }

    public Car fromSqlToDomain(CarSql car){
        Car ca = new Car();
        ca.setColor( CarColor.fromColor( car.getCarColor()  ));
        ca.setCarPlate( car.getCarPlate() );
        ca.setModel( CarModel.fromModel( car.getCarModel()  ) );
        return ca;
    }
}
