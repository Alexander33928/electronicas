package com.urna.electronica.Model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "elecciones")
public class Elecciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_eleccion;

    @NotBlank
    private String nombre_eleccion;

    public int getId_eleccion() {
        return id_eleccion;
    }

    public void setId_eleccion(int id_eleccion) {
        this.id_eleccion = id_eleccion;
    }

    public String getNombre_eleccion() {
        return nombre_eleccion;
    }

    public void setNombre_eleccion(String nombre_eleccion) {
        this.nombre_eleccion = nombre_eleccion;
    }

}
