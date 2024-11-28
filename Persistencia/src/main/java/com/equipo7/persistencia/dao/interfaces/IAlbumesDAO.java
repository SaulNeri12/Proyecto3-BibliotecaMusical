/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Define las operaciones necesarias para interactuar
 * @author neri
 */
public interface IAlbumesDAO {
    
    /**
     * Obtiene el album con el ID especificado.
     * @param id ID del album.
     * @return Album
     * @throws DAOException Si ocurre un error.
     */
    public Album obtenerPorId(ObjectId id) throws DAOException;
    
    /**
     * Obtiene todos los álbumes cuyo nombre coincide con el proporcionado.
     *
     * @param nombreAlbum El nombre del álbum que se desea buscar.
     * @return Una lista de álbumes que coinciden con el nombre proporcionado.
     * @throws DAOException Si ocurre un error durante la operación de obtención de datos desde la base de datos.
     */
    public Album obtenerTodosPorNombre(String nombreAlbum) throws DAOException;

    /**
     * Obtiene todos los álbumes que coinciden con los criterios proporcionados en el filtro de búsqueda.
     * El filtro puede incluir propiedades como el nombre del álbum, el artista, el año, entre otros.
     *
     * @param filtroBusqueda El objeto que contiene los criterios de búsqueda para filtrar los álbumes.
     * @return Una lista de álbumes que cumplen con los criterios del filtro de búsqueda.
     * @throws DAOException Si ocurre un error durante la operación de obtención de datos desde la base de datos.
     */
    public List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;

    /**
     * Obtiene todos los álbumes disponibles en la base de datos sin aplicar ningún filtro.
     *
     * @return Una lista de todos los álbumes en la base de datos.
     * @throws DAOException Si ocurre un error durante la operación de obtención de datos desde la base de datos.
     */
    public List<Album> obtenerTodos() throws DAOException;

    /**
     * Obtiene todos los álbumes de un artista específico.
     *
     * @param idArtista El ID del artista cuyos álbumes se desean obtener.
     * @return Una lista de álbumes del artista especificado.
     * @throws DAOException Si ocurre un error durante la operación de obtención de datos desde la base de datos.
     */
    public List<Album> obtenerTodosPorArtista(ObjectId idArtista) throws DAOException;

    /**
     * Realiza una inserción masiva de registros en la base de datos para agregar varios álbumes de una sola vez.
     *
     * @throws DAOException Si ocurre un error durante la operación de inserción masiva en la base de datos.
     */
    public void insercionMasiva() throws DAOException;

}
