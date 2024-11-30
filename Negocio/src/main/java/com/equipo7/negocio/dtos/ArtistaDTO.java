/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

/**
 *
 * @author caarl
 */
import org.bson.types.ObjectId;
import java.util.List;

public class ArtistaDTO {
    private ObjectId id;
    private String nombreArtista;
    private String descripcion;
    private String generoMusical;
    private List<String> albumes; // Representamos álbumes como cadenas para simplificar

    public ArtistaDTO() {}

    public ArtistaDTO(ObjectId id, String nombreArtista, String descripcion, String generoMusical, List<String> albumes) {
        this.id = id;
        this.nombreArtista = nombreArtista;
        this.descripcion = descripcion;
        this.generoMusical = generoMusical;
        this.albumes = albumes;
    }

    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<String> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<String> albumes) {
        this.albumes = albumes;
    }
}