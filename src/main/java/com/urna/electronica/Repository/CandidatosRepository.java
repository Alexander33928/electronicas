package com.urna.electronica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urna.electronica.Model.Candidatos;


public interface CandidatosRepository extends JpaRepository<Candidatos, Integer> {
   
	
}
