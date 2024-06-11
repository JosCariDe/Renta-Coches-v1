// src/App.jsx
import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Buscador from './components/Buscador';
import FormularioRenta from './components/FormularioRenta';
import AgregarCarro from './components/AgregarCarro';
import ResumenRenta from './components/ResumenRenta';
import Clientes from './components/Clientes';
import CarrosRentados from './components/CarrosRentados';

function App() {

  const [carList, setCarList] = useState([]);

  const addCar = (newCar) => {
    setCarList([...carList, newCar]);
  };

  return (
    <Routes>
        <Route path="/" element={<Buscador addCar={addCar} />} />
        <Route path="/renta/:id" element={<FormularioRenta />} />
        <Route path="/agregar-carro" element={<AgregarCarro addCar={addCar} />} />
        <Route path="/resumen-renta/:idRenta/:idCliente" element={<ResumenRenta />} />
        <Route path="/clientes" element={<Clientes />} />
        <Route path="/clientes/:clientId/carros-rentados" element={<CarrosRentados />} />
    </Routes>
  );
}

export default App;
