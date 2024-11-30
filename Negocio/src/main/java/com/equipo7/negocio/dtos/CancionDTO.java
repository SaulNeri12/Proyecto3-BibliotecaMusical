/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

/**
 *
 * @author caarl
 */
public class CancionDTO {
    private String id;
    private String nombre;
    private String idAlbum;

    // Constructor vacío
    public CancionDTO() {}

    // Constructor completo
    public CancionDTO(String id, String nombre, String idAlbum) {
        this.id = id;
        this.nombre = nombre;
        this.idAlbum = idAlbum;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }
}