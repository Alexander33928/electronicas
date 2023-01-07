package com.urna.electronica.ServicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urna.electronica.Model.Votos;
import com.urna.electronica.Repository.VotosRepository;
import com.urna.electronica.Services.VotosServices;

@Service
public class VotosServicesImpl implements VotosServices {
    @Autowired
    private VotosRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Votos> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Votos> findById(Integer id) {
        // TODO Auto-generated method stub
        return repository.findById(id); 
    }

    @Override
    @Transactional
    public Votos save(Votos votos) {
        // TODO Auto-generated method stub
        return repository.save(votos);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }
    
}
