package com.example.hexarchdemo.infrastructure.ddbb.adapter;

import com.example.hexarchdemo.config.exceptionhandling.model.BussinessException;
import com.example.hexarchdemo.domain.exception.CarsErrorCodes;
import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.repository.CarsRepository;
import com.example.hexarchdemo.infrastructure.ddbb.adapter.mapper.CarSqlMapper;
import com.example.hexarchdemo.infrastructure.ddbb.entity.CarSql;
import com.example.hexarchdemo.infrastructure.ddbb.exception.DatabaseErrorCodes;
import com.example.hexarchdemo.infrastructure.ddbb.jparepository.CarJpaReposiotry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarRespositoryImpl implements CarsRepository {

    private final Logger LOGGER = LoggerFactory.getLogger( CarRespositoryImpl.class);

    @Autowired private CarSqlMapper carSqlMapper;

    @Autowired private CarJpaReposiotry carJpaReposiotry;

    @Override
    public Car saveCar(Car car) {
        CarSql carSql = carSqlMapper.fromDomainToSql( car );
        try {
            carSql = carJpaReposiotry.save( carSql );
        } catch(Exception e){
            LOGGER.error( String.valueOf( e ) );
            throw new BussinessException( DatabaseErrorCodes.DATA_H2_ACCESS_ERRRO, "Error in database access" );
        }
        return carSqlMapper.fromSqlToDomain( carSql );
    }
}
