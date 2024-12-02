/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.negocio.dtos.FiltroBusquedaDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interface para la lógica de negocio relacionada con álbumes.
 * Proporciona métodos para manejar las operaciones principales sobre álbumes.
 * 
 * @author caarl
 */
public interface IAlbumBO {
    
    AlbumDTO obtenerPorId(ObjectId id) throws BOException;
    
    public List<AlbumDTO> obtenerTodosPorArtista(ObjectId idArtista) throws BOException; 
    
    public List<String> obtenerGenerosMusicales() throws BOException;
    
    /**
     * Obtiene una lista de todos los álbumes en la base de datos.
     *
     * @return Lista de objetos {@code AlbumDTO}.
     * @throws BOException Si ocurre un error durante la operación.
     */
    List<AlbumDTO> obtenerTodos() throws BOException;

    /**
     * Obtiene una lista de álbumes que coinciden con un nombre dado.
     *
     * @param nombreAlbum El nombre del álbum para buscar.
     * @return Lista de objetos {@code AlbumDTO} que coinciden con el nombre.
     * @throws BOException Si ocurre un error durante la operación.
     */
    List<AlbumDTO> obtenerTodosPorNombre(String nombreAlbum) throws BOException;

    /**
     * Obtiene una lista de álbumes que coinciden con los criterios de búsqueda especificados.
     *
     * @param filtroBusquedaDTO El objeto {@code FiltroBusquedaDTO} con los criterios de búsqueda.
     * @return Lista de objetos {@code AlbumDTO} que cumplen con los criterios.
     * @throws BOException Si ocurre un error durante la operación.
     */
    List<AlbumDTO> obtenerTodosPorFiltro(FiltroBusquedaDTO filtroBusquedaDTO) throws BOException;

    /**
     * Obtiene una lista de álbumes asociados a un artista.
     *
     * @param nombreArtista El nombre del artista.
     * @return Lista de objetos {@code AlbumDTO} asociados al artista.
     * @throws BOException Si ocurre un error durante la operación.
     */
    List<AlbumDTO> obtenerTodosPorArtista(String nombreArtista) throws BOException;

    /**
     * Registra un nuevo álbum en la base de datos.
     *
     * @param albumDTO El objeto {@code AlbumDTO} que representa el álbum a registrar.
     * @throws BOException Si ocurre un error durante la operación.
     */
    void registrar(AlbumDTO albumDTO) throws BOException;

    /**
     * Realiza la inserción masiva de álbumes en la base de datos.
     *
     * @param albumesLista Lista de objetos {@code AlbumDTO} a insertar.
     * @throws BOException Si ocurre un error durante la operación.
     */
    void insercionMasiva(List<AlbumDTO> albumesLista) throws BOException;
}
