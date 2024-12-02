/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * La interfaz IArtistasDAO define las operaciones de acceso y manipulación de
 * los artistas en la base de datos. Esta interfaz debe ser implementada por una
 * clase que se encargue de la interacción con la base de datos (por ejemplo,
 * MongoDB). Las operaciones incluyen registrar, obtener, actualizar, eliminar y
 * realizar búsquedas de artistas con filtros específicos.
 */
public interface IArtistasDAO {

    public List<Artista> obtenerTodos() throws DAOException;
    
    public Artista obtenerPorId(ObjectId id) throws DAOException;
    
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException;
    
    public void insercionMasiva(List<Artista> listaArtistas) throws DAOException;
    
    /*
     * Registra un nuevo artista en la base de datos.
     * 
     * @param artista El objeto Artista que se desea registrar en la base de datos.
     * @return El Artista registrado con su ID generado por la base de datos.
     */
    void registrar(Artista artista) throws DAOException;

    /**
     * Obtiene todos los artistas que coinciden con los criterios de búsqueda
     * especificados en el filtro proporcionado.
     *
     * @param filtro El filtro de búsqueda, que puede contener criterios como
     * nombre, tipo, etc.
     * @return Una lista de artistas que cumplen con los criterios del filtro.
     */
    List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException;

    /**
     * Convierte un documento de base de datos (MongoDB) en un objeto Artista.
     *
     * Este método es responsable de transformar un documento (que generalmente
     * es un objeto BSON) en una instancia de la clase Artista. Esto es útil
     * cuando se recuperan los artistas desde la base de datos.
     *
     * @param document El documento de la base de datos que contiene los datos
     * del artista.
     * @return El objeto Artista correspondiente con los datos extraídos del
     * documento.
     */
    Artista documentoAObjeto(Document document);

    /**
     * Verifica si un artista con el nombre proporcionado ya existe en la base
     * de datos.
     *
     * Este método permite determinar si un artista ya está registrado en la
     * base de datos verificando su nombre. Es útil para evitar registros
     * duplicados.
     *
     * @param nombre El nombre del artista a verificar.
     * @return true si el artista ya existe en la base de datos; false en caso
     * contrario.
     * @throws DAOException Si ocurre un error al consultar la base de datos.
     */
    boolean artistaExiste(String nombre);

}
