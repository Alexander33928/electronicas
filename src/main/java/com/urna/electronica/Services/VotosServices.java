package com.urna.electronica.Services;

import java.util.Optional;

import com.urna.electronica.Model.Votos;

public interface VotosServices {
    public Iterable<Votos> findAll();

    public Optional<Votos> findById(Integer id);

    public Votos save(Votos votos);

    public void deleteById(Integer id);
}
