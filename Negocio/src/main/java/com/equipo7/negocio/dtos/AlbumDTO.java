/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

/**
 *
 * @author caarl
 */
import java.util.Date;
import java.util.List;

public class AlbumDTO {
    private String id;
    private String nombre;
    private Date fechaLanzamiento;
    private String generoMusical;
    private String imagenPortadaUrl;
    private List<String> canciones;
    private String referenciaArtista;

    // Constructores
    public AlbumDTO() { }

    public AlbumDTO(String id, String nombre, Date fechaLanzamiento, String generoMusical, String imagenPortadaUrl, List<String> canciones, String referenciaArtista) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortadaUrl = imagenPortadaUrl;
        this.canciones = canciones;
        this.referenciaArtista = referenciaArtista;
    }

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

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
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

    public String getReferenciaArtista() {
        return referenciaArtista;
    }

    public void setReferenciaArtista(String referenciaArtista) {
        this.referenciaArtista = referenciaArtista;
    }

    
}