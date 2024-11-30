/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.dto.ArtistaDTO;
import excepciones.NegocioException;

import java.util.List;

public interface IArtistasBO {
    List<ArtistaDTO> obtenerTodos() throws NegocioException;
    ArtistaDTO obtenerPorId(String id) throws NegocioException;
    void insertar(ArtistaDTO artista) throws NegocioException;
    void actualizar(ArtistaDTO artista) throws NegocioException;
    void eliminar(String id) throws NegocioException;
    List<ArtistaDTO> buscarPorNombre(String nombre) throws NegocioException;
}