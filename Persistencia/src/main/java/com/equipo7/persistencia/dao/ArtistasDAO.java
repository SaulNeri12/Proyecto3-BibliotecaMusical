package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.util.ArrayList;
import org.bson.Document;

import java.util.List;
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ArtistasDAO implements IArtistasDAO {

    private static ArtistasDAO instance;  // Instancia única de la clase ArtistasDAO
    private MongoDatabase bibliotecaMusicalBD;  // Conexión con la base de datos de la biblioteca musical
    private MongoCollection<Artista> artistas;  // Colección de artistas en la base de datos

    /**
     * Constructor privado para la generación de la instancia única. Inicializa
     * la colección de artistas desde la base de datos.
     *
     * @throws ConexionException Si ocurre un error al obtener la colección de
     * artistas.
     */
    private ArtistasDAO() throws ConexionException {
        // Se obtiene la instancia de la conexión a la base de datos
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        // Se obtiene la colección de artistas de la base de datos
        artistas = bibliotecaMusicalBD.getCollection(Artista.NOMBRE_COLLECTION, Artista.class);
    }

    /**
     * Obtiene la instancia única del DAO de artistas. Si la instancia no
     * existe, se crea una nueva.
     *
     * @return Instancia única del DAO de artistas.
     * @throws ConexionException Si ocurre un error al tratar de obtener la
     * instancia.
     */
    public static ArtistasDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new ArtistasDAO();
        }
        return instance;
    }

    @Override
    public List<Artista> obtenerTodos() throws DAOException {
        try {
            return artistas.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los artistas");
        }
    }

    @Override
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException {
        try {
            return artistas.find(Filters.regex("nombreArtista", nombreArtista, "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al obtener los artistas por nombre");
        }
    }

    @Override
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {

        // Convertir el objeto FiltroBusqueda a un filtro BSON utilizando el método toBson() del filtro
        Bson filtro = filtroBusqueda.toBson();

        // Si se ha especificado un patrón de coincidencia para la búsqueda, añadimos ese filtro también
        if (filtroBusqueda.getCoincidenciaBusqueda() != null && !filtroBusqueda.getCoincidenciaBusqueda().isEmpty()) {
            String patronBusqueda = filtroBusqueda.getCoincidenciaBusqueda();
            Bson filtroCoincidencia = Filters.or(
                    Filters.regex("nombre", ".*" + Pattern.quote(patronBusqueda) + ".*", "i"),
                    Filters.regex("albumes.nombre", ".*" + Pattern.quote(patronBusqueda) + ".*", "i"),
                    Filters.regex("albumes.canciones", ".*" + Pattern.quote(patronBusqueda) + ".*", "i")
            );
            filtro = Filters.and(filtro, filtroCoincidencia);  // Combinar los filtros
        }

        // Ejecutar la consulta con el filtro combinado
        List<Artista> artistas = new ArrayList<>();
        FindIterable<Artista> resultado = this.artistas.find(filtro);  // Ejecutar la consulta en la colección de artistas

        for (Artista artista : resultado) {
            artistas.add(artista);  // Agregar los resultados a la lista
        }

        return artistas;
    }

    @Override
    public Artista obtenerPorId(ObjectId id) throws DAOException {
        try {
            return artistas.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al obtener el artista por ID");
        }
    }
}
