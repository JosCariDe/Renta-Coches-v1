package com.example.carrosCaribenios.dto.client;

import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.entitys.Rent;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record ClientDto(
        Long id,
        String nombre,
        List<RentToSaveDto> carrosRentados,
        String apellido,
        Integer cedula,
        String correo,
        Integer numeroCelular

) {
}
