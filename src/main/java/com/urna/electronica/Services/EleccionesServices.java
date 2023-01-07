package com.urna.electronica.Services;

import java.util.Optional;


import com.urna.electronica.Model.Elecciones;

public interface EleccionesServices {
    public Iterable<Elecciones> findAll();

    public Optional<Elecciones> findById(Integer id_eleccion);

    public Elecciones save(Elecciones elecciones);

    public void deleteById(Integer id_eleccion);
}
