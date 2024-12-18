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
import org.bson.types.ObjectId;

/**
 * Implementación del DAO para manejar la entidad Album en MongoDB.
 */
public class AlbumesDAO implements IAlbumesDAO {

    private static AlbumesDAO instance;
    private MongoCollection<Album> coleccionAlbumes;

    private AlbumesDAO() {
        try {
            coleccionAlbumes = Conexion.getInstance()
                    .getBibliotecaMusicalBD()
                    .getCollection("albumes", Album.class);
        } catch (ConexionException e) {
            System.out.println("### no se pudo conectar a la base de datos de mongo [albumDAO]");
        }
    }

    /**
     *
     * @return
     */
    public static AlbumesDAO getInstance() {
        if (instance == null) {
            instance = new AlbumesDAO();
        }

        return instance;
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

    @Override
    public Album obtenerPorId(ObjectId id) throws DAOException {
        try {
            return coleccionAlbumes.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error en la inserción masiva de álbumes");
        }
    }

    @Override
    public List<Album> obtenerPorArtista(ObjectId id) throws DAOException {
        try {
            Bson filtro = Filters.eq("referenciaArtista", id);
            return coleccionAlbumes.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al buscar álbumes por artista");
        }
    }

    @Override
    public List<String> obtenerGenerosMusicales() throws DAOException {
        try {
            // Ejecutar la consulta 'distinct' para obtener géneros únicos
            return coleccionAlbumes.distinct("generoMusical", String.class).into(new ArrayList<>());
        } catch (Exception e) {
            // Manejar posibles errores de la base de datos
            throw new DAOException("Error al obtener los géneros musicales");
        }
    }
}
