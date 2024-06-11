package com.example.carrosCaribenios.dto.client;

import com.example.carrosCaribenios.dto.rent.RentToSaveDto;
import com.example.carrosCaribenios.entitys.Client;
import com.example.carrosCaribenios.entitys.Rent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T13:38:44-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( clientDto.id() );
        client.carrosRentados( rentToSaveDtoListToRentList( clientDto.carrosRentados() ) );
        client.nombre( clientDto.nombre() );
        client.apellido( clientDto.apellido() );
        client.cedula( clientDto.cedula() );
        client.correo( clientDto.correo() );
        client.numeroCelular( clientDto.numeroCelular() );

        return client.build();
    }

    @Override
    public Client clientToSaveDtoToClient(ClientToSaveDto clientToSaveDto) {
        if ( clientToSaveDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( clientToSaveDto.id() );
        client.nombre( clientToSaveDto.nombre() );
        client.apellido( clientToSaveDto.apellido() );
        client.cedula( clientToSaveDto.cedula() );
        client.correo( clientToSaveDto.correo() );
        client.numeroCelular( clientToSaveDto.numeroCelular() );

        return client.build();
    }

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.id( client.getId() );
        clientDto.nombre( client.getNombre() );
        clientDto.carrosRentados( rentListToRentToSaveDtoList( client.getCarrosRentados() ) );
        clientDto.apellido( client.getApellido() );
        clientDto.cedula( client.getCedula() );
        clientDto.correo( client.getCorreo() );
        clientDto.numeroCelular( client.getNumeroCelular() );

        return clientDto.build();
    }

    @Override
    public ClientDto clientToSaveDtoToClientDto(ClientToSaveDto clientToSaveDto) {
        if ( clientToSaveDto == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.id( clientToSaveDto.id() );
        clientDto.nombre( clientToSaveDto.nombre() );
        clientDto.apellido( clientToSaveDto.apellido() );
        clientDto.cedula( clientToSaveDto.cedula() );
        clientDto.correo( clientToSaveDto.correo() );
        clientDto.numeroCelular( clientToSaveDto.numeroCelular() );

        return clientDto.build();
    }

    @Override
    public ClientToSaveDto clientToClienToSaveDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientToSaveDto.ClientToSaveDtoBuilder clientToSaveDto = ClientToSaveDto.builder();

        clientToSaveDto.id( client.getId() );
        clientToSaveDto.nombre( client.getNombre() );
        clientToSaveDto.apellido( client.getApellido() );
        clientToSaveDto.cedula( client.getCedula() );
        clientToSaveDto.correo( client.getCorreo() );
        clientToSaveDto.numeroCelular( client.getNumeroCelular() );

        return clientToSaveDto.build();
    }

    @Override
    public List<Client> clientsDtoToClients(List<ClientDto> clientDtoList) {
        if ( clientDtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDtoList.size() );
        for ( ClientDto clientDto : clientDtoList ) {
            list.add( clientDtoToClient( clientDto ) );
        }

        return list;
    }

    @Override
    public List<ClientDto> clientsToClientsDto(List<Client> clientList) {
        if ( clientList == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clientList.size() );
        for ( Client client : clientList ) {
            list.add( clientToClientDto( client ) );
        }

        return list;
    }

    protected Rent rentToSaveDtoToRent(RentToSaveDto rentToSaveDto) {
        if ( rentToSaveDto == null ) {
            return null;
        }

        Rent.RentBuilder rent = Rent.builder();

        rent.id( rentToSaveDto.id() );
        rent.modelo( rentToSaveDto.modelo() );
        rent.marca( rentToSaveDto.marca() );
        rent.ciudad( rentToSaveDto.ciudad() );
        rent.fechaInicio( rentToSaveDto.fechaInicio() );
        rent.fechaFinal( rentToSaveDto.fechaFinal() );
        rent.precio( rentToSaveDto.precio() );
        rent.url( rentToSaveDto.url() );

        return rent.build();
    }

    protected List<Rent> rentToSaveDtoListToRentList(List<RentToSaveDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Rent> list1 = new ArrayList<Rent>( list.size() );
        for ( RentToSaveDto rentToSaveDto : list ) {
            list1.add( rentToSaveDtoToRent( rentToSaveDto ) );
        }

        return list1;
    }

    protected RentToSaveDto rentToRentToSaveDto(Rent rent) {
        if ( rent == null ) {
            return null;
        }

        RentToSaveDto.RentToSaveDtoBuilder rentToSaveDto = RentToSaveDto.builder();

        rentToSaveDto.id( rent.getId() );
        rentToSaveDto.ciudad( rent.getCiudad() );
        rentToSaveDto.modelo( rent.getModelo() );
        rentToSaveDto.marca( rent.getMarca() );
        rentToSaveDto.fechaInicio( rent.getFechaInicio() );
        rentToSaveDto.fechaFinal( rent.getFechaFinal() );
        rentToSaveDto.precio( rent.getPrecio() );
        rentToSaveDto.url( rent.getUrl() );

        return rentToSaveDto.build();
    }

    protected List<RentToSaveDto> rentListToRentToSaveDtoList(List<Rent> list) {
        if ( list == null ) {
            return null;
        }

        List<RentToSaveDto> list1 = new ArrayList<RentToSaveDto>( list.size() );
        for ( Rent rent : list ) {
            list1.add( rentToRentToSaveDto( rent ) );
        }

        return list1;
    }
}
