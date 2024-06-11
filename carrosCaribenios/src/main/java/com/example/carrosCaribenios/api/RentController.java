package com.example.carrosCaribenios.api;

import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.exception.RentNotFoundException;
import com.example.carrosCaribenios.service.rent.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
//http://localhost:8080/api/v1/rents
@RequestMapping("api/v1/rents")
@CrossOrigin(value = "http://localhost:5173")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping
    public ResponseEntity<RentDto> guardarCarro(@RequestBody RentToSaveDto rentDto) {
        try {
            RentDto savedRent = rentService.guardarCarro(rentDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedRent.id())
                    .toUri();
            return ResponseEntity.created(location).body(savedRent);
        } catch (RentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentDto> actualizarCarro(@PathVariable Long id, @RequestBody RentToSaveDto rentDto) {
        try {
            RentDto updatedRent = rentService.actualizarCarro(id, rentDto);
            return new ResponseEntity<>(updatedRent, HttpStatus.OK);
        } catch (RentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentDto> buscarCarroPorId(@PathVariable Long id) {
        try {
            RentDto rent = rentService.buscarCarroPorId(id);
            return new ResponseEntity<>(rent, HttpStatus.OK);
        } catch (RentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCarro(@PathVariable Long id) {
        try {
            rentService.removerCarro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<RentDto>> getAllCarros() {
        List<RentDto> rents = rentService.gerAllCarros();
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<RentDto>> filtrarPorCiudadYFechas(@RequestParam String ciudad, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFinal) {
        try {
            List<RentDto> filteredRents = rentService.filtrarPorCiudadYFechas(ciudad, fechaInicio, fechaFinal);
            return new ResponseEntity<>(filteredRents, HttpStatus.OK);
        } catch (RentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
