package com.example.carrosCaribenios.service.client;

import com.example.carrosCaribenios.dto.client.ClientDto;
import com.example.carrosCaribenios.dto.client.ClientMapper;
import com.example.carrosCaribenios.dto.client.ClientToSaveDto;
import com.example.carrosCaribenios.dto.rent.RentDto;
import com.example.carrosCaribenios.dto.rent.RentMapper;
import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.entitys.Client;
import com.example.carrosCaribenios.entitys.Rent;
import com.example.carrosCaribenios.exception.ClientNotFoundException;
import com.example.carrosCaribenios.exception.RentNotFoundException;
import com.example.carrosCaribenios.repository.ClientRepository;
import com.example.carrosCaribenios.repository.RentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;


    @PostConstruct
    public void init() {
        // Crear 3 clientes
        Client client1 = Client.builder()
                .id(1L)
                .cedula(12345678)
                .numeroCelular(987654321)
                .correo("juan.perez@example.com")
                .nombre("Juan")
                .apellido("Perez")
                .build();
        Client client2 = Client.builder()
                .id(2L)
                .cedula(87654321)
                .numeroCelular(123456789)
                .correo("maria.gomez@example.com")
                .nombre("Maria")
                .apellido("Gomez")
                .build();
        Client client3 = Client.builder()
                .id(3L)
                .cedula(11223344)
                .numeroCelular(998877665)
                .correo("luis.lopez@example.com")
                .nombre("Luis")
                .apellido("Lopez")
                .build();

        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
    }

    @Override
    public ClientDto guardarCliente(ClientToSaveDto clientDto) {
        Client client = ClientMapper.INSTANCE.clientToSaveDtoToClient(clientDto);
        Client clientSave = clientRepository.save(client);
        return ClientMapper.INSTANCE.clientToClientDto(clientSave);
    }

    @Override
    public ClientDto actualizarCliente(Long id, ClientToSaveDto clientDto) {
        return clientRepository.findById(id).map(clienteInDb -> {
            clienteInDb.setCedula(clientDto.cedula());
            clienteInDb.setNombre(clientDto.nombre());
            clienteInDb.setApellido(clientDto.apellido());
            clienteInDb.setCorreo(clientDto.correo());
            clienteInDb.setNumeroCelular(clientDto.numeroCelular());
            Client clientSave = clientRepository.save(clienteInDb);

            return ClientMapper.INSTANCE.clientToClientDto(clientSave);
        }).orElseThrow(() -> new ClientNotFoundException("Cliente No Encontrado"));
    }

    @Override
    public ClientDto buscarClientePorId(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Cliente No Encontrado"));
        return ClientMapper.INSTANCE.clientToClientDto(client);
    }

    @Override
    public void removerCliente(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Cliente No Encontrado"));
        clientRepository.delete(client);
    }

    @Override
    public List<ClientDto> getAllClientes() {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.INSTANCE.clientsToClientsDto(clients);
    }

    @Override
    public List<RentDto> findCarrosRentadosById(Long id) throws ClientNotFoundException {
        clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Cliente No Encontrado"));
        List<Rent> rents = clientRepository.findCarrosRentadosById(id);
        if (rents.isEmpty()) {
            throw new RentNotFoundException("No se encontraron Coches para este cliente");
        }
        return RentMapper.INSTANCE.rentsToRentsDto(rents);
    }

    @Override
    @Transactional
    public ClientDto asociarCarroARentado(Long clientId, Long rentId) throws ClientNotFoundException, RentNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("clientId"));
        Rent rent = rentRepository.findById(rentId).orElseThrow(() -> new RentNotFoundException("rentId"));

        rent.setRentadoCliente(client);
        client.getCarrosRentados().add(rent);

        rentRepository.save(rent);
        clientRepository.save(client);

        return ClientMapper.INSTANCE.clientToClientDto(client);
    }
}
