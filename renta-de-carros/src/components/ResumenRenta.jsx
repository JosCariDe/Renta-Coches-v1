import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

export default function ResumenRenta() {

  const { idRenta, idCliente } = useParams();

  const [car, setCar] = useState(null);
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    cargarDatos();
  }, []);

  const cargarDatos = async () => {
    const carResponse = await axios.get(`http://localhost:8080/api/v1/rents/${idRenta}`);
    setCar(carResponse.data);
    const userResponse = await axios.get(`http://localhost:8080/api/v1/clients/${idCliente}`);
    setUser(userResponse.data);
  };

  if (!car || !user) return <div>Cargando...</div>;

  return (
    <div className="container mt-4">
      <main>
        <section className="summary-section">
          <h2>Resumen de Renta</h2>
          <div className="card">
            <img src={car.url} alt={car.modelo} className="card-img-top" />
            <div className="card-body">
              <h5 className="card-title">{car.modelo}</h5>
              <p className="card-text">Marca: {car.marca}</p>
              <p className="card-text">Ciudad: {car.ciudad}</p>
              <p className="card-text">Precio: {car.precio}</p>
            </div>
          </div>
          <div className="user-info mt-4">
            <h3>Datos del Usuario</h3>
            <p>Nombres: {user.nombre}</p>
            <p>Apellidos: {user.apellido}</p>
            <p>Cedula: {user.cedula}</p>
            <p>Correo: {user.correo}</p>
            <p>Teléfono: {user.numeroCelular}</p>
          </div>
          <button className="btn btn-primary mt-4" onClick={() => navigate('/')}>
            Volver al Inicio
          </button>
        </section>
      </main>
    </div>
  );
}
