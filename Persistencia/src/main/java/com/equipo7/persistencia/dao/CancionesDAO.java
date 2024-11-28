/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.ICancionesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.DAOException;
import java.util.List;

/**
 * Implementa las operaciones defiidas en la interfaz ICancionesDAO
 * @author Saul Neri
 */
public class CancionesDAO implements ICancionesDAO {
    
    private static CancionesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Album> albumes;

    /**
     * Constructor privado para generación de instancia única
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios
     */
    private CancionesDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        albumes = bibliotecaMusicalBD.getCollection(Album.NOMBRE_COLLECTION, Album.class);
    }

    /**
     * Obtiene la instancia única del DAO de usuarios
     * @return Instancia única del DAO
     * @throws ConexionException Si ocurre un error al tratar de obtener la instancia
     */
    public static CancionesDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new CancionesDAO();
        }

        return instance;
    }

    @Override
    public List<Cancion> obtenerTodas() throws DAOException {
        /**
         * TODO: LAS CANCIONES SE OBTIENEN DE LOS ALBUMES, Y SE LES ANADE A LAS INSTANCIAS DE CANCION:
         *  1. Nombre de la cancion proveniente del Album
         *  2. Referencia al album.
         *  3. Nombre del album.
         *  4. Nombre del artista.
         */
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cancion> obtenerTodasPorNombre(String nombreCancion) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cancion> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
