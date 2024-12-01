/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Define las operaciones necesarias para acceder a las canciones del sistema.
 * @author Saul Neri
 */
/**
 * Interfaz que define las operaciones básicas de acceso a los datos para las canciones.
 * Contiene métodos para obtener, crear y filtrar canciones en la base de datos.
 */
public interface ICancionesDAO {

    /**
     * Obtiene una lista de canciones según el filtro de búsqueda proporcionado.
     * 
     * @param filtro El filtro que se usará para buscar canciones. Este puede incluir diferentes criterios como nombre, género, etc.
     * @return Lista de canciones que cumplen con los criterios del filtro.
     * @throws DAOException Si ocurre un error al obtener las canciones según el filtro.
     */
    public List<Cancion> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException;

    /**
     * Obtiene todas las canciones que pertenecen a un álbum con el género musical especificado.
     * 
     * @param genero El género musical de los álbumes para los cuales se buscarán las canciones.
     * @return Lista de canciones pertenecientes a los álbumes con el género especificado.
     * @throws DAOException Si ocurre un error al obtener las canciones por género.
     */
    public List<Cancion> obtenerCancionesPorGenero(String genero) throws DAOException;

    /**
     * Obtiene todas las canciones que pertenecen a un álbum específico.
     * 
     * @param idAlbum El ID del álbum cuyo conjunto de canciones se desea obtener.
     * @return Lista de canciones pertenecientes al álbum especificado.
     * @throws DAOException Si ocurre un error al obtener las canciones del álbum.
     */
    public List<Cancion> obtenerCancionesPorAlbum(ObjectId idAlbum) throws DAOException;

    /**
     * Obtiene una canción específica por su ID.
     * 
     * @param id El ID de la canción a obtener.
     * @return La canción con el ID especificado.
     * @throws DAOException Si ocurre un error al obtener la canción por su ID.
     */
    public Cancion obtenerCancionPorId(ObjectId id) throws DAOException;

    /**
     * Crea una nueva canción en la base de datos.
     * 
     * @param cancion La canción que se va a crear e insertar en la base de datos.
     * @throws DAOException Si ocurre un error al crear la canción.
     */
    public void crearCancion(Cancion cancion) throws DAOException;

    /**
     * Obtiene todas las canciones almacenadas en la base de datos.
     * 
     * @return Lista de todas las canciones almacenadas.
     * @throws DAOException Si ocurre un error al obtener las canciones.
     */
    public List<Cancion> obtenerTodasCanciones() throws DAOException;

    /**
     * Obtiene todas las canciones con el nombre especificado.
     * 
     * @param nombreCancion El nombre de la canción a buscar.
     * @return Lista de canciones con el nombre especificado.
     * @throws DAOException Si ocurre un error al obtener las canciones por nombre.
     */
    public List<Cancion> obtenerTodasPorNombre(String nombreCancion) throws DAOException;
}