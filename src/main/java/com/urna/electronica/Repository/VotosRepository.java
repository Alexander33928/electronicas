package com.urna.electronica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urna.electronica.Model.Votos;

public interface VotosRepository extends JpaRepository<Votos, Integer> {
    
}
