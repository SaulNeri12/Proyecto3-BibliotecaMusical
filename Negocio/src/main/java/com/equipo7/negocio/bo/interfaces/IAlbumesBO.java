/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.AlbumesDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author caarl
 */
public interface IAlbumesBO {
 
    AlbumesDTO obtenerAlbumPorNombre(String nombreAlbum) throws DAOException;

    List<AlbumesDTO> obtenerAlbumesPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;

    List<AlbumesDTO> obtenerTodos() throws DAOException;

    List<AlbumesDTO> obtenerAlbumesPorArtista(String nombreArtista) throws DAOException;

    void realizarInsercionMasiva() throws DAOException;
}