/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * Representa la informacion de una cancion de un Album en el sistema
 * @author Saul Neri
 */
import org.bson.types.ObjectId;

public class Cancion {

    public static final String NOMBRE_COLLECTION = "canciones";

    private String nombre;
    private ObjectId idAlbum;
    private String imagenPortadaURL;
    private String generoMusical; // Nuevo atributo: Género Musical

    // Constructor vacío
    public Cancion() {
        this.nombre = "";
    }

    // Constructor con nombre
    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    // Constructor con nombre e ID del álbum
    public Cancion(String nombre, ObjectId idAlbum) {
        this.nombre = nombre;
        this.idAlbum = idAlbum;
    }

    // Constructor con todos los atributos
    public Cancion(String nombre, ObjectId idAlbum, String imagenPortadaURL, String generoMusical) {
        this.nombre = nombre;
        this.idAlbum = idAlbum;
        this.imagenPortadaURL = imagenPortadaURL;
        this.generoMusical = generoMusical;
    }

    // Getters y Setters
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

    public String getImagenPortadaURL() {
        return imagenPortadaURL;
    }

    public void setImagenPortadaURL(String imagenPortadaURL) {
        this.imagenPortadaURL = imagenPortadaURL;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cancion { ");
        sb.append("nombre='").append(nombre != null ? nombre : "No especificado").append("', ");
        sb.append("idAlbum='").append(idAlbum != null ? idAlbum : "No especificado").append("', ");
        sb.append("urlImage=").append(imagenPortadaURL != null ? imagenPortadaURL : "No especificada").append(", ");
        sb.append("generoMusical='").append(generoMusical != null ? generoMusical : "No especificado").append("'");
        sb.append(" }");
        return sb.toString();
    }
}
