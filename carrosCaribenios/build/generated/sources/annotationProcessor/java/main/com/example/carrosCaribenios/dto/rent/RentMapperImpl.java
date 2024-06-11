package com.example.carrosCaribenios.dto.rent;

import com.example.carrosCaribenios.dto.client.ClientToSaveDto;
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
public class RentMapperImpl implements RentMapper {

    @Override
    public Rent rentDtoToRent(RentDto rentDto) {
        if ( rentDto == null ) {
            return null;
        }

        Rent.RentBuilder rent = Rent.builder();

        rent.id( rentDto.id() );
        rent.modelo( rentDto.modelo() );
        rent.marca( rentDto.marca() );
        rent.ciudad( rentDto.ciudad() );
        rent.fechaInicio( rentDto.fechaInicio() );
        rent.fechaFinal( rentDto.fechaFinal() );
        rent.precio( rentDto.precio() );
        rent.url( rentDto.url() );
        rent.rentadoCliente( clientToSaveDtoToClient( rentDto.rentadoCliente() ) );

        return rent.build();
    }

    @Override
    public Rent rentToSaveDtoToRent(RentToSaveDto rentToSaveDto) {
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

    @Override
    public RentDto rentToRentDto(Rent rent) {
        if ( rent == null ) {
            return null;
        }

        RentDto.RentDtoBuilder rentDto = RentDto.builder();

        rentDto.id( rent.getId() );
        rentDto.ciudad( rent.getCiudad() );
        rentDto.modelo( rent.getModelo() );
        rentDto.marca( rent.getMarca() );
        rentDto.fechaInicio( rent.getFechaInicio() );
        rentDto.fechaFinal( rent.getFechaFinal() );
        rentDto.precio( rent.getPrecio() );
        rentDto.url( rent.getUrl() );
        rentDto.rentadoCliente( clientToClientToSaveDto( rent.getRentadoCliente() ) );

        return rentDto.build();
    }

    @Override
    public RentDto rentToSaveDtoToRentDto(RentToSaveDto rentToSaveDto) {
        if ( rentToSaveDto == null ) {
            return null;
        }

        RentDto.RentDtoBuilder rentDto = RentDto.builder();

        rentDto.id( rentToSaveDto.id() );
        rentDto.ciudad( rentToSaveDto.ciudad() );
        rentDto.modelo( rentToSaveDto.modelo() );
        rentDto.marca( rentToSaveDto.marca() );
        rentDto.fechaInicio( rentToSaveDto.fechaInicio() );
        rentDto.fechaFinal( rentToSaveDto.fechaFinal() );
        rentDto.precio( rentToSaveDto.precio() );
        rentDto.url( rentToSaveDto.url() );

        return rentDto.build();
    }

    @Override
    public RentToSaveDto rentToRentToSaveDto(Rent rent) {
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

    @Override
    public List<Rent> rentsDtoToRents(List<RentDto> rentDtoList) {
        if ( rentDtoList == null ) {
            return null;
        }

        List<Rent> list = new ArrayList<Rent>( rentDtoList.size() );
        for ( RentDto rentDto : rentDtoList ) {
            list.add( rentDtoToRent( rentDto ) );
        }

        return list;
    }

    @Override
    public List<Rent> rentToSaveDtoToRents(List<RentToSaveDto> rentToSaveDtoList) {
        if ( rentToSaveDtoList == null ) {
            return null;
        }

        List<Rent> list = new ArrayList<Rent>( rentToSaveDtoList.size() );
        for ( RentToSaveDto rentToSaveDto : rentToSaveDtoList ) {
            list.add( rentToSaveDtoToRent( rentToSaveDto ) );
        }

        return list;
    }

    @Override
    public List<RentDto> rentsToRentsDto(List<Rent> rentList) {
        if ( rentList == null ) {
            return null;
        }

        List<RentDto> list = new ArrayList<RentDto>( rentList.size() );
        for ( Rent rent : rentList ) {
            list.add( rentToRentDto( rent ) );
        }

        return list;
    }

    protected Client clientToSaveDtoToClient(ClientToSaveDto clientToSaveDto) {
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

    protected ClientToSaveDto clientToClientToSaveDto(Client client) {
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
}
