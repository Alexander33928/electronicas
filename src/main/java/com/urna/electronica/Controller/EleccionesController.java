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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urna.electronica.Model.Elecciones;
import com.urna.electronica.Repository.EleccionesRepository;



import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/Elecciones")
public class EleccionesController {
    @Autowired
	private EleccionesRepository repository;
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Elecciones elecciones){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(elecciones));
     
    }

    @GetMapping("/{id_eleccion}")
    public ResponseEntity<?> read (@PathVariable(value = "id_eleccion") Integer id_eleccion){
        Optional<Elecciones> elecciones = repository.findById(id_eleccion);
        if(elecciones.isPresent()){
            return ResponseEntity.ok(elecciones);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="/{id_eleccion}")
    public ResponseEntity <?> update (@RequestBody Elecciones elecciones,@PathVariable(value = "id_eleccion") Integer id_eleccion){
        Optional<Elecciones> eleccione = repository.findById(id_eleccion);
        if(eleccione.isPresent()){
            BeanUtils.copyProperties(elecciones, eleccione.get());
            eleccione.get().setNombre_eleccion(elecciones.getNombre_eleccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(eleccione.get()));
        }
        return ResponseEntity.notFound().build();
        
    }
    @DeleteMapping("/{id_eleccion}")
    public ResponseEntity <?> delete (@PathVariable(value = "id_eleccion")Integer id_eleccion){
        if(!repository.findById(id_eleccion).isPresent()){
        return ResponseEntity.notFound().build();
        }
        repository.deleteById(id_eleccion);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Elecciones> readAll(){
        List<Elecciones> elecciones = StreamSupport
        .stream(repository.findAll().spliterator(), false)
        .collect(Collectors.toList());
        return elecciones;
    }
    }
    
