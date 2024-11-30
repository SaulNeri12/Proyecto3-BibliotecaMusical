/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */

import com.equipo7.negocio.bo.interfaces.IAlbumesBO;
import com.equipo7.negocio.dtos.AlbumesDTO;
import com.equipo7.negocio.dtos.convertidor.AlbumesConverter;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumesBO implements IAlbumesBO {

    private final IAlbumesDAO albumesDAO;

    public AlbumesBO(IAlbumesDAO albumesDAO) {
        this.albumesDAO = albumesDAO;
    }

    @Override
    public AlbumesDTO obtenerAlbumPorNombre(String nombreAlbum) throws DAOException {
        Album album = albumesDAO.obtenerTodosPorNombre(nombreAlbum);
        return album != null ? AlbumesConverter.entidadADto(album) : null;
    }

    @Override
    public List<AlbumesDTO> obtenerAlbumesPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        List<Album> albumes = albumesDAO.obtenerTodosPorFiltro(filtroBusqueda);
        return albumes.stream().map(AlbumesConverter::entidadADto).collect(Collectors.toList());
    }

    @Override
    public List<AlbumesDTO> obtenerTodos() throws DAOException {
        List<Album> albumes = albumesDAO.obtenerTodos();
        return albumes.stream().map(AlbumesConverter::entidadADto).collect(Collectors.toList());
    }

    @Override
    public List<AlbumesDTO> obtenerAlbumesPorArtista(String nombreArtista) throws DAOException {
        List<Album> albumes = albumesDAO.obtenerTodosPorArtista(nombreArtista);
        return albumes.stream().map(AlbumesConverter::entidadADto).collect(Collectors.toList());
    }

    @Override
    public void realizarInsercionMasiva() throws DAOException {
        albumesDAO.insercionMasiva();
    }
}