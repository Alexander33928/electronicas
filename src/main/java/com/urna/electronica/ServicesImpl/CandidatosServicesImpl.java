package com.urna.electronica.ServicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urna.electronica.Model.Candidatos;
import com.urna.electronica.Repository.CandidatosRepository;
import com.urna.electronica.Services.CandidatosServices;

@Service
public class CandidatosServicesImpl implements CandidatosServices{
    @Autowired
    private CandidatosRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Candidatos> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Candidatos> findById(Integer id) {
        // TODO Auto-generated method stub
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Candidatos save(Candidatos candidatos) {
        // TODO Auto-generated method stub
        return repository.save(candidatos);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
        
    }
    
}
