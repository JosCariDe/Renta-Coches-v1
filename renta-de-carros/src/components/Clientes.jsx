import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
//import './Clientes.css';

export default function Clientes() {
  const [clientes, setClientes] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    cargarClientes();
  }, []);

  const cargarClientes = async () => {
    const urlBase = "http://localhost:8080/api/v1/clients";
    const resultado = await axios.get(urlBase);
    setClientes(resultado.data);
  };

  const verCarrosRentados = (clientId) => {
    navigate(`/clientes/${clientId}/carros-rentados`);
  };

  return (
    <div className="container mt-4">
      <h2>Clientes</h2>
      <table className="table table-striped table-centered">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Cédula</th>
            <th>Correo</th>
            <th>Número Celular</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {clientes.map((cliente) => (
            <tr key={cliente.id}>
              <td>{cliente.nombre}</td>
              <td>{cliente.apellido}</td>
              <td>{cliente.cedula}</td>
              <td>{cliente.correo}</td>
              <td>{cliente.numeroCelular}</td>
              <td>
                <button
                  onClick={() => verCarrosRentados(cliente.id)}
                  className="btn btn-info"
                >
                  Ver Carros Rentados
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
