import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './FormularioRenta.css';
export default function AgregarCarro() {
  const [coche, setCoche] = useState({
    ciudad: '',
    modelo: '',
    marca: '',
    fechaInicio: '',
    fechaFinal: '',
    precio: '',
    url: '',
  });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCoche((prevCoche) => ({
      ...prevCoche,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (new Date(coche.fechaInicio) >= new Date(coche.fechaFinal)) {
      setError('La fecha de inicio debe ser anterior a la fecha final');
      return;
    }

    onSubmit();

    navigate('/');
  };

  const onSubmit = async () => {
    const urlBase = "http://localhost:8080/api/v1/rents";
    await axios.post(urlBase, coche);
  };

  return (
    <div className="container mt-4">
      <main>
        <section className="form-section">
          <h2>Agregar Nuevo Carro</h2>
          {error && <div className="alert alert-danger">{error}</div>}
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="marca">Marca</label>
              <input
                type="text"
                className="form-control"
                id="marca"
                name="marca"
                value={coche.marca}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="modelo">Modelo</label>
              <input
                type="text"
                className="form-control"
                id="modelo"
                name="modelo"
                value={coche.modelo}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="ciudad">Ciudad</label>
              <input
                type="text"
                className="form-control"
                id="ciudad"
                name="ciudad"
                value={coche.ciudad}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="precio">Precio</label>
              <input
                type="number"
                step="any"
                className="form-control"
                id="precio"
                name="precio"
                value={coche.precio}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="fechaInicio">Fecha Inicio</label>
              <input
                type="date"
                className="form-control"
                id="fechaInicio"
                name="fechaInicio"
                value={coche.fechaInicio}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="fechaFinal">Fecha Final</label>
              <input
                type="date"
                className="form-control"
                id="fechaFinal"
                name="fechaFinal"
                value={coche.fechaFinal}
                onChange={handleChange}
                required={true}
              />
            </div>
            <div className="form-group">
              <label htmlFor="url">URL de la Imagen</label>
              <input
                type="text"
                className="form-control"
                id="url"
                name="url"
                value={coche.url}
                onChange={handleChange}
              />
            </div>
            <button type="submit" className="btn btn-success mr-2 margin" >
              Agregar Carro
            </button>
            <button type="button" className="btn btn-danger" onClick={() => navigate('/')}>
              Cancelar
            </button>
          </form>
        </section>
      </main>
    </div>
  );
}
