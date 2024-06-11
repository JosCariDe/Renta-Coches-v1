package com.example.carrosCaribenios.api;

import com.example.carrosCaribenios.dto.client.ClientDto;
import com.example.carrosCaribenios.dto.client.ClientToSaveDto;
import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.exception.ClientNotFoundException;
import com.example.carrosCaribenios.exception.RentNotFoundException;
import com.example.carrosCaribenios.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//http://localhost:8080/api/v1/clients
@RequestMapping("api/v1/clients")
@CrossOrigin(value = "http://localhost:5173")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> guardarCliente(@RequestBody ClientToSaveDto clientDto) {
        try {
            ClientDto savedClient = clientService.guardarCliente(clientDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedClient.id())
                    .toUri();
            return ResponseEntity.created(location).body(savedClient);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> actualizarCliente(@PathVariable Long id, @RequestBody ClientToSaveDto clientDto) {
        try {
            ClientDto updatedClient = clientService.actualizarCliente(id, clientDto);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> buscarClientePorId(@PathVariable Long id) {
        try {
            ClientDto client = clientService.buscarClientePorId(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        try {
            clientService.removerCliente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ClientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClientes() {
        List<ClientDto> clients = clientService.getAllClientes();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}/rented-cars")
    public ResponseEntity<List<RentDto>> findCarrosRentadosById(@PathVariable Long id) {
        List<RentDto> rentedCars = clientService.findCarrosRentadosById(id);
        return ResponseEntity.ok(rentedCars);
    }

    @PostMapping("/{clientId}/rent/{rentId}")
    public ResponseEntity<ClientDto> asociarCarroARentado(@PathVariable Long clientId, @PathVariable Long rentId) {
        try {
            ClientDto updatedClient = clientService.asociarCarroARentado(clientId, rentId);
            return ResponseEntity.ok(updatedClient);
        } catch (ClientNotFoundException | RentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
