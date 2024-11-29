package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.DAOException;
import org.bson.Document;

import java.util.List;

/**
 * Implementa los metodos de la interfaz IAlbumesDAO para proveer la funcionalidad
 * de la misma
 * @author Saul Neri
 */
public class AlbumesDAO implements IAlbumesDAO {
    private static AlbumesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
<<<<<<< Updated upstream
    private MongoCollection<Document> albumes;
=======
    public MongoCollection<Album> albumes;
>>>>>>> Stashed changes

    /**
     * Constructor privado para generacion de instancia unica
     * @throws ConexionException Si ocurre un error al obtener la coleccion de albumes
     */
    private AlbumesDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();

         albumes = bibliotecaMusicalBD.getCollection(Album.NOMBRE_COLLECTION);
    }

    /**
     * Obtiene la instancia unica del DAO de albumes
     * @return Instancia unica del DAO
     * @throws ConexionException si ocurre un error al tratar de obtener la instancia
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

    @Override
    public void insercionMasiva() throws DAOException {

    }
}
