/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.bo.interfaces.IAlbumBO;

import com.equipo7.persistencia.dao.AlbumesDAO;

import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.negocio.dtos.convertidor.AlbumConvertidor;
import com.equipo7.persistencia.entidades.Album;
import excepciones.DAOException;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumBO implements IAlbumBO {
    private AlbumesDAO albumesDAO;

    public AlbumBO() throws Exception {
        this.albumesDAO = AlbumesDAO.getInstance();
    }

    @Override
    public AlbumDTO obtenerPorId(String id) throws DAOException {
        Album album = albumesDAO.obtenerPorId(new ObjectId(id));
        return AlbumConvertidor.entidadADto(album);
    }

    @Override
    public List<AlbumDTO> obtenerTodos() throws DAOException {
        List<Album> albumes = albumesDAO.obtenerTodos();
        return albumes.stream().map(AlbumConvertidor::entidadADto).collect(Collectors.toList());
    }

    @Override
    public List<AlbumDTO> obtenerPorFiltro(String filtro) throws DAOException {
        // Implementación personalizada para aplicar filtros
        return List.of(); // De momento vacío
    }

    @Override
    public void registrar(AlbumDTO albumDTO) throws DAOException {
        Album album = AlbumConvertidor.dtoAEntidad(albumDTO);
        albumesDAO.registrar(album);
    }

    @Override
    public void actualizar(AlbumDTO albumDTO) throws DAOException {
        Album album = AlbumConvertidor.dtoAEntidad(albumDTO);
        albumesDAO.actualizar(album);
    }
}