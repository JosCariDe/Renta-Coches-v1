package com.example.carrosCaribenios.dto.rent;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record RentToSaveDto(
        Long id,
        String ciudad,
        String modelo,
        String marca,
        LocalDate fechaInicio,
        LocalDate fechaFinal,
        Float precio,
        String url
) {
}
