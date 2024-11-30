/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.CancionDTO;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author caarl
 */
public interface ICancionesBO {
    List<CancionDTO> obtenerTodas() throws DAOException;
    List<CancionDTO> obtenerPorNombre(String nombre) throws DAOException;
    CancionDTO obtenerPorId(String id) throws DAOException;
    void agregarCancion(CancionDTO cancionDTO) throws DAOException;
    List<CancionDTO> obtenerPorGenero(String genero) throws DAOException;
    List<CancionDTO> obtenerPorAlbum(String idAlbum) throws DAOException;
}