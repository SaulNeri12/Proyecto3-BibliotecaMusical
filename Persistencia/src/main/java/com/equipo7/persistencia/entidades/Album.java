/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import java.time.Instant;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * Contiene la informacion de un album en el sistema
 * @author Saul Neri
 */
public class Album {

    public static final String NOMBRE_COLLECTION = "albumes";

    private ObjectId _id;
    @BsonProperty(value = "nombre")
    private String nombre;
    @BsonProperty(value = "fechaLanzamiento")
    private Instant fechaLanzamiento;
    @BsonProperty(value="referenciaArtista")
    private ObjectId referenciaArtista;
    @BsonProperty(value = "generoMusical")
    private String generoMusical;
    @BsonProperty(value = "imagenPortadaUrl")
    private String imagenPortadaUrl;
    @BsonProperty(value = "canciones")
    private List<String> canciones;

    /**
     * Constructor vacio por defecto.
     */
    public Album() {
        this.canciones = new ArrayList<>();
    }

    /**
     * Se crea un nuevo artista y se le asigna un ID de MongoBD
     * @param _id ID de MongoDB
     */
    public Album(ObjectId _id) {
        super();
        this._id = _id;
    }

    /**
     * Constructor de la clase Album.
     * Inicializa los atributos del álbum con los valores proporcionados.
     *
     * @param _id El ID de MongoDB del álbum.
     * @param nombre El nombre del álbum.
     * @param fechaLanzamiento La fecha de lanzamiento del álbum.
     * @param generoMusical El género musical del álbum.
     * @param imagenPortadaUrl La URL de la imagen de portada.
     * @param canciones La lista de canciones del álbum.
     */
    public Album(ObjectId _id, String nombre, Instant fechaLanzamiento, String generoMusical, String imagenPortadaUrl, List<String> canciones) {
        this._id = _id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortadaUrl = imagenPortadaUrl;
        this.canciones = canciones;
    }
    
    

    public Album(String nombre, Instant fechaLanzamiento, String generoMusical, List<String> canciones) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.canciones = canciones;
    }

    public Album(String nombre, Instant fechaLanzamiento, String generoMusical) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
    }

    public Album(String nombre, ObjectId referenciaArtista, String generoMusical, String imagenPortadaUrl, List<String> canciones) {
        this.nombre = nombre;
        this.referenciaArtista = referenciaArtista;
        this.generoMusical = generoMusical;
        this.imagenPortadaUrl = imagenPortadaUrl;
        this.canciones = canciones;
    }
    
    

    public Album(ObjectId _id, String nombre, Instant fechaLanzamiento, ObjectId referenciaArtista, String generoMusical, String imagenPortadaUrl, List<String> canciones) {
        this._id = _id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.referenciaArtista = referenciaArtista;
        this.generoMusical = generoMusical;
        this.imagenPortadaUrl = imagenPortadaUrl;
        this.canciones = canciones;
    }
    
    

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setReferenciaArtista(ObjectId referenciaArtista) {
        this.referenciaArtista = referenciaArtista;
    }

    public ObjectId getReferenciaArtista() {
        return referenciaArtista;
    }
    
    
    
    // Métodos getter y setter para los atributos de la clase

    /**
     * Obtiene el ID del álbum.
     *
     * @return El ID del álbum.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Obtiene el nombre del álbum.
     *
     * @return El nombre del álbum.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del álbum.
     *
     * @param nombre El nuevo nombre del álbum.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de lanzamiento del álbum.
     *
     * @return La fecha de lanzamiento del álbum.
     */
    public Instant getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento del álbum.
     *
     * @param fechaLanzamiento La nueva fecha de lanzamiento del álbum.
     */
    public void setFechaLanzamiento(Instant fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Obtiene el género musical del álbum.
     *
     * @return El género musical del álbum.
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Establece el género musical del álbum.
     *
     * @param generoMusical El nuevo género musical del álbum.
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    /**
     * Obtiene la URL de la imagen de portada del álbum.
     *
     * @return La URL de la imagen de portada.
     */
    public String getImagenPortadaUrl() {
        return imagenPortadaUrl;
    }

    /**
     * Establece la URL de la imagen de portada del álbum.
     *
     * @param imagenPortadaUrl La nueva URL de la imagen de portada.
     */
    public void setImagenPortadaUrl(String imagenPortadaUrl) {
        this.imagenPortadaUrl = imagenPortadaUrl;
    }

    /**
     * Obtiene la lista de canciones del álbum.
     *
     * @return La lista de canciones.
     */
    public List<String> getCanciones() {
        return canciones;
    }

    /**
     * Establece la lista de canciones del álbum.
     *
     * @param canciones La nueva lista de canciones.
     */
    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album { ");

        sb.append("_id=").append(_id != null ? _id.toHexString() : "No especificado").append(", ");
        sb.append("nombre='").append(nombre != null ? nombre : "No especificado").append("', ");
        sb.append("fechaLanzamiento=").append(fechaLanzamiento != null ? fechaLanzamiento.toString() : "No especificado").append(", ");
        sb.append("generoMusical='").append(generoMusical != null ? generoMusical : "No especificado").append("', ");
        sb.append("imagenPortadaUrl='").append(imagenPortadaUrl != null ? imagenPortadaUrl : "No especificado").append("', ");
        sb.append("canciones=").append(canciones != null && !canciones.isEmpty() ? canciones : "No especificadas");

        sb.append(" }");
        return sb.toString();
    }

}
