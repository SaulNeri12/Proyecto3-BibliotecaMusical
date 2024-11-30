/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

/**
 *
 * @author caarl
 */

import com.equipo7.negocio.dtos.AlbumDTO;
import excepciones.DAOException;

import java.util.List;

public interface IAlbumBO {
    AlbumDTO obtenerPorId(String id) throws DAOException;
    List<AlbumDTO> obtenerTodos() throws DAOException;
    List<AlbumDTO> obtenerPorFiltro(String filtro) throws DAOException;
    void registrar(AlbumDTO album) throws DAOException;
    void actualizar(AlbumDTO album) throws DAOException;
}