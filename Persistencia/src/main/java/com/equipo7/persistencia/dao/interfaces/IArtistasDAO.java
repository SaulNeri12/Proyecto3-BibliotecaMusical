/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Artista.
 */
public interface IArtistasDAO {

    /**
     * Obtiene todos los artistas de la colección.
     *
     * @return Lista de todos los artistas.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Artista> obtenerTodos() throws DAOException;

    /**
     * Obtiene una lista de artistas por un nombre parcial o completo.
     *
     * @param nombreArtista El nombre o patrón del artista.
     * @return Lista de artistas que coinciden con el nombre.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException;

    /**
     * Obtiene un artista por su nombre exacto.
     *
     * @param nombreArtista El nombre exacto del artista.
     * @return El artista encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    Artista obtenerArtistaPorNombre(String nombreArtista) throws DAOException;

    /**
     * Inserta un nuevo artista en la colección.
     *
     * @param artista El artista a insertar.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    void insertar(Artista artista) throws DAOException;

    /**
     * Obtiene un artista por su ID.
     *
     * @param id El ID del artista.
     * @return El artista encontrado o null si no existe.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    Artista obtenerPorId(ObjectId id) throws DAOException;

    /**
     * Actualiza los datos de un artista en la colección.
     *
     * @param artista El artista con los datos actualizados.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    void actualizar(Artista artista) throws DAOException;

    /**
     * Elimina un artista de la colección por su ID.
     *
     * @param id El ID del artista a eliminar.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    void eliminar(ObjectId id) throws DAOException;

    /**
     * Obtiene una lista de artistas que cumplen con los criterios especificados en el filtro.
     *
     * @param filtroBusqueda Los criterios de búsqueda.
     * @return Lista de artistas que cumplen con los criterios.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;
}
