/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

/**
 *
 * @author caarl
 */
public interface IAlbumesBO {
 
    AlbumDTO obtenerAlbumPorNombre(String nombreAlbum) throws BOException;

    List<AlbumDTO> obtenerAlbumesPorFiltro(FiltroBusqueda filtroBusqueda) throws BOException;

    List<AlbumDTO> obtenerTodos() throws DAOException;

    List<AlbumDTO> obtenerAlbumesPorArtista(String nombreArtista) throws BOException;

    void realizarInsercionMasiva() throws BOException;
}