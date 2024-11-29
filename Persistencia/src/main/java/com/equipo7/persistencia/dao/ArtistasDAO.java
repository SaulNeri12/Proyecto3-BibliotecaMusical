package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
<<<<<<< Updated upstream
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.DAOException;
import org.bson.Document;

import java.util.List;
=======
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import excepciones.DAOException;
import java.util.ArrayList;

import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
>>>>>>> Stashed changes

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
/**
 * La clase ArtistasDAO es responsable de interactuar con la colección de artistas
 * en la base de datos MongoDB. Proporciona métodos para registrar, obtener, actualizar,
 * eliminar y consultar artistas.
 */
public class ArtistasDAO implements IArtistasDAO {
<<<<<<< Updated upstream

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
=======
    private static ArtistasDAO instance;
    private final MongoCollection<Document> collection;

    /**
     * Constructor que obtiene la colección desde la conexión única.
     * @throws ConexionException Si ocurre un error al obtener la conexión.
     */
    public ArtistasDAO() throws ConexionException {
        // Obtiene la base de datos desde la conexión única.
        this.collection = Conexion.getInstance().getBibliotecaMusicalBD().getCollection("artistas");
>>>>>>> Stashed changes
    }
    /**
<<<<<<< Updated upstream
     * Obtiene la instancia única del DAO de artistas.
     * Si la instancia no existe, se crea una nueva.
     *
     * @return Instancia única del DAO de artistas.
     * @throws ConexionException Si ocurre un error al tratar de obtener la instancia.
=======
     * Obtiene la instancia única de ArtistasDAO.
     * Si la instancia no existe, la crea y la devuelve.
     * 
     * @return La instancia única de ArtistasDAO.
     * @throws ConexionException Si ocurre un error al obtener la conexión.
>>>>>>> Stashed changes
     */
    public static ArtistasDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new ArtistasDAO();
        }

        return instance;
    }
    /**
     * Registra un nuevo artista en la base de datos.
     * Convierte el objeto Artista a un documento BSON y lo inserta en la colección de artistas.
     * 
     * @param artista El objeto Artista que se desea registrar.
     * @return El Artista con su ID generado por MongoDB.
     */
    @Override
<<<<<<< Updated upstream
    public List<Artista> obtenerTodos() throws DAOException {
        return List.of();
=======
    public Artista registrar(Artista artista) {
        Document document = artista.toDocument();
        collection.insertOne(document);
        artista.setId(document.getObjectId("_id")); // Asignar el ID generado por MongoDB
        return artista;
>>>>>>> Stashed changes
    }
    /**
     * Obtiene un artista por su ID.
     * Realiza una búsqueda en la base de datos utilizando el ID proporcionado.
     * 
     * @param id El ID del artista a buscar.
     * @return El Artista con el ID especificado, o null si no se encuentra.
     */
    @Override
<<<<<<< Updated upstream
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException {
        return List.of();
=======
    public Artista obtener(ObjectId id) {
        Document doc = collection.find(eq("_id", id)).first();
        if (doc == null) return null;
        return documentToArtista(doc);
>>>>>>> Stashed changes
    }
    /**
     * Obtiene todos los artistas de la base de datos.
     * 
     * @return Una lista de todos los artistas registrados en la base de datos.
     */
    @Override
<<<<<<< Updated upstream
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        return List.of();
=======
    public List<Artista> obtenerTodos() {
        List<Artista> artistas = new ArrayList<>();
        for (Document doc : collection.find()) {
            artistas.add(documentToArtista(doc));
        }
        return artistas;
    }
    
    /**
     * Obtiene todos los artistas cuyo nombre coincida con el filtro proporcionado.
     * La búsqueda es sensible a mayúsculas/minúsculas.
     * 
     * @param nombre El nombre o parte del nombre de los artistas a buscar.
     * @return Lista de artistas que coinciden con el nombre.
     */
    @Override
    public List<Artista> obtenerTodosPorNombre(String nombre) {
        List<Artista> artistas = new ArrayList<>();
        
        
        Document filtro = new Document("nombre", new Document("$regex", nombre).append("$options", "i")); 
        
        // Ejecutar la consulta
        for (Document doc : collection.find(filtro)) {
            // Convertir cada documento a un objeto Artista
            Artista artista = new Artista( 
                doc.getString("nombre"),
                doc.getString("descripcion"),
                doc.getString("tipo"),
                doc.getString("generoMusical"),
                (List<ObjectId>) doc.get("albumes")
            );
            artistas.add(artista);
        }
        
        return artistas;
    }
       
    /**
     * Obtiene todos los artistas que coinciden con el filtro proporcionado.
     *
     * @param filtro El filtro de búsqueda con las condiciones deseadas.
     * @return Lista de artistas que cumplen con el filtro.
     */
    @Override
    public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtro) {
        List<Artista> artistas = new ArrayList<>();

        // Obtener el filtro BSON desde el objeto FiltroBusqueda
        Bson filtroBson = filtro.toBson();

        // Ejecuta la consulta con el filtro generado
        for (Document doc : collection.find(filtroBson)) {
            // Convertir cada documento a un objeto Artista
            Artista artista = new Artista(
                doc.getObjectId("_id"),
                doc.getString("nombreArtista"),
                doc.getString("descripcion"),
                doc.getString("tipo"),
                doc.getString("generoMusical"),
                (List<ObjectId>) doc.get("albumes")
            );
            artistas.add(artista);
        }

        return artistas;
    }

    /**
     * Actualiza un artista en la base de datos.
     * Si el artista tiene un ID asignado, reemplaza el documento existente con los nuevos datos.
     * 
     * @param artista El objeto Artista con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */

    @Override
    public boolean actualizar(Artista artista) {
        if (artista.getId() == null) return false;
        Document updateDocument = artista.toDocument();
        return collection.replaceOne(eq("_id", artista.getId()), updateDocument).getMatchedCount() > 0;
    }
    /**
     * Elimina un artista de la base de datos por su ID.
     * 
     * @param id El ID del artista a eliminar.
     * @return true si el artista fue eliminado, false si no se encontró.
     */

    @Override
    public boolean eliminar(ObjectId id) {
        return collection.deleteOne(eq("_id", id)).getDeletedCount() > 0;
    }
    
   
    /**
     * Elimina los artistas que coincidan con el filtro especificado.
     * 
     * @param filtro El filtro BSON para seleccionar los documentos a eliminar.
     * @return El número de documentos eliminados.
     */
    @Override
    public long deleteMany(Document filtro) {
        // Eliminamos los documentos que coincidan con el filtro
        DeleteResult result = collection.deleteMany(filtro);
        return result.getDeletedCount();  // Retorna el número de documentos eliminados
    }
    /**
     * Convierte un documento BSON en un objeto Artista.
     * 
     * @param doc El documento BSON que representa a un artista.
     * @return El objeto Artista correspondiente al documento BSON.
     */

    private Artista documentToArtista(Document doc) {
        Artista artista = new Artista(doc.getObjectId("_id"));
        artista.setNombreArtista(doc.getString("nombre"));
        artista.setDescripcion(doc.getString("descripcion"));
        artista.setGeneroMusical(doc.getString("generoMusical"));
        artista.setReferenciasAlbumes((List<ObjectId>) doc.get("albumes"));
        artista.setTipo(doc.getString("tipo"));
        return artista;
>>>>>>> Stashed changes
    }
}
