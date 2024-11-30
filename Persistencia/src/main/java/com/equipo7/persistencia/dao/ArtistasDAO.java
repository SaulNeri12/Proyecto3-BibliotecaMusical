package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.util.ArrayList;
import org.bson.Document;

import java.util.List;
import org.bson.types.ObjectId;

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
    public Artista obtenerArtistaPorNombre(String nombreArtista) throws DAOException {
        try {
            Document artistaDoc = this.artistas.find(Filters.eq("nombreArtista", nombreArtista)).first();
            if (artistaDoc != null) {
                return new Artista(
                        artistaDoc.getObjectId("_id"),
                        artistaDoc.getString("nombreArtista"),
                        artistaDoc.getString("descripcion"),
                        artistaDoc.getString("generoMusical"),
                        (List<Album>) artistaDoc.get("albumes")
                );
            }
            return null;
        } catch (Exception e) {
            throw new DAOException("Error al obtener el artista por nombre");
        }
    }

     @Override
public void insertar(Artista artista) throws DAOException {
    try {
        Document artistaDoc = new Document()
                .append("_id", artista.getId())
                .append("nombreArtista", artista.getNombreArtista())
                .append("descripcion", artista.getDescripcion())
                .append("generoMusical", artista.getGeneroMusical())
                .append("albumes", artista.getAlbumes());
        artistas.insertOne(artistaDoc);
    } catch (Exception e) {
        throw new DAOException("Error al insertar el artista");
    }
}

@Override
public Artista obtenerPorId(ObjectId id) throws DAOException {
    try {
        Document artistaDoc = this.artistas.find(Filters.eq("_id", id)).first();
        if (artistaDoc != null) {
            return new Artista(
                    artistaDoc.getObjectId("_id"),
                    artistaDoc.getString("nombreArtista"),
                    artistaDoc.getString("descripcion"),
                    artistaDoc.getString("generoMusical"),
                    artistaDoc.getList("albumes", Album.class) // Casting de álbumes
            );
        }
        return null;
    } catch (Exception e) {
        throw new DAOException("Error al obtener el artista por ID");
    }
}

@Override
public void actualizar(Artista artista) throws DAOException {
    try {
        Document artistaActualizado = new Document()
                .append("nombreArtista", artista.getNombreArtista())
                .append("descripcion", artista.getDescripcion())
                .append("generoMusical", artista.getGeneroMusical())
                .append("albumes", artista.getAlbumes());

        this.artistas.updateOne(Filters.eq("_id", artista.getId()), new Document("$set", artistaActualizado));
    } catch (Exception e) {
        throw new DAOException("Error al actualizar el artista");
    }
}

@Override
public void eliminar(ObjectId id) throws DAOException {
    try {
        this.artistas.deleteOne(Filters.eq("_id", id));
    } catch (Exception e) {
        throw new DAOException("Error al eliminar el artista");
    }
}

@Override
public List<Artista> obtenerTodos() throws DAOException {
    try {
        return this.artistas.find().map(doc -> new Artista(
                doc.getObjectId("_id"),
                doc.getString("nombreArtista"),
                doc.getString("descripcion"),
                doc.getString("generoMusical"),
                doc.getList("albumes", Album.class)
        )).into(new ArrayList<>());
    } catch (Exception e) {
        throw new DAOException("Error al obtener todos los artistas");
    }
}

@Override
public List<Artista> obtenerTodosPorNombre(String nombreArtista) throws DAOException {
    try {
        return this.artistas.find(Filters.regex("nombreArtista", nombreArtista, "i"))
                .map(doc -> new Artista(
                        doc.getObjectId("_id"),
                        doc.getString("nombreArtista"),
                        doc.getString("descripcion"),
                        doc.getString("generoMusical"),
                        doc.getList("albumes", Album.class)
                )).into(new ArrayList<>());
    } catch (Exception e) {
        throw new DAOException("Error al obtener artistas por nombre");
    }
}

@Override
public List<Artista> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
    try {
        Document filtro = new Document();
        if (filtroBusqueda.getNombreArtista() != null) {
            filtro.append("nombreArtista", new Document("$regex", filtroBusqueda.getNombreArtista()).append("$options", "i"));
        }
        if (filtroBusqueda.getGeneros() != null) {
            filtro.append("generoMusical", filtroBusqueda.getGeneros());
        }
        return this.artistas.find(filtro)
                .map(doc -> new Artista(
                        doc.getObjectId("_id"),
                        doc.getString("nombreArtista"),
                        doc.getString("descripcion"),
                        doc.getString("generoMusical"),
                        doc.getList("albumes", Album.class)
                )).into(new ArrayList<>());
    } catch (Exception e) {
        throw new DAOException("Error al obtener artistas por filtro");
    }
}

}
