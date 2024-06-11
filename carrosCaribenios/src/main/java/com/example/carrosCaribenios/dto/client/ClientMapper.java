package com.example.carrosCaribenios.dto.client;

import com.example.carrosCaribenios.entitys.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client clientDtoToClient(ClientDto clientDto);

    @Mapping(target = "carrosRentados", ignore = true)
    Client clientToSaveDtoToClient(ClientToSaveDto clientToSaveDto);

    ClientDto clientToClientDto(Client client);

    @Mapping(target = "carrosRentados", ignore = true)
    ClientDto clientToSaveDtoToClientDto(ClientToSaveDto clientToSaveDto);

    ClientToSaveDto clientToClienToSaveDto(Client client);

    List<Client> clientsDtoToClients(List<ClientDto> clientDtoList);

    List<ClientDto> clientsToClientsDto(List<Client> clientList);
}
