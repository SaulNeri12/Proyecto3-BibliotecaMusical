package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.result.InsertOneResult;
import excepciones.DAOException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * La clase ArtistasDAO es responsable de interactuar con la colección de
 * artistas en la base de datos MongoDB. Proporciona métodos para registrar,
 * obtener, actualizar, eliminar y consultar artistas.
 */
public class ArtistasDAO implements IArtistasDAO {

    private static ArtistasDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Artista> artistas;

    /**
     * Constructor que obtiene la colección desde la conexión única.
     *
     * Este constructor establece la conexión a la base de datos y obtiene la
     * colección de artistas desde la base de datos utilizando una conexión
     * compartida. Si ocurre un error al obtener la conexión, se lanza una
     * excepción de tipo ConexionException.
     *
     * @throws ConexionException Si ocurre un error al obtener la conexión.
     */
    private ArtistasDAO() {
        try {
            this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
            artistas = bibliotecaMusicalBD.getCollection("artistas", Artista.class);
        } catch (ConexionException ex) {
            System.out.println("### %s".formatted(ex.getMessage()));
        }
    }

    /**
     * Obtiene la instancia única de ArtistasDAO. Si la instancia no existe, la
     * crea y la devuelve.
     *
     * Este método implementa el patrón Singleton, asegurando que solo exista
     * una instancia de ArtistasDAO a lo largo de la aplicación.
     *
     * @return La instancia única de ArtistasDAO.
     * @throws ConexionException Si ocurre un error al obtener la conexión.
     */
    public static ArtistasDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new ArtistasDAO();
        }

        return instance;
    }

    /**
     * Registra un nuevo artista en la base de datos. Convierte el objeto
     * Artista a un documento BSON y lo inserta en la colección de artistas.
     *
     * Este método valida que el artista no sea nulo y que no exista un artista
     * con el mismo nombre en la base de datos. Si el artista ya existe, lanza
     * una excepción DAOException. Si el artista no tiene un ID asignado, lo
     * establece en null antes de la inserción.
     *
     * @param artista El objeto Artista que se desea registrar.
     * @throws DAOException Si ocurre un error durante el registro del artista o
     * si ya existe un artista con el mismo nombre.
     */
    @Override
    public void registrar(Artista artista) throws DAOException {
        if (artista == null) {
            throw new DAOException("No se pudo crear el artista debido a informacion faltante");
        }

        boolean existe = this.artistaExiste(artista.getNombreArtista());
        if (existe) {
            throw new DAOException("Ya existe ese artista, porfavor, escriba un artista diferente");
        }

        // si tiene un ID debe de removerse para no causar conflicto en la insercion
        if (artista.getId() != null) {
            artista.setId(null);
        }

        try {
            InsertOneResult resultado = this.artistas.insertOne(artista);

            if (resultado.getInsertedId() == null) {
                throw new DAOException("No se pudo crear el artista debido a un error, porfavor, intente mas tarde...");
            }

        } catch (MongoException e) {
            throw new DAOException("No se pudo crear el artista debido a un error, porfavor, intente mas tarde...");
        }
        return artista.getId();
    }

    /**
     * Verifica si un artista con el nombre proporcionado ya existe en la base
     * de datos.
     *
     * Este método busca en la colección de artistas para verificar si ya existe
     * un artista con el nombre especificado. Devuelve true si el artista
     * existe, de lo contrario devuelve false.
     *
     * @param nombre El nombre del artista a verificar.
     * @return true si el artista ya existe en la base de datos; false en caso
     * contrario.
     */
    @Override
    public boolean artistaExiste(String nombre) {

        if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
            return false;
        }

        Bson filtroNombre = Filters.eq("nombre", nombre);

        Bson filtro = Filters.or(filtroNombre);

        return this.artistas.find(filtro).first() != null;
    }

    /**
     * Obtiene todos los artistas que coinciden con el filtro proporcionado.
     *
     * Este método permite obtener una lista de artistas que coinciden con los
     * criterios del filtro proporcionado. Si se incluye un patrón de búsqueda,
     * también se filtran los resultados en función de la coincidencia con el
     * nombre, los álbumes o las canciones.
     *
     * @param filtro El filtro de búsqueda con las condiciones deseadas.
     * @return Lista de artistas que cumplen con el filtro.
     * @throws DAOException Si ocurre un error al realizar la consulta.
     */
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
      
    public ObjectId agregarArtistaConAlbum(ObjectId idAlbumInicial, Artista artista) {
        // Agregar el ObjectId del álbum inicial al artista
        artista.getAlbumes().add(idAlbumInicial);
        artistas.insertOne(artista);
        return artista.getId(); // Devolver el ID del artista
    }
      
    /**
     * Convierte un documento de base de datos (MongoDB) en un objeto Artista.
     *
     * Este método transforma un documento BSON (que se obtiene al consultar la
     * base de datos) en un objeto de tipo Artista, extrayendo los valores de
     * los campos y asignándolos a las propiedades correspondientes del objeto.
     *
     * @param document El documento de la base de datos que contiene los datos
     * del artista.
     * @return El objeto Artista correspondiente con los datos extraídos del
     * documento.
     */
    @Override
    public Artista documentoAObjeto(Document document) {
        Artista artista = new Artista();

        // Mapeo del campo _id
        if (document.containsKey("_id")) {
            artista.setId((ObjectId) document.get("_id"));
        }

        // Mapeo del campo nombre
        if (document.containsKey("nombre")) {
            artista.setNombreArtista(document.getString("nombre"));
        }

        // Mapeo del campo correo
        if (document.containsKey("descripcion")) {
            artista.setDescripcion(document.getString("descripcion"));
        }

        // Mapeo del campo contrasena
        if (document.containsKey("tipo")) {
            artista.setTipo(document.getString("tipo"));
        }

        // Mapeo del campo genero
        if (document.containsKey("genero")) {
            artista.setGeneroMusical(document.getString("genero"));
        }

        // Mapeo del campo generosRestringidos (opcional)
        if (document.containsKey("referenciasAlbumes")) {
            List<ObjectId> referenciasAlbumes = (List<ObjectId>) document.get("referenciasAlbumes");
            artista.setAlbumes(referenciasAlbumes);
            // Puedes almacenar esta lista en algún campo de Usuario, si corresponde
        }

        return artista;
    }

    @Override
    public List<Artista> obtenerTodos() throws DAOException {
        try {
            List<Artista> listaArtistas = new ArrayList<>();
            return this.artistas.find().into(listaArtistas);
        } catch (Exception e) {
            throw new DAOException("No se pudo obtener los artistas");
        }
    }

    @Override
    public Artista obtenerPorId(ObjectId id) throws DAOException {
        try {
            return this.artistas.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new DAOException("No se pudo obtener los artistas");
        }
    }

    @Override
    public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException {
        try {
            Bson filtro = Filters.regex("nombre", nombreArtista, "i");
            return this.artistas.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("No se pudo obtener la informacion del artista");
        }
    }

    @Override
    public void insercionMasiva(List<Artista> listaArtistas) throws DAOException {
        try {
            this.artistas.insertMany(listaArtistas, new InsertManyOptions().ordered(false));
        } catch (Exception e) {
            throw new DAOException("Error en la inserción masiva de artistas");
        }
    }
}
