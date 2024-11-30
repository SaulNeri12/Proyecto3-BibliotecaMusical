package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.time.Instant;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Implementa los metodos de la interfaz IAlbumesDAO para proveer la funcionalidad
 * de la misma
 * @author Saul Neri
 */
public class AlbumesDAO implements IAlbumesDAO {
    private static ArtistasDAO instanceA;
    private static AlbumesDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Document> albumes;

    /**
     * Constructor privado para generacion de instancia unica
     * @throws ConexionException Si ocurre un error al obtener la coleccion de albumes
     */
    private AlbumesDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        this.albumes = bibliotecaMusicalBD.getCollection(Album.NOMBRE_COLLECTION);
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
        try {
            Document albumDoc = this.albumes.find(Filters.eq("nombre", nombreAlbum)).first();
            if (albumDoc != null) {
                return new Album(
                        albumDoc.getObjectId("_id"),
                        albumDoc.getString("nombre"),
                        albumDoc.getDate("fechaLanzamiento").toInstant(),
                        albumDoc.getString("generoMusical"),
                        albumDoc.getString("imagenPortadaUrl"),
                        (List<String>) albumDoc.get("canciones")
                );
            }
            return null;
        } catch (Exception e) {
            throw new DAOException("Error al obtener el álbum por nombre");
        }
    }

    @Override
    public List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        try {
            List<Album> albumes = new ArrayList<>();
            FindIterable<Document> documentos = this.albumes.find();

            if (filtroBusqueda.getNombreArtista() != null && !filtroBusqueda.getNombreArtista().isEmpty()) {
                documentos = documentos.filter(Filters.text(filtroBusqueda.getNombreArtista()));
            }

            if (filtroBusqueda.getAnioDesde() > 0) {
                documentos = documentos.filter(Filters.gte("fechaLanzamiento", filtroBusqueda.getAnioDesde()));
            }

            if (filtroBusqueda.getAnioHasta() > 0) {
                documentos = documentos.filter(Filters.lte("fechaLanzamiento", filtroBusqueda.getAnioHasta()));
            }

            if (!filtroBusqueda.getGeneros().isEmpty()) {
                documentos = documentos.filter(Filters.in("generoMusical", filtroBusqueda.getGeneros()));
            }

            for (Document doc : documentos) {
                albumes.add(new Album(
                        doc.getObjectId("_id"),
                        doc.getString("nombre"),
                        doc.getDate("fechaLanzamiento").toInstant(),
                        doc.getString("generoMusical"),
                        doc.getString("imagenPortadaUrl"),
                        (List<String>) doc.get("canciones")
                ));
            }

            return albumes;
        } catch (Exception e) {
            throw new DAOException("Error al obtener los álbumes por filtro");
        }
    }

    @Override
    public List<Album> obtenerTodos() throws DAOException {
        try {
            List<Album> albumes = new ArrayList<>();
            for (Document doc : this.albumes.find()) {
                albumes.add(new Album(
                        doc.getObjectId("_id"),
                        doc.getString("nombre"),
                        doc.getDate("fechaLanzamiento").toInstant(),
                        doc.getString("generoMusical"),
                        doc.getString("imagenPortadaUrl"),
                        (List<String>) doc.get("canciones")
                ));
            }
            return albumes;
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los álbumes");
        }
    }

    @Override
public List<Album> obtenerTodosPorArtista(String nombreArtista) throws DAOException {
    try {
        List<Album> albumes = new ArrayList<>();

        // buscar al artista por su nombre
        Artista artista = ArtistasDAO.getInstance().obtenerArtistaPorNombre(nombreArtista);
        if (artista == null) {
            return albumes; // Si no se encuentra el artista, devolver lista vacía
        }

        // Obtener los álbumes asociados al artista
        for (Album albumId : artista.getAlbumes()) {
            Album album = this.obtenerAlbumPorId(albumId);
            if (album != null) {
                albumes.add(album);
            }
        }

        return albumes;
    } catch (Exception e) {
        throw new DAOException("Error al obtener los álbumes por artista");
    }
}

private Album obtenerAlbumPorId(Album id) {
    try {
        Document albumDoc = this.albumes.find(Filters.eq("_id", id)).first();
        if (albumDoc != null) {
            return new Album(
                    albumDoc.getObjectId("_id"),
                    albumDoc.getString("nombre"),
                    albumDoc.getDate("fechaLanzamiento").toInstant(),
                    albumDoc.getString("generoMusical"),
                    albumDoc.getString("imagenPortadaUrl"),
                    (List<String>) albumDoc.get("canciones")
            );
        }
        return null;
    } catch (Exception e) {
        throw new RuntimeException("Error al obtener el álbum por ID", e);
    }
}
    @Override
public void insercionMasiva() throws DAOException {
    try {
        // Crear 10 nuevos álbumes de ejemplo
        List<Album> albumsToInsert = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Album album = new Album(
                    new ObjectId(),
                    "Álbum " + i,
                    Instant.now(),
                    "Género Musical " + i,
                    "https://example.com/album-cover-" + i + ".jpg",
                    List.of("Canción " + i + ".1", "Canción " + i + ".2", "Canción " + i + ".3")
            );
            albumsToInsert.add(album);
        }

        // Insertar los nuevos álbumes en la base de datos
        for (Album album : albumsToInsert) {
            Document albumDoc = album.toDocument();
            this.albumes.insertOne(albumDoc);
        }

        System.out.println("Inserción masiva de 10 álbumes completada.");
    } catch (Exception e) {
        throw new DAOException("Error al realizar la inserción masiva de álbumes");
    }
}
}
