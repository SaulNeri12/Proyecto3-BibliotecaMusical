/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public class CancionDTO {

    private String imagenPortadaURL;
    private String nombre;
    private ObjectId idAlbum;
    private String generoMusical; // Nuevo atributo: Género Musical

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }



    
    
    // Constructor completo
    public CancionDTO() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObjectId getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(ObjectId idAlbum) {
        this.idAlbum = idAlbum;
    }

    /**
     * @return the imagenPortadaURL
     */
    public String getImagenPortadaURL() {
        return imagenPortadaURL;
    }

    /**
     * @param imagenPortadaURL the imagenPortadaURL to set
     */
    public void setImagenPortadaURL(String imagenPortadaURL) {
        this.imagenPortadaURL = imagenPortadaURL;
    }

    @Override
    public String toString() {
        return "CancionDTO {"
                + "nombre='" + nombre + '\''
                + ", idAlbum=" + (idAlbum != null ? idAlbum.toString() : "null")
                + ", imagenPortadaURL='" + imagenPortadaURL + '\''
                + '}';
    }
}
