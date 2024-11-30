/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos;

import java.util.List;

/**
 *
 * @author caarl
 */
/**
 * Objeto de transferencia de datos para Artista.
 */
public class ArtistaDTO {

    private String id;
    private String nombreArtista;
    private String descripcion;
    private String tipo;
    private String generoMusical;
    private List<String> referenciasAlbumes;

    // Constructor vacío
    public ArtistaDTO() {}

    // Constructor completo
    public ArtistaDTO(String id, String nombreArtista, String descripcion, String tipo, String generoMusical, List<String> referenciasAlbumes) {
        this.id = id;
        this.nombreArtista = nombreArtista;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.generoMusical = generoMusical;
        this.referenciasAlbumes = referenciasAlbumes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<String> getReferenciasAlbumes() {
        return referenciasAlbumes;
    }

    public void setReferenciasAlbumes(List<String> referenciasAlbumes) {
        this.referenciasAlbumes = referenciasAlbumes;
    }
    
    
    
}