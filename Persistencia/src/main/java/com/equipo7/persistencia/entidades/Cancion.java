/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * Representa la informacion de una cancion de un Album en el sistema
 * @author Saul Neri
 */
public class Cancion {

    @BsonProperty(value="refAlbum")
    private ObjectId referenciaAlbum;
    @BsonProperty(value="nombreCancion")
    private String nombreCancion;
    @BsonProperty(value="nombreArtista")
    private String nombreArtista;
    @BsonProperty(value="nombreAlbum")
    private String nombreAlbum;
    
    
    /**
     * Constructor vacio por defecto.
     */
    public Cancion() {
        this.nombreCancion = "";
    }

    /**
     * Constructor con parámetros para crear una canción con los valores proporcionados.
     *
     * @param referenciaAlbum Referencia al album que pertenece la cancion
     * @param nombreCancion Nombre de la cancion
     * @param nombreArtista Nombre del artista
     * @param nombreAlbum Nombre del album
     */
    public Cancion(ObjectId referenciaAlbum, String nombreCancion, String nombreArtista, String nombreAlbum) {
        this.referenciaAlbum = referenciaAlbum;
        this.nombreCancion = nombreCancion;
        this.nombreArtista = nombreArtista;
        this.nombreAlbum = nombreAlbum;
    }

    /**
     * Obtiene el nombre de la canción.
     *
     * @return El nombre de la canción.
     */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /**
     * Establece el nombre de la canción.
     *
     * @param nombre El nuevo nombre de la canción.
     */
    public void setNombreCancion(String nombre) {
        this.nombreCancion = nombre;
    }

    /**
     * @return the referenciaAlbum
     */
    public ObjectId getReferenciaAlbum() {
        return referenciaAlbum;
    }

    /**
     * @param referenciaAlbum the referenciaAlbum to set
     */
    public void setReferenciaAlbum(ObjectId referenciaAlbum) {
        this.referenciaAlbum = referenciaAlbum;
    }

    /**
     * @return the nombreArtista
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * @param nombreArtista the nombreArtista to set
     */
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    /**
     * @return the nombreAlbum
     */
    public String getNombreAlbum() {
        return nombreAlbum;
    }

    /**
     * @param nombreAlbum the nombreAlbum to set
     */
    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }
}
