/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import java.time.Instant;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author Saul Neri
 */
public class Integrante {
    
    @BsonProperty(value="nombre")
    private String nombre;
    @BsonProperty(value="rol")
    private String rol;
    @BsonProperty(value="fechaIngreso")
    private Instant fechaIngreso;
    @BsonProperty(value="fechaSalida")
    private Instant fechaSalida;
    @BsonProperty(value="activo")
    private boolean activo;
    
    public Integrante(String nombre, String rol, Instant ingreso, Instant salida, boolean activo) {
        this.nombre = nombre;
        this.rol = rol;
        this.fechaIngreso = ingreso;
        this.fechaSalida = salida;
        this.activo = activo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the fechaIngreso
     */
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
