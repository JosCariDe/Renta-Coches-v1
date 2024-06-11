package com.example.carrosCaribenios.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "rentados")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String ciudad;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fechaFinal;
    @Column(nullable = false)
    private Float precio;
    private String url;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Client rentadoCliente;
}
