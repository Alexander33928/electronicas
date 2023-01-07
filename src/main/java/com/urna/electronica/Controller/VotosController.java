package com.urna.electronica.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urna.electronica.Model.Votos;
import com.urna.electronica.Repository.VotosRepository;

@RestController
@RequestMapping("/api/Votos")
public class VotosController {
    @Autowired
	private VotosRepository repository;
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Votos votos){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(votos));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable Integer id){
        Optional<Votos> votos = repository.findById(id);
        if(votos.isPresent()){
            return ResponseEntity.ok(votos);     
        }
       
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="/{id}")
    public ResponseEntity <?> update (@RequestBody Votos votos,@PathVariable(value = "id") Integer id){
        Optional<Votos> voto = repository.findById(id);
        if(voto.isPresent()){
            BeanUtils.copyProperties(votos, voto.get());
            voto.get().setNombre_votador(votos.getNombre_votador());
            voto.get().setCredencial(votos.getCredencial());
            voto.get().setCantidad_votado(votos.getCantidad_votado());
            voto.get().setCandidatos_id(votos.getCandidatos_id());
            voto.get().setEleccion_id(votos.getEleccion_id());
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(voto.get()));
        }
        return ResponseEntity.notFound().build();
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete (@PathVariable(value = "id")Integer id){
        if(!repository.findById(id).isPresent()){
        return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Votos> readAll(){
        List<Votos> votos = StreamSupport
        .stream(repository.findAll().spliterator(), false)
        .collect(Collectors.toList());
        return votos;
    }
}

