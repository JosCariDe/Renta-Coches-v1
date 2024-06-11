package com.example.carrosCaribenios.service.rent;

import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.dto.rent.RentMapper;
import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.entitys.Rent;
import com.example.carrosCaribenios.exception.ClientNotFoundException;
import com.example.carrosCaribenios.exception.RentNotFoundException;
import com.example.carrosCaribenios.repository.RentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService{

    private final RentRepository rentRepository;

    @PostConstruct
    public void init() {
        // Crear 10 coches rentados
        Rent rent1 = Rent.builder()
                .precio(500000.0F)
                .fechaInicio(LocalDate.parse("2024-01-01"))
                .fechaFinal(LocalDate.parse("2024-01-07"))
                .ciudad("Santa Marta")
                .marca("Toyota")
                .modelo("Corolla")
                .url("https://images.pexels.com/photos/120049/pexels-photo-120049.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent2 = Rent.builder()
                .precio(600000.0F)
                .fechaInicio(LocalDate.parse("2024-01-02"))
                .fechaFinal(LocalDate.parse("2024-01-08"))
                .ciudad("Bogotá")
                .marca("Honda")
                .modelo("Civic")
                .url("https://images.pexels.com/photos/70912/pexels-photo-70912.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent3 = Rent.builder()
                .precio(700000.0F)
                .fechaInicio(LocalDate.parse("2024-02-01"))
                .fechaFinal(LocalDate.parse("2024-02-07"))
                .ciudad("Medellín")
                .marca("Mazda")
                .modelo("3")
                .url("https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent4 = Rent.builder()
                .precio(800000.0F)
                .fechaInicio(LocalDate.parse("2024-03-01"))
                .fechaFinal(LocalDate.parse("2024-03-07"))
                .ciudad("Cali")
                .marca("Chevrolet")
                .modelo("Onix")
                .url("https://images.pexels.com/photos/244206/pexels-photo-244206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent5 = Rent.builder()
                .precio(900000.0F)
                .fechaInicio(LocalDate.parse("2024-04-01"))
                .fechaFinal(LocalDate.parse("2024-04-07"))
                .ciudad("Cartagena")
                .marca("Ford")
                .modelo("Focus")
                .url("https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent6 = Rent.builder()
                .precio(1000000.0F)
                .fechaInicio(LocalDate.parse("2024-05-01"))
                .fechaFinal(LocalDate.parse("2024-05-07"))
                .ciudad("Barranquilla")
                .marca("Hyundai")
                .modelo("Elantra")
                .url("https://images.pexels.com/photos/733745/pexels-photo-733745.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent7 = Rent.builder()
                .precio(1100000.0F)
                .fechaInicio(LocalDate.parse("2024-06-01"))
                .fechaFinal(LocalDate.parse("2024-06-07"))
                .ciudad("Bucaramanga")
                .marca("Kia")
                .modelo("Rio")
                .url("https://images.pexels.com/photos/544542/pexels-photo-544542.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent8 = Rent.builder()
                .precio(1200000.0F)
                .fechaInicio(LocalDate.parse("2024-07-01"))
                .fechaFinal(LocalDate.parse("2024-07-07"))
                .ciudad("Manizales")
                .marca("Nissan")
                .modelo("Sentra")
                .url("https://images.pexels.com/photos/248687/pexels-photo-248687.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent9 = Rent.builder()
                .precio(1300000.0F)
                .fechaInicio(LocalDate.parse("2024-08-01"))
                .fechaFinal(LocalDate.parse("2024-08-07"))
                .ciudad("Pereira")
                .marca("Volkswagen")
                .modelo("Jetta")
                .url("https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent10 = Rent.builder()
                .precio(1400000.0F)
                .fechaInicio(LocalDate.parse("2024-09-01"))
                .fechaFinal(LocalDate.parse("2024-09-07"))
                .ciudad("Armenia")
                .marca("Renault")
                .modelo("Logan")
                .url("https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent11 = Rent.builder()
                .precio(1500000.0F)
                .fechaInicio(LocalDate.parse("2024-10-01"))
                .fechaFinal(LocalDate.parse("2024-10-07"))
                .ciudad("Cúcuta")
                .marca("Suzuki")
                .modelo("Swift")
                .url("https://images.pexels.com/photos/303349/pexels-photo-303349.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent12 = Rent.builder()
                .precio(1600000.0F)
                .fechaInicio(LocalDate.parse("2024-11-01"))
                .fechaFinal(LocalDate.parse("2024-11-07"))
                .ciudad("Ibagué")
                .marca("Mitsubishi")
                .modelo("Lancer")
                .url("https://images.pexels.com/photos/164654/pexels-photo-164654.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent13 = Rent.builder()
                .precio(1700000.0F)
                .fechaInicio(LocalDate.parse("2024-12-01"))
                .fechaFinal(LocalDate.parse("2024-12-07"))
                .ciudad("Neiva")
                .marca("Subaru")
                .modelo("Impreza")
                .url("https://images.pexels.com/photos/977003/pexels-photo-977003.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent14 = Rent.builder()
                .precio(1800000.0F)
                .fechaInicio(LocalDate.parse("2024-01-01"))
                .fechaFinal(LocalDate.parse("2024-01-07"))
                .ciudad("Villavicencio")
                .marca("Mercedes")
                .modelo("A-Class")
                .url("https://images.pexels.com/photos/1007410/pexels-photo-1007410.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        Rent rent15 = Rent.builder()
                .precio(1900000.0F)
                .fechaInicio(LocalDate.parse("2024-02-01"))
                .fechaFinal(LocalDate.parse("2024-02-07"))
                .ciudad("Santa Marta")
                .marca("BMW")
                .modelo("3 Series")
                .url("https://images.pexels.com/photos/1008659/pexels-photo-1008659.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();
        // Similar para los otros coches...

        rentRepository.saveAll(List.of(rent1, rent2, rent3, rent4, rent5, rent6, rent7, rent8, rent9, rent10, rent11, rent12, rent13, rent14, rent15));
    }
    @Override
    public RentDto guardarCarro(RentToSaveDto rentDto) {
        Rent rent = RentMapper.INSTANCE.rentToSaveDtoToRent(rentDto);
        Rent rentSave = rentRepository.save(rent);
        return RentMapper.INSTANCE.rentToRentDto(rentSave);
    }

    @Override
    public RentDto actualizarCarro(Long id, RentToSaveDto rentDto) {
        return rentRepository.findById(id).map(rentInBd -> {
            rentInBd.setCiudad(rentDto.ciudad());
            rentInBd.setFechaInicio(rentDto.fechaInicio());
            rentInBd.setFechaFinal(rentDto.fechaFinal());
            rentInBd.setModelo(rentDto.modelo());
            rentInBd.setMarca(rentDto.marca());
            rentInBd.setPrecio(rentDto.precio());

            Rent rentSave = rentRepository.save(rentInBd);

            return RentMapper.INSTANCE.rentToRentDto(rentSave);
        }).orElseThrow(() -> new RentNotFoundException("Carro no encontrado"));
    }

    @Override
    public RentDto buscarCarroPorId(Long id) throws RentNotFoundException {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new RentNotFoundException("Carro No Encontrado"));
        return RentMapper.INSTANCE.rentToRentDto(rent);
    }

    @Override
    public void removerCarro(Long id) {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new RentNotFoundException("No se encontró el coche a eliminar"));
        rentRepository.delete(rent);
    }

    @Override
    public List<RentDto> gerAllCarros() {
        List<Rent> rents = rentRepository.findAll();
        return RentMapper.INSTANCE.rentsToRentsDto(rents);
    }

    @Override
    public List<RentDto> filtrarPorCiudadYFechas(String ciudad, LocalDate fechaInicio, LocalDate fechaFinal) throws RentNotFoundException {
        List<Rent> rents = rentRepository.findCarsFilters(ciudad,fechaInicio,fechaFinal);
        if(rents.isEmpty()) {
            throw new RentNotFoundException("No se encontró coches En renta con esas condiciones");
        }
        return RentMapper.INSTANCE.rentsToRentsDto(rents);
    }


}
