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
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
     * Constructor privado para generación de instancia única
     * Inicializa las colecciones de canciones y álbumes, y establece la conexión con la base de datos.
     * 
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios.
     */ 
public class CancionesDAO implements ICancionesDAO {
    
    private static CancionesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Cancion> canciones;
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
    /**
     * Obtiene todas las canciones almacenadas en la base de datos.
     * 
     * @return Lista de todas las canciones.
     * @throws DAOException Si ocurre un error al obtener las canciones.
     */
    @Override
    public List<Cancion> obtenerTodasCanciones() throws DAOException {
        try {
            // Recuperar todas las canciones de la colección
            return canciones.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al obtener todas las canciones: " + e.getMessage());
        }
    }

    /**
     * Obtener todas las canciones por nombre.
     * 
     * @param nombreCancion El nombre de la canción a buscar.
     * @return Lista de canciones con el nombre especificado.
     * @throws DAOException Si ocurre un error al obtener las canciones.
     */
    @Override
    public List<Cancion> obtenerTodasPorNombre(String nombreCancion) throws DAOException {
        try {
            List<Cancion> listaCanciones = new ArrayList<>();
            canciones.find(Filters.eq("nombre", nombreCancion)).into(listaCanciones);
            return listaCanciones;
        } catch (Exception e) {
            throw new DAOException("Error al obtener canciones por nombre: " + e.getMessage());
        }
    }
    /**
     * Crear una nueva canción en la base de datos.
     * Verifica si la canción ya existe y la inserta si no.
     * 
     * @param cancion La canción a insertar.
     * @throws DAOException Si ocurre un error al insertar la canción o si ya existe una canción con el mismo nombre.
     */
    @Override
    public void crearCancion(Cancion cancion) throws DAOException {
        try {
            // Verificar si la canción ya existe por nombre
            Cancion existente = canciones.find(Filters.eq("nombre", cancion.getNombre())).first();
            if (existente != null) {
                throw new DAOException("La canción con el nombre '" + cancion.getNombre() + "' ya existe.");
            }
            
            // Inserta la canción en la colección
            canciones.insertOne(cancion);

            // Asegurar que la canción tenga un ID
            if (cancion.getId() == null) {
                cancion.setId(canciones.find(Filters.eq("nombre", cancion.getNombre())).first().getId());
            }
        } catch (Exception e) {
            throw new DAOException("Error al crear la canción: " + e.getMessage());
        }
    }
    
    /**
     * Obtener una canción por su ID.
     * 
     * @param id El ID de la canción.
     * @return La canción con el ID especificado.
     * @throws DAOException Si ocurre un error al obtener la canción.
     */
    @Override
    public Cancion obtenerCancionPorId(ObjectId id) throws DAOException {
        try {
            return canciones.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al obtener la canción por ID: " + e.getMessage());
        }
    }

    /**
     * Obtener canciones de un álbum específico.
     * 
     * @param idAlbum El ID del álbum.
     * @return Lista de canciones de un álbum específico.
     * @throws DAOException Si ocurre un error al obtener las canciones.
     */
    @Override
    public List<Cancion> obtenerCancionesPorAlbum(ObjectId idAlbum) throws DAOException {
        try {
            List<Cancion> listaCanciones = new ArrayList<>();
            canciones.find(Filters.eq("idAlbum", idAlbum)).into(listaCanciones);
            return listaCanciones;
        } catch (Exception e) {
            throw new DAOException("Error al obtener canciones por álbum: " + e.getMessage());
        }
    }

    /**
     * Obtener canciones por género.
     * Realiza una búsqueda de álbumes por género y luego obtiene las canciones que pertenecen a esos álbumes.
     * 
     * @param genero El género de las canciones.
     * @return Lista de canciones con el género especificado.
     * @throws DAOException Si ocurre un error al obtener las canciones.
     */
    @Override
    public List<Cancion> obtenerCancionesPorGenero(String genero) throws DAOException {
        try {
            List<Cancion> listaCanciones = new ArrayList<>();

            // Buscar los álbumes que coincidan con el género
            List<Album> albums = albumes.find(Filters.eq("generoMusical", genero)).into(new ArrayList<>());
            
            
            if (albums.isEmpty()) {
                return listaCanciones;  // Si no hay álbumes para el género, devolver lista vacía
            }

            // Obtener los IDs de los álbumes encontrados
            List<ObjectId> albumIds = new ArrayList<>();
            for (Album album : albums) {
                albumIds.add(album.getId()); // Suponiendo que Album tiene el método getId()
            }

            // Buscar las canciones que pertenecen a los álbumes encontrados
            canciones.find(Filters.in("idAlbum", albumIds)).into(listaCanciones);
            
            return listaCanciones;
        } catch (Exception e) {
            throw new DAOException("Error al obtener canciones por género: " + e.getMessage());
        }
    }

    /**
     * Método aun no implementado
     * 
     * @param filtro El filtro de búsqueda.
     * @throws UnsupportedOperationException Lanza una excepción indicando que el método no está implementado.
     */
    @Override
    public List<Cancion> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}