package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.DAOException;
import org.bson.Document;

import java.util.List;

public class ArtistasDAO implements IArtistasDAO {

    private static ArtistasDAO instance;  // Instancia única de la clase ArtistasDAO
    private MongoDatabase bibliotecaMusicalBD;  // Conexión con la base de datos de la biblioteca musical
    private MongoCollection<Document> artistas;  // Colección de artistas en la base de datos

    /**
     * Constructor privado para la generación de la instancia única.
     * Inicializa la colección de artistas desde la base de datos.
     *
     * @throws ConexionException Si ocurre un error al obtener la colección de artistas.
     */
    private ArtistasDAO() throws ConexionException {
        // Se obtiene la instancia de la conexión a la base de datos
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();

        // Se obtiene la colección de artistas de la base de datos
        artistas = bibliotecaMusicalBD.getCollection(Artista.NOMBRE_COLLECTION);
    }

    /**
     * Obtiene la instancia única del DAO de artistas.
     * Si la instancia no existe, se crea una nueva.
     *
     * @return Instancia única del DAO de artistas.
     * @throws ConexionException Si ocurre un error al tratar de obtener la instancia.
     */
    public static ArtistasDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new ArtistasDAO();
        }
        return instance;
    }

    @Override
    public List<Artista> obtenerTodos() throws DAOException {
        return List.of();
    }

    @Override
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException {
        return List.of();
    }

    @Override
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        return List.of();
    }
}
