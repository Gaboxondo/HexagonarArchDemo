package com.example.hexarchdemo.interfaces.restapi.adapter.mapper;

import com.example.hexarchdemo.config.exceptionhandling.model.BussinessException;
import com.example.hexarchdemo.domain.model.Car;
import com.example.hexarchdemo.domain.model.enums.CarModel;
import com.example.hexarchdemo.interfaces.restapi.adapter.exception.ExcelErrorCodes;
import com.example.hexarchdemo.interfaces.restapi.model.dto.CarDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarRestApiMapper {

    public CarDTO fromDomainToDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarColor( car.getColor().getColor() );
        carDTO.setCarPlate( car.getCarPlate() );
        carDTO.setCarModel( car.getModel().getModel() );

        return carDTO;
    }

    public List<CarDTO> fromExcelToDTO(MultipartFile file){

        InputStream fileAsStrem;
        try {
            fileAsStrem = file.getInputStream();
        } catch (IOException e) {
            throw new BussinessException( ExcelErrorCodes.ERROR_READING_MULTIPART,"Error reading the multipart file" );
        }

        Workbook workbook;
        try {
            workbook = new XSSFWorkbook( fileAsStrem );
        } catch (IOException e) {
            throw new BussinessException( ExcelErrorCodes.ERROR_CREATING_WORKBOOK_FROM_MULTIPART,"Error creating the excel workbook from multipart" );
        }

        Sheet sheet = workbook.getSheetAt( 0 );

        List<CarDTO> carDTOS = new ArrayList<>();
        for(Row row : sheet){
            Integer i = 1;
            CarDTO carDTO = new CarDTO();
            for(Cell cell : row){
                String cellValue = cell.getRichStringCellValue().getString();
                if(i == 1){
                    carDTO.setCarModel(cellValue);
                    CarModel carModel = CarModel.fromModel( cellValue );
                    if(carModel == null){
                        throw new BussinessException( ExcelErrorCodes.ERROR_CREATING_WORKBOOK_FROM_MULTIPART, "in row " + row.getRowNum() + " and cell " + cell.getColumnIndex() + " the car model " +  cellValue + " is not valid");
                    }
                } else if( i == 2){
                    carDTO.setCarColor(cellValue);
                    carDTOS.add( carDTO );
                }
                i++;
            }
        }

        try {
            fileAsStrem.close();
        } catch (IOException e) {
            throw new BussinessException( ExcelErrorCodes.ERROR_CREATING_WORKBOOK_FROM_MULTIPART,"Error creating the excel workbook from multipart" );
        }
        return carDTOS;
    }
}
