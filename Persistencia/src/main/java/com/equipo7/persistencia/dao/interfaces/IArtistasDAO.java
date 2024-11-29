/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;

import java.util.List;

/**
 * Define las operaciones necesarias para manejar artistas en el sistema
 * @author Saul Neri
 */
public interface IArtistasDAO {

    /**
     * Obtiene todos los artistas almacenados en la base de datos.
     *
     * @return Una lista de objetos Artista que contiene todos los artistas.
     * @throws DAOException Si ocurre un error al intentar recuperar los artistas desde la base de datos.
     */
    public List<Artista> obtenerTodos() throws DAOException;

    /**
     * Obtiene todos los artistas que coinciden con el nombre proporcionado.
     *
     * @param nombreArtista El nombre del artista a buscar.
     * @return Una lista de objetos Artista que coinciden con el nombre proporcionado.
     * @throws DAOException Si ocurre un error al intentar recuperar los artistas desde la base de datos.
     */
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException;

    /**
     * Obtiene todos los artistas que coinciden con el filtro de búsqueda proporcionado.
     *
     * @param filtroBusqueda Un objeto FiltroBusqueda que contiene los criterios para filtrar los artistas.
     * @return Una lista de objetos Artista que cumplen con los criterios de búsqueda.
     * @throws DAOException Si ocurre un error al intentar recuperar los artistas desde la base de datos.
     */
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;
}
