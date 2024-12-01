package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertManyOptions;
import excepciones.DAOException;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para manejar la entidad Album en MongoDB.
 */
public class AlbumesDAO implements IAlbumesDAO {

    private final MongoCollection<Album> coleccionAlbumes;

    public AlbumesDAO() throws DAOException {
        try {
            coleccionAlbumes = Conexion.getInstance()
                    .getBibliotecaMusicalBD()
                    .getCollection("albumes", Album.class);
        } catch (ConexionException e) {
            throw new DAOException("Error al conectar con la base de datos");
        }
    }

    @Override
    public List<Album> obtenerTodos() throws DAOException {
        try (MongoCursor<Album> cursor = coleccionAlbumes.find().iterator()) {
            List<Album> albumes = new ArrayList<>();
            while (cursor.hasNext()) {
                albumes.add(cursor.next());
            }
            return albumes;
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los álbumes");
        }
    }

    @Override
    public List<Album> obtenerTodosPorNombre(String nombreAlbum) throws DAOException {
        try {
            Bson filtro = Filters.regex("nombre", nombreAlbum, "i");
            return coleccionAlbumes.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al buscar álbumes por nombre");
        }
    }

    @Override
    public List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        try {
            Bson filtro = filtroBusqueda.toBson();
            return coleccionAlbumes.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al buscar álbumes por filtro");
        }
    }

    @Override
    public List<Album> obtenerTodosPorArtista(String nombreArtista) throws DAOException {
        try {
            Bson filtro = Filters.regex("nombreArtista", nombreArtista, "i");
            return coleccionAlbumes.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al buscar álbumes por artista");
        }
    }

    @Override
    public void registrar(Album album) throws DAOException {
        try {
            coleccionAlbumes.insertOne(album);
        } catch (Exception e) {
            throw new DAOException("Error al registrar el álbum");
        }
    }

    @Override
    public void insercionMasiva(List<Album> albumesLista) throws DAOException {
        try {
            coleccionAlbumes.insertMany(albumesLista, new InsertManyOptions().ordered(false));
        } catch (Exception e) {
            throw new DAOException("Error en la inserción masiva de álbumes");
        }
    }
}
