package com.urna.electronica.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "candidatos")
public class Candidatos {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_candidato;

    @NotBlank
	private String nombre_candidato;

    @NotBlank
	private String cargo;

    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}
