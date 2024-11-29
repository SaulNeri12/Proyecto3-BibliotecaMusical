/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * La interfaz IArtistasDAO define las operaciones de acceso y manipulación
 * de los artistas en la base de datos. Esta interfaz debe ser implementada por
 * una clase que se encargue de la interacción con la base de datos (por ejemplo, MongoDB).
 * Las operaciones incluyen registrar, obtener, actualizar, eliminar y realizar búsquedas
 * de artistas con filtros específicos.
 */
public interface IArtistasDAO {
    /*
     * Registra un nuevo artista en la base de datos.
     * 
     * @param artista El objeto Artista que se desea registrar en la base de datos.
     * @return El Artista registrado con su ID generado por la base de datos.
     */
    Artista registrar(Artista artista); 
    /**
     * Obtiene un artista de la base de datos por su ID.
     * 
     * @param id El ID único del artista que se desea obtener.
     * @return El Artista correspondiente al ID proporcionado, o null si no se encuentra.
     */
    Artista obtener(ObjectId id);     
    /**
     * Obtiene todos los artistas registrados en la base de datos.
     * 
     * @return Una lista de todos los artistas almacenados en la base de datos.
     */
    List<Artista> obtenerTodos();     
/**
     * Actualiza los datos de un artista en la base de datos.
     * Si el artista tiene un ID asignado, se reemplaza el documento existente
     * con los nuevos valores proporcionados.
     * 
     * @param artista El objeto Artista con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */    
    boolean actualizar(Artista artista); 
    /**
     * Obtiene todos los artistas que coinciden con los criterios de búsqueda especificados
     * en el filtro proporcionado.
     * 
     * @param filtro El filtro de búsqueda, que puede contener criterios como nombre, tipo, etc.
     * @return Una lista de artistas que cumplen con los criterios del filtro.
     */
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtro);
    /**
     * Elimina un artista de la base de datos por su ID.
     * 
     * @param id El ID único del artista que se desea eliminar.
     * @return true si el artista fue eliminado correctamente, false si no se encontró.
     */
    boolean eliminar(ObjectId id);     
    /**
     * Elimina múltiples artistas de la base de datos que coincidan con el filtro proporcionado.
     * 
     * @param filtro El filtro BSON utilizado para seleccionar los artistas a eliminar.
     * @return El número de artistas eliminados.
     */
    public long deleteMany(Document filtro);
    /**
     * Obtiene todos los artistas cuyo nombre coincida con el nombre o parte del nombre proporcionado.
     * La búsqueda es insensible a mayúsculas y minúsculas.
     * 
     * @param nombre El nombre o parte del nombre de los artistas que se desean buscar.
     * @return Una lista de artistas cuyos nombres coinciden con el filtro.
     */
    public List<Artista> obtenerTodosPorNombre(String nombre);
    
}
