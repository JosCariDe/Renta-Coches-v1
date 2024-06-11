import React from 'react'
import { Link, Navigate, useNavigate } from 'react-router-dom';
import './Buscador.css';

export default function Nav() {

  const navigate = useNavigate();


  return (
    <div className='container'>
      <header className="d-flex justify-content-between align-items-center mb-4">
            <h1>Carros Caribeños</h1>
          <nav>
            <Link to="/" className="btn btn-secundary mr-2">Inicio</Link>
            <Link to="/clientes" className="btn btn-secundaryy mr-2">Clientes</Link>
            <button className="btn btn-secundary" onClick={() => navigate('/agregar-carro')}>
              Add Car
            </button>
          </nav>
      </header>
    </div>
  )
}
