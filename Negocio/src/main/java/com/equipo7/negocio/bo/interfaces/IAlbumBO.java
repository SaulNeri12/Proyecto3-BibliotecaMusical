/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;

import java.util.List;

/**
 * Interface para la lógica de negocio relacionada con álbumes.
 * Proporciona métodos para manejar las operaciones principales sobre álbumes.
 * 
 * @author caarl
 */
public interface IAlbumBO {
    
    List<AlbumDTO> obtenerTodos() throws DAOException;
    List<AlbumDTO> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException;
    void registrar(AlbumDTO album) throws DAOException;
}
