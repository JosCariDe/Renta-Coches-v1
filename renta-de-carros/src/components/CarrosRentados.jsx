import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { NumericFormat } from 'react-number-format';
import { useParams, useNavigate } from 'react-router-dom';
//import './CarrosRentados.css';

export default function CarrosRentados() {
  const { clientId } = useParams();
  const [carrosRentados, setCarrosRentados] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    cargarCarrosRentados();
  }, []);

  const cargarCarrosRentados = async () => {
    const urlBase = `http://localhost:8080/api/v1/clients/${clientId}`;
    const resultado = await axios.get(urlBase);
    console.log(resultado.data)
    console.log(resultado.data.CarrosRentados)
    setCarrosRentados(resultado.data.carrosRentados);
  };

  return (
    <div className="container mt-4">
      <h2>Carros Rentados</h2>
      <table className="table table-striped table-centered">
        <thead>
          <tr>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Fecha Inicio</th>
            <th>Fecha Final</th>
            <th>Ciudad</th>
            <th>Precio</th>
          </tr>
        </thead>
        <tbody>
          {carrosRentados.map((coche) => (
            <tr key={coche.id}>
              <td>{coche.modelo}</td>
              <td>{coche.marca}</td>
              <td>{coche.fechaInicio}</td>
              <td>{coche.fechaFinal}</td>
              <td>{coche.ciudad}</td>
              <td>
              <NumericFormat
                    value={coche.precio}
                    displayType={'text'}
                    thousandSeparator=','
                    prefix='$'
                    decimalScale={2}
                    fixedDecimalScale
                />   
                </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button
        onClick={() => navigate('/clientes')}
        className="btn btn-secondary mt-4"
      >
        Volver a Clientes
      </button>
    </div>
  );
}
