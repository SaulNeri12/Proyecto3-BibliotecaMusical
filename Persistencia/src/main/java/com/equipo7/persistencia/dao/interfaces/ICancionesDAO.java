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
    List<Cancion> obtenerCancionesPorArtista(ObjectId idArtista) throws DAOException;
    List<Cancion> obtenerCancionesPorGenero(String generoMusical) throws DAOException;
    List<Cancion> obtenerCancionesPorNombre(String nombreParcial) throws DAOException;
}