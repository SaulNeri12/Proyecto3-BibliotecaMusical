/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * Representa la informacion de un artista en el sistema
 * @author Saul Neri
 */
public class Artista {

    public static final String NOMBRE_COLLECTION = "artistas";

    private ObjectId _id;
    @BsonProperty(value="nombre")
    private String nombreArtista;
    @BsonProperty(value="tipo")
    private String tipo;
    @BsonProperty(value="descripcion")
    private String descripcion;
    @BsonProperty(value="generoMusical")
    private String generoMusical;
    @BsonProperty(value="albumes")
    private List<ObjectId> referenciasAlbumes;
    
    /**
     * Constructor vacio por defecto.
     */
    public Artista() {
        this.referenciasAlbumes = new ArrayList<>();
    }

    /**
     * Se crea un nuevo artista y se le asigna un ID de MongoBD
     * @param _id ID de MongoDB
     */
    public Artista(ObjectId _id) {
        super();
        this._id = _id;
    }

    /**
     * Constructor de la clase Artista.
     * Inicializa los atributos de la clase con los valores proporcionados.
     *
     * @param nombreArtista El nombre del artista.
     * @param descripcion Descripción del artista.
     * @param generoMusical Género musical del artista.
     * @param albumes Lista de álbumes asociados al artista.
     */
    public Artista(String nombreArtista, String descripcion, String generoMusical, List<ObjectId> albumes) {
        this.nombreArtista = nombreArtista;
        this.descripcion = descripcion;
        this.generoMusical = generoMusical;
        this.referenciasAlbumes = albumes;
    }

    /**
     * Obtiene el nombre del artista.
     *
     * @return El nombre del artista.
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Establece el nombre del artista.
     *
     * @param nombreArtista El nuevo nombre del artista.
     */
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    /**
     * Obtiene la descripción del artista.
     *
     * @return La descripción del artista.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del artista.
     *
     * @param descripcion La nueva descripción del artista.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el género musical del artista.
     *
     * @return El género musical del artista.
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Establece el género musical del artista.
     *
     * @param generoMusical El nuevo género musical del artista.
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    /**
     * Obtiene la lista de álbumes del artista.
     *
     * @return La lista de álbumes del artista.
     */
    public List<ObjectId> getAlbumes() {
        return this.referenciasAlbumes;
    }

    /**
     * Establece la lista de álbumes del artista.
     *
     * @param albumes La nueva lista de álbumes asociados al artista.
     */
    public void setAlbumes(List<ObjectId> albumes) {
        this.referenciasAlbumes = albumes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artista { ");

        sb.append("_id=").append(getId() != null ? getId().toHexString() : "No especificado").append(", ");
        sb.append("nombreArtista='").append(nombreArtista != null ? nombreArtista : "No especificado").append("', ");
        sb.append("descripcion='").append(descripcion != null ? descripcion : "No especificada").append("', ");
        sb.append("generoMusical='").append(generoMusical != null ? generoMusical : "No especificado").append("', ");
        sb.append("albumes=").append(this.referenciasAlbumes != null && !this.referenciasAlbumes.isEmpty() ? this.referenciasAlbumes.toString() : "No especificados");

        sb.append(" }");
        return sb.toString();
    }

    /**
     * @return the _id
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * @return the referenciasAlbumes
     */
    public List<ObjectId> getReferenciasAlbumes() {
        return referenciasAlbumes;
    }

    /**
     * @param referenciasAlbumes the referenciasAlbumes to set
     */
    public void setReferenciasAlbumes(List<ObjectId> referenciasAlbumes) {
        this.referenciasAlbumes = referenciasAlbumes;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}