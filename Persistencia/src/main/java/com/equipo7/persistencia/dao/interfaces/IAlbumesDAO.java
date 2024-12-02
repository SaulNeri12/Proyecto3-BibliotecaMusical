/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz para definir los métodos del DAO de álbumes.
 *
 * @author
 */
public interface IAlbumesDAO {

    Album obtenerPorId(ObjectId id) throws DAOException;
    
    List<Album> obtenerPorArtista(ObjectId id) throws DAOException;
    
    public List<String> obtenerGenerosMusicales() throws DAOException;
    
    /**
     * Obtiene una lista de todos los álbumes en la base de datos.
     *
     * @return Lista de álbumes.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Album> obtenerTodos() throws DAOException;

    /**
     * Obtiene una lista de álbumes que coinciden con un nombre dado.
     *
     * @param nombreAlbum El nombre del álbum para buscar.
     * @return Lista de álbumes que coinciden con el nombre.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Album> obtenerTodosPorNombre(String nombreAlbum) throws DAOException;

    /**
     * Obtiene una lista de álbumes que coinciden con los criterios de búsqueda especificados.
     *
     * @param filtroBusqueda El objeto con los criterios de búsqueda.
     * @return Lista de álbumes que cumplen con los criterios.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;

    /**
     * Obtiene una lista de álbumes asociados a un artista.
     *
     * @param nombreArtista El nombre del artista.
     * @return Lista de álbumes asociados al artista.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    List<Album> obtenerTodosPorArtista(String nombreArtista) throws DAOException;

    /**
     * Registra un nuevo álbum en la base de datos.
     *
     * @param album El álbum a registrar.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    void registrar(Album album) throws DAOException;

    /**
     * Realiza la inserción masiva de álbumes en la base de datos.
     *
     * @param albumesLista Lista de álbumes a insertar.
     * @throws DAOException Si ocurre un error durante la operación.
     */
    void insercionMasiva(List<Album> albumesLista) throws DAOException;
}
