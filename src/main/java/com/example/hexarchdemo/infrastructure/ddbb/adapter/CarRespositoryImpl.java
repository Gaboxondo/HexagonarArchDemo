package com.example.hexarchdemo.infrastructure.ddbb.adapter;

import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.repository.CarsRepository;
import com.example.hexarchdemo.infrastructure.ddbb.adapter.mapper.CarSqlMapper;
import com.example.hexarchdemo.infrastructure.ddbb.entity.CarSql;
import com.example.hexarchdemo.infrastructure.ddbb.jparepository.CarJpaReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarRespositoryImpl implements CarsRepository {

    @Autowired private CarSqlMapper carSqlMapper;

    @Autowired private CarJpaReposiotry carJpaReposiotry;

    @Override
    public Car saveCar(Car car) {
        CarSql carSql = carSqlMapper.fromDomainToSql( car );
        carSql = carJpaReposiotry.save( carSql );
        return carSqlMapper.fromSqlToDomain( carSql );
    }
}
