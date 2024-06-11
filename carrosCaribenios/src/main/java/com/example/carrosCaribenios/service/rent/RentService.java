package com.example.carrosCaribenios.service.rent;

import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.exception.ClientNotFoundException;
import com.example.carrosCaribenios.exception.RentNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentService {
    RentDto guardarCarro(RentToSaveDto rentDto);
    RentDto actualizarCarro(Long id, RentToSaveDto rentDto);
    RentDto buscarCarroPorId(Long id) throws RentNotFoundException;
    void removerCarro(Long id);
    List<RentDto> gerAllCarros();
    List<RentDto> filtrarPorCiudadYFechas(String ciudad, LocalDate fechaInicio, LocalDate fechaFinal) throws RentNotFoundException;

}
