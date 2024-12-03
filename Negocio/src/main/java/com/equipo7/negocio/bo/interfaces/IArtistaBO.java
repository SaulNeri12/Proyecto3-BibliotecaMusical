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

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Define las operaciones de negocio relacionadas con los artistas.
 */
public interface IArtistaBO {

    public List<ArtistaDTO> obtenerTodos() throws BOException;

    public ArtistaDTO obtenerPorId(ObjectId id) throws BOException;

    public List<ArtistaDTO> obtenerTodosPorNombre(String nombreArtista) throws BOException;

    public void insercionMasiva(List<ArtistaDTO> listaArtistas) throws BOException;

    /**
     * Registra un nuevo artista en el sistema.
     *
     * @param artistaDTO El artista a registrar.
     * @throws BOException Si ocurre un error al registrar el artista.
     */
    void registrarArtista(ArtistaDTO artistaDTO) throws BOException;

    /**
     * Obtiene todos los artistas que coinciden con los criterios de búsqueda.
     *
     * @param filtroBusqueda El filtro de búsqueda.
     * @return Lista de artistas encontrados.
     * @throws BOException Si ocurre un error al obtener los artistas.
     */
    List<ArtistaDTO> obtenerArtistasPorFiltro(String filtroBusqueda) throws BOException;

    /**
     * Verifica si un artista con el nombre proporcionado ya existe.
     *
     * @param nombre El nombre del artista.
     * @return `true` si el artista existe, `false` de lo contrario.
     * @throws BOException Si ocurre un error al verificar el artista.
     */
    boolean existeArtista(String nombre) throws BOException;
}
