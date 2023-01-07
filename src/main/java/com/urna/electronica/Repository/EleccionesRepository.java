package com.urna.electronica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urna.electronica.Model.Elecciones;

public interface EleccionesRepository extends JpaRepository<Elecciones, Integer> {
    
}

