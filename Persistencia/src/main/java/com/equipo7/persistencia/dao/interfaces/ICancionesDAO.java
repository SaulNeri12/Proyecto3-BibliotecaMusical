/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.List;

/**
 * Define las operaciones necesarias para acceder a las canciones del sistema.
 * @author Saul Neri
 */
public interface ICancionesDAO {
    
    /**
     * Obtiene todas las canciones registradas en el sistema.
     * @return Lista de canciones en el sistema
     * @throws DAOException 
     */
    public List<Cancion> obtenerTodas() throws DAOException;
    
    /**
     * Obtiene todas las canciones que coincidan con el nombre de cancion dado.
     * @param nombreCancion Nombre de la cancion a buscar.
     * @return Lista de canciones que coinciden con el nombre de la cancion.
     * @throws DAOException Si no se puede obtener la lista por un error.
     */
    public List<Cancion> obtenerTodasPorNombre(String nombreCancion) throws DAOException;
    
    /**
     * Obtiene una lista de canciones con las especificaciones dadas por el
     * filtro.
     * @param filtro Filtro de busqueda.
     * @return Lista de canciones filtradas.
     * @throws DAOException Si ocurre un error en la consulta.
     */
    public List<Cancion> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException;
}
