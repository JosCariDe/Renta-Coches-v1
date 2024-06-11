package com.example.carrosCaribenios.dto.client;



import lombok.Builder;

@Builder
public record ClientToSaveDto(
        Long id,
        String nombre,
        String apellido,
        Integer cedula,
        String correo,
        Integer numeroCelular
) {
}
