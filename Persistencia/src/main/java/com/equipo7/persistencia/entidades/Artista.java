/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

/**
 * Representa la informacion de un artista en el sistema
 * @author Saul Neri
 */
public class Artista implements IDocumentable {

    public static final String NOMBRE_COLLECTION = "artistas";

    private ObjectId _id;
    private String nombreArtista;
    private String descripcion;
    private String generoMusical;
    private List<Album> albumes;

    /**
     * Constructor vacio por defecto.
     */
    public Artista() {
        this.albumes = Arrays.asList();
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
    public Artista(String nombreArtista, String descripcion, String generoMusical, List<Album> albumes) {
        this.nombreArtista = nombreArtista;
        this.descripcion = descripcion;
        this.generoMusical = generoMusical;
        this.albumes = albumes;
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
    public List<Album> getAlbumes() {
        return albumes;
    }

    /**
     * Establece la lista de álbumes del artista.
     *
     * @param albumes La nueva lista de álbumes asociados al artista.
     */
    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }

    @Override
    public Document toDocument() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artista { ");

        sb.append("_id=").append(_id != null ? _id.toHexString() : "No especificado").append(", ");
        sb.append("nombreArtista='").append(nombreArtista != null ? nombreArtista : "No especificado").append("', ");
        sb.append("descripcion='").append(descripcion != null ? descripcion : "No especificada").append("', ");
        sb.append("generoMusical='").append(generoMusical != null ? generoMusical : "No especificado").append("', ");
        sb.append("albumes=").append(albumes != null && !albumes.isEmpty() ? albumes : "No especificados");

        sb.append(" }");
        return sb.toString();
    }

}