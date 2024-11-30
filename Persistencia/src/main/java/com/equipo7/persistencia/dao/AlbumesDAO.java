package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.util.ArrayList;
import org.bson.Document;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Implementa los metodos de la interfaz IAlbumesDAO para proveer la
 * funcionalidad de la misma
 *
 * @author Saul Neri
 */
public class AlbumesDAO implements IAlbumesDAO {

    private static AlbumesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Album> albumes;

    /**
     * Constructor privado para generacion de instancia unica
     *
     * @throws ConexionException Si ocurre un error al obtener la coleccion de
     * albumes
     */
    private AlbumesDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        albumes = bibliotecaMusicalBD.getCollection(Album.NOMBRE_COLLECTION, Album.class);
    }

    /**
     * Obtiene la instancia unica del DAO de albumes
     *
     * @return Instancia unica del DAO
     * @throws ConexionException si ocurre un error al tratar de obtener la
     * instancia
     */
    public static AlbumesDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new AlbumesDAO();
        }

        return instance;
    }

    @Override
    public Album obtenerTodosPorNombre(String nombreAlbum) throws DAOException {
        return null;
    }

    /**
     * Obtiene el ObjectId de un álbum basado en su nombre.
     *
     * @param nombreAlbum El nombre del álbum.
     * @return El ObjectId del álbum si se encuentra, o null si no existe.
     * @throws DAOException Si ocurre un error en la consulta.
     */
    public ObjectId getObjectId(String nombreAlbum) throws DAOException {
        try {
            Album album = albumes.find(Filters.eq("nombre", nombreAlbum)).first(); // Busca el álbum usando el filtro.

            if (album != null) {
                return album.getId(); // Devuelve el ObjectId desde el POJO.
            }
            return null; // Si no se encuentra el álbum.
        } catch (Exception e) {
            throw new DAOException("Error al obtener el ObjectId del álbum: " + e.getMessage());
        }
    }

    @Override
    public List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        return List.of();
    }

    @Override
    public List<Album> obtenerTodos() throws DAOException {
        return List.of();
    }

    @Override
    public List<Album> obtenerTodosPorArtista(String nombreArtista) throws DAOException {
        return List.of();
    }

    /**
     * Método para registrar un nuevo álbum en la base de datos y asignarle un
     * ID automáticamente después de la inserción.
     *
     * @param album El objeto Album a registrar.
     */
    @Override
    public void registrar(Album album) throws DAOException {
        try {
            // Insertar el álbum en la base de datos
            albumes.insertOne(album);

            // Después de la inserción, asignamos el ObjectId generado al objeto Album
            if (album.getId() == null) {
                // MongoDB genera automáticamente el ObjectId si no existe uno
                album.setId(albumes.find(Filters.eq("nombre", album.getNombre())).first().getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Error al registrar el álbum: " + e.getMessage());
        }
    }

    @Override
    public void insercionMasiva() throws DAOException {

    }

    public Album obtenerPorId(ObjectId id) throws DAOException {
        try {
            // Busca el álbum por su ObjectId en la colección de álbumes
            Album album = albumes.find(Filters.eq("_id", id)).first();

            if (album == null) {
                // Si no se encuentra el álbum, lanzamos una excepción
                throw new DAOException("No se encontró el álbum con ID: " + id);
            }

            return album;
        } catch (Exception e) {
            // En caso de error, lanzamos una excepción personalizada
            throw new DAOException("Error al obtener el álbum con ID: " + id + " - " + e.getMessage());
        }
    }
}
