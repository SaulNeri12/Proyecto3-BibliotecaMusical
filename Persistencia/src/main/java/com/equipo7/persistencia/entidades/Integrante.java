/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import java.time.Instant;
import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author Saul Neri
 */
public class Integrante {
    
    @BsonProperty("nombre")
    private String nombre;
    @BsonProperty("rol")
    private String rol;
    @BsonProperty("fecha_ingreso")
    private Date fechaIngreso;
    @BsonProperty("fecha_salida")
    private Date fechaSalida;
    @BsonProperty("activo")
    private Boolean activo;

    public Integrante() {
    }

    public Integrante(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Integrante(String nombre, String rol, Date fechaIngreso, Date fechaSalida, Boolean activo) {
        this.nombre = nombre;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
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
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
