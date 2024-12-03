/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.ICancionesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
     * Constructor privado para generación de instancia única
     * Inicializa las colecciones de canciones y álbumes, y establece la conexión con la base de datos.
     * 
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios.
     */ 
public class CancionesDAO implements ICancionesDAO {
    
    private static CancionesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Album> albumes;

    /**
     * Constructor privado para generación de instancia única
     * Inicializa las colecciones de canciones y álbumes, y establece la conexión con la base de datos.
     * 
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios.
     */
    private CancionesDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        //canciones = bibliotecaMusicalBD.getCollection(Cancion.NOMBRE_COLLECTION, Cancion.class);
        albumes = bibliotecaMusicalBD.getCollection(Album.NOMBRE_COLLECTION, Album.class);
    }

    /**
     * Obtiene la instancia única del DAO de canciones.
     * Si no existe una instancia, se crea una nueva.
     * 
     * @return Instancia única de CancionesDAO.
     * @throws ConexionException Si ocurre un error al obtener la instancia.
     */
    public static CancionesDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new CancionesDAO();
        }

        return instance;
    }
    @Override
    public List<String> obtenerCancionesPorGenero(String generoMusical) {
        List<String> canciones = new ArrayList<>();

        albumes.find(Filters.eq("generoMusical", generoMusical))
                .forEach(album -> canciones.addAll(album.getCanciones()));

        return canciones;
    }
    @Override
    public List<String> obtenerCancionesPorNombre(String nombreParcial) {
        List<String> canciones = new ArrayList<>();

        Pattern regex = Pattern.compile(nombreParcial, Pattern.CASE_INSENSITIVE);

        albumes.find(Filters.regex("canciones", regex))
                .forEach(album -> {
                    for (String cancion : album.getCanciones()) {
                        if (regex.matcher(cancion).find()) {
                            canciones.add(cancion);
                        }
                    }
                });

        return canciones;
    }


}