package com.urna.electronica.Services;

import java.util.Optional;

import com.urna.electronica.Model.Candidatos;

public interface CandidatosServices {
    public Iterable<Candidatos> findAll();

    public Optional<Candidatos> findById(Integer id);

    public Candidatos save(Candidatos candidatos);

    public void deleteById(Integer id);
}
