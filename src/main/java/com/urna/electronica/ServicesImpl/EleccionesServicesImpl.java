package com.urna.electronica.ServicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urna.electronica.Model.Elecciones;
import com.urna.electronica.Repository.EleccionesRepository;
import com.urna.electronica.Services.EleccionesServices;

@Service
public class EleccionesServicesImpl implements EleccionesServices {

    @Autowired
    private EleccionesRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Elecciones> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Elecciones> findById(Integer id_eleccion) {
        // TODO Auto-generated method stub
        return repository.findById(id_eleccion);
    }

    @Override
    @Transactional
    public Elecciones save(Elecciones elecciones) {
        // TODO Auto-generated method stub
        return repository.save(elecciones);
    }

    @Override
    @Transactional
    public void deleteById(Integer id_eleccion) {
        repository.deleteById(id_eleccion);
        
    }
    
}
