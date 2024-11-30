/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.converters.AlbumConvertidor;
import com.equipo7.negocio.dto.AlbumDTO;
import com.equipo7.negocio.interfaces.IAlbumesBO;
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
    public AlbumDTO obtenerAlbumPorNombre(String nombreAlbum) throws BOException {
        Album album = albumesDAO.obtenerTodosPorNombre(nombreAlbum);
        return album != null ? AlbumConvertidor.entidadADto(album) : null;
    }

    @Override
    public List<AlbumDTO> obtenerAlbumesPorFiltro(FiltroBusqueda filtroBusqueda) throws BOException {
        List<Album> albumes = albumesDAO.obtenerTodosPorFiltro(filtroBusqueda);
        return albumes.stream().map(AlbumConvertidor::entidadADto).collect(Collectors.toList());
    }

    @Override
    public List<AlbumDTO> obtenerTodos() throws BOException {
        List<Album> albumes = albumesDAO.obtenerTodos();
        return albumes.stream().map(AlbumConvertidor::entidadADto).collect(Collectors.toList());
    }

    @Override
    public List<AlbumDTO> obtenerAlbumesPorArtista(String nombreArtista) throws BOException {
        List<Album> albumes = albumesDAO.obtenerTodosPorArtista(nombreArtista);
        return albumes.stream().map(AlbumConvertidor::entidadADto).collect(Collectors.toList());
    }

    @Override
    public void realizarInsercionMasiva() throws BOException {
        albumesDAO.insercionMasiva();
    }
}