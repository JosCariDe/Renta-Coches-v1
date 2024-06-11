// src/components/Buscador.jsx
import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Buscador.css';
import axios from 'axios';
import { NumericFormat } from 'react-number-format';

export default function Buscador() {
  const urlBase = "http://localhost:8080/api/v1/rents";

  const [cochesBd, setCochesBd] = useState([]);

  useEffect(() => {
    cargarCochesBd();
  }, []);

  const cargarCochesBd = async () => {
    const resultado = await axios.get(urlBase);
    const cochesFiltrados = resultado.data.filter(coche => coche.rentadoCliente === null);
    setCochesBd(cochesFiltrados);
  }

  const cochesTotales = cochesBd;
  const navigate = useNavigate();

  const [city, setCity] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [cochesFiltrados, setCochesFiltrados] = useState([]);

  const handleSearch = () => {
    const filteredCars = cochesTotales.filter((coche) => {
      const matchesCity = city ? coche.ciudad.toLowerCase().includes(city.toLowerCase()) : true;
      const matchesStartDate = startDate ? new Date(coche.fechaInicio) >= new Date(startDate) : true;
      const matchesEndDate = endDate ? new Date(coche.fechaFinal) <= new Date(endDate) : true;
      return matchesCity && matchesStartDate && matchesEndDate;
    });

    setCochesFiltrados(filteredCars);
  };

  return (
    <div className="buscador-container">
      <main className="container mt-4">
        <section className="search-section mb-4">
          <h2>¡Renta El Carro De Tus Sueños!</h2>
          <div className="search-fields">
            <div className="form-group">
              <label htmlFor="ciudad">Ciudad</label>
              <input
                type="text"
                className="form-control"
                placeholder="Santa Marta"
                id="ciudad"
                value={city}
                onChange={(e) => setCity(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="fecha-inicio">Fecha Inicio</label>
              <input
                type="date"
                className="form-control"
                id="fecha-inicio"
                value={startDate}
                onChange={(e) => setStartDate(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="fecha-fin">Fecha Fin</label>
              <input
                type="date"
                className="form-control"
                id="fecha-fin"
                value={endDate}
                onChange={(e) => setEndDate(e.target.value)}
              />
            </div>
          </div>
          <button className="btn btn-primary" onClick={handleSearch}>
            Buscar
          </button>
        </section>
        <section className="result-section">
          {
            cochesFiltrados.length > 0 && (
            <div className="table-responsive">
              <table className="table table-striped table-centered">
                <thead>
                  <tr>
                    <th>Imagen</th>
                    <th>Modelo</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Final</th>
                    <th>Ciudad</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  {cochesFiltrados.map((coche) => (
                    <tr key={coche.id}>
                      <td className="car-image">
                        <img src={coche.url} alt={coche.modelo} className="car-img" />
                      </td>
                      <td>{coche.modelo}</td>
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
                      <td>
                        <button
                          onClick={() => navigate(`/renta/${coche.id}`)}
                          className="btn btn-success"
                        >
                          Rent Car
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </section>
      </main>
    </div>
  );
}
