/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

/**
 *
 * @author caarl
 */


import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.negocio.excepciones.BOException;
import excepciones.DAOException;
import java.util.List;

public interface IArtistasBO {
    List<ArtistaDTO> obtenerTodos() throws DAOException;
    ArtistaDTO obtenerPorId(String id) throws DAOException;
    void insertar(ArtistaDTO artista) throws DAOException;
    void actualizar(ArtistaDTO artista) throws DAOException;
    void eliminar(String id) throws DAOException;
    List<ArtistaDTO> buscarPorNombre(String nombre) throws DAOException;
}