package com.example.hexarchdemo.interfaces.restapi.adapter;

import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CreateCarDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarServiceAdapter {

    CarDTO createCar(CreateCarDTO createCarDTO);

    List<CarDTO> createCarsFromExcel(MultipartFile file);
}
