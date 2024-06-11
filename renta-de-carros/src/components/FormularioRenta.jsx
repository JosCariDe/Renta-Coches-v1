import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

export default function FormularioRenta() {
  const urlCoches = "http://localhost:8080/api/v1/rents";
  const urlClientes = "http://localhost:8080/api/v1/clients";
  const { id } = useParams();

  const [nombres, setNombres] = useState('');
  const [apellidos, setApellidos] = useState('');
  const [cedula, setCedula] = useState('');
  const [correo, setCorreo] = useState('');
  const [numeroCelular, setNumeroCelular] = useState('');
  const [coche, setCoche] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    cargarCoche();
  }, []);

  const cargarCoche = async () => {
    const resultado = await axios.get(`${urlCoches}/${id}`);
    setCoche(resultado.data);
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    const userData = { nombre: nombres, apellido: apellidos, cedula, correo, numeroCelular };

    try {
      // Guardar el cliente
      const clienteResponse = await axios.post(urlClientes, userData);
      const cliente = clienteResponse.data;


      // Asociar el coche con el cliente
      await axios.post(`${urlClientes}/${cliente.id}/rent/${id}`);

      // Navegar a la página de resumen
      navigate(`/resumen-renta/${id}/${cliente.id}`);
    } catch (error) {
      console.error("Error al procesar la renta:", error);
    }
  };

  

  return (
    <div className="container mt-4">
      <main>
        <section className="form-section">
          <h2>Completa Tu Renta</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="nombres">Nombres</label>
              <input
                type="text"
                className="form-control"
                id="nombres"
                value={nombres}
                onChange={(e) => setNombres(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="apellidos">Apellidos</label>
              <input
                type="text"
                className="form-control"
                id="apellidos"
                value={apellidos}
                onChange={(e) => setApellidos(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="cedula">Cedula</label>
              <input
                type="text"
                className="form-control"
                id="cedula"
                value={cedula}
                onChange={(e) => setCedula(e.target.value)}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="correo">Correo</label>
              <input
                type="email"
                className="form-control"
                id="correo"
                value={correo}
                onChange={(e) => setCorreo(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="telefono">Número de Telefono</label>
              <input
                type="text"
                className="form-control"
                id="telefono"
                value={numeroCelular}
                onChange={(e) => setNumeroCelular(e.target.value)}
                required
              />
            </div>
            <button type="submit" className="btn btn-success mr-2">
              Confirmar Renta
            </button>
            <button type="button" className="btn btn-danger" onClick={() => navigate(`/`)}>
              Cancelar Renta
            </button>
          </form>
        </section>
      </main>
    </div>
  );
}
