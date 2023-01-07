package com.urna.electronica.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "votos")
public class Votos {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_votos;
    
    @NotBlank
    private String nombre_votador;
    
    @NotBlank
    private String credencial;

    @NotNull
	private int cantidad_votado;

    @NotNull
	private int candidatos_id;

    @NotNull
	private int eleccion_id ;

    public int getId_votos() {
        return id_votos;
    }

    public void setId_votos(int id_votos) {
        this.id_votos = id_votos;
    }

    public String getNombre_votador() {
        return nombre_votador;
    }

    public void setNombre_votador(String nombre_votador) {
        this.nombre_votador = nombre_votador;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public int getCantidad_votado() {
        return cantidad_votado;
    }

    public void setCantidad_votado(int cantidad_votado) {
        this.cantidad_votado = cantidad_votado;
    }

    public int getCandidatos_id() {
        return candidatos_id;
    }

    public void setCandidatos_id(int candidatos_id) {
        this.candidatos_id = candidatos_id;
    }

    public int getEleccion_id() {
        return eleccion_id;
    }

    public void setEleccion_id(int eleccion_id) {
        this.eleccion_id = eleccion_id;
    }
    

   
    }
    

