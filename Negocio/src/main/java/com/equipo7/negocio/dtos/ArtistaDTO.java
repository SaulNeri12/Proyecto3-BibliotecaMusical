/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
/**
 * Objeto de transferencia de datos para Artista.
 */
public class ArtistaDTO {

    private ObjectId _id;
    private String nombreArtista;
    private String descripcion;
    private String tipo;
    private String generoMusical;
    private List<ObjectId> referenciasAlbumes;
    private String imagenURL;

    // Constructor vacío
    public ArtistaDTO() {}

    // Constructor completo
    public ArtistaDTO(ObjectId _id, String nombreArtista, String descripcion, String tipo, String generoMusical, List<ObjectId> referenciasAlbumes) {
        this._id = _id;
        this.nombreArtista = nombreArtista;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.generoMusical = generoMusical;
        this.referenciasAlbumes = referenciasAlbumes;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<ObjectId> getReferenciasAlbumes() {
        return referenciasAlbumes;
    }

    public void setReferenciasAlbumes(List<ObjectId> referenciasAlbumes) {
        this.referenciasAlbumes = referenciasAlbumes;
    }

    /**
     * @return the imagenURL
     */
    public String getImagenURL() {
        return imagenURL;
    }

    /**
     * @param imagenURL the imagenURL to set
     */
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
    
    
    
}