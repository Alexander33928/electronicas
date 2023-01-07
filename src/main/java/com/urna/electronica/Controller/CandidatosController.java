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

import com.urna.electronica.Model.Candidatos;
import com.urna.electronica.Repository.CandidatosRepository;

@RestController
@RequestMapping("/api/Candidatos")
public class CandidatosController {
    @Autowired
	private CandidatosRepository repository;
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Candidatos candidatos){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(candidatos));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable Integer id){
        Optional<Candidatos> candidatos = repository.findById(id);
        if(candidatos.isPresent()){
            return ResponseEntity.ok(candidatos);    
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="/{id}")
    public ResponseEntity <?> update (@RequestBody Candidatos candidatos,@PathVariable(value = "id") Integer id){
        Optional<Candidatos> candidato = repository.findById(id);
        if(candidato.isPresent()){
            BeanUtils.copyProperties(candidatos, candidato.get());
            candidato.get().setNombre_candidato(candidatos.getNombre_candidato());
            candidato.get().setCargo(candidatos.getCargo());
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(candidato.get()));
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
    public List<Candidatos> readAll(){
        List<Candidatos> candidatos = StreamSupport
        .stream(repository.findAll().spliterator(), false)
        .collect(Collectors.toList());
        return candidatos;
    }
}
