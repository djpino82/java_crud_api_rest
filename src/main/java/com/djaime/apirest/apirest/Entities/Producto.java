package com.djaime.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // un decorador propio de spring llamado Entity. Java ya sabe quye va a ser de tipo Entidad

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de creación
    // Creamos atributos
    private Long id;
    private String nombre;
    private double precio;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    





}
