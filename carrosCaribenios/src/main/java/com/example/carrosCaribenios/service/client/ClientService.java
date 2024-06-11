package com.example.carrosCaribenios.service.client;

import com.example.carrosCaribenios.dto.client.ClientDto;
import com.example.carrosCaribenios.dto.client.ClientToSaveDto;
import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.exception.ClientNotFoundException;
import com.example.carrosCaribenios.exception.RentNotFoundException;

import java.util.List;

public interface ClientService {
    ClientDto guardarCliente(ClientToSaveDto clientDto);
    ClientDto actualizarCliente(Long id, ClientToSaveDto clientDto);
    ClientDto buscarClientePorId(Long id) throws ClientNotFoundException;
    void removerCliente(Long id);
    List<ClientDto> getAllClientes();

    List<RentDto> findCarrosRentadosById(Long id) throws ClientNotFoundException;

    ClientDto asociarCarroARentado(Long clientId, Long rentId) throws ClientNotFoundException, RentNotFoundException;

}
