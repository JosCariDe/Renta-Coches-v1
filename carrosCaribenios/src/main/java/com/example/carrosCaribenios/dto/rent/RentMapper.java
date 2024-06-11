package com.example.carrosCaribenios.dto.rent;

import com.example.carrosCaribenios.entitys.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RentMapper {
    RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

    Rent rentDtoToRent(RentDto rentDto);

    @Mapping(target = "rentadoCliente", ignore = true)
    Rent rentToSaveDtoToRent(RentToSaveDto rentToSaveDto);

    RentDto rentToRentDto(Rent rent);

    @Mapping(target = "rentadoCliente", ignore = true)
    RentDto rentToSaveDtoToRentDto(RentToSaveDto rentToSaveDto);

    RentToSaveDto rentToRentToSaveDto(Rent rent);

    List<Rent> rentsDtoToRents(List<RentDto> rentDtoList);

    List<Rent> rentToSaveDtoToRents(List<RentToSaveDto> rentToSaveDtoList);

    List<RentDto> rentsToRentsDto(List<Rent> rentList);
}
