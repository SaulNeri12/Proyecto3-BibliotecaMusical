/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

/**
 *
 * @author caarl
 */
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class AlbumDTO {

    private ObjectId id;
    private String nombre;
    private Instant fechaLanzamiento;
    private String generoMusical;
    private String imagenPortadaUrl;
    private List<String> canciones;
    private ObjectId referenciaArtista;
    private List<IntegranteDTO> integrantes;

    // Constructores
    public AlbumDTO() {
    }

    public AlbumDTO(ObjectId id, String nombre, Instant fechaLanzamiento, String generoMusical, String imagenPortadaUrl, List<String> canciones, ObjectId referenciaArtista) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortadaUrl = imagenPortadaUrl;
        this.canciones = canciones;
        this.referenciaArtista = referenciaArtista;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instant getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Instant fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getImagenPortadaUrl() {
        return imagenPortadaUrl;
    }

    public void setImagenPortadaUrl(String imagenPortadaUrl) {
        this.imagenPortadaUrl = imagenPortadaUrl;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }

    public ObjectId getReferenciaArtista() {
        return referenciaArtista;
    }

    public void setReferenciaArtista(ObjectId referenciaArtista) {
        this.referenciaArtista = referenciaArtista;
    }

    @Override
    public String toString() {
        return "AlbumDTO{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", fechaLanzamiento=" + fechaLanzamiento
                + ", generoMusical='" + generoMusical + '\''
                + ", imagenPortadaUrl='" + imagenPortadaUrl + '\''
                + ", canciones=" + canciones
                + ", referenciaArtista=" + referenciaArtista
                + '}';
    }

    /**
     * @return the integrantes
     */
    public List<IntegranteDTO> getIntegrantes() {
        return integrantes;
    }

    /**
     * @param integrantes the integrantes to set
     */
    public void setIntegrantes(List<IntegranteDTO> integrantes) {
        this.integrantes = integrantes;
    }

}
