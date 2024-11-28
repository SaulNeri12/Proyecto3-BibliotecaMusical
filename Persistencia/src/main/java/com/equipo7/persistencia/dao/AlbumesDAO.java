package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IAlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import java.time.Instant;
import java.util.ArrayList;
import org.bson.Document;

import java.util.List;
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
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
        try {
            Bson filtro = Filters.regex("nombre", ".*" + Pattern.quote(nombreAlbum) + ".*", "i");
            Album album = albumes.find(filtro).first();
            return album;
        } catch (Exception e) {
            throw new DAOException("Error al obtener el álbum por nombre");
        }
    }

    @Override
    public List<Album> obtenerTodosPorFiltro(FiltroBusqueda filtroBusqueda) throws DAOException {
        /**
         * TODO: 1. Considerar el nombre del artista: - Si es null, traer todos
         * los álbumes sin importar el nombre del artista.
         *
         * 2. Considerar los géneros restringidos: - Si existen géneros
         * restringidos, omitir esos géneros. - Si no existen géneros
         * restringidos, no omitir ninguno.
         *
         * 3. Considerar el intervalo de fechas: - Filtrar los álbumes dentro
         * del rango de años especificado en el filtro. - Utilizar los años
         * "desde" y "hasta" proporcionados para el filtro de fechas.
         *
         * 4. Considerar solo los géneros mencionados: - Si se especifican
         * géneros, filtrar solo aquellos géneros indicados. - Si no se
         * especifican géneros, mostrar todos los géneros sin restricción.
         *
         * 5. Considerar la coincidencia de búsqueda: - La búsqueda debe
         * coincidir con los nombres de artistas, álbumes y canciones según el
         * patrón proporcionado. - El patrón de búsqueda debe aplicarse a estos
         * tres campos.
         */

        List<Album> albumesEncontrados = new ArrayList<>();

        try {
            // Construcción del filtro de MongoDB (Bson)
            Bson filtro = Filters.empty();

            // 1. Considerar el nombre del artista (si no es null o vacío)
            if (filtroBusqueda.getNombreArtista() != null && !filtroBusqueda.getNombreArtista().isEmpty()) {
                filtro = Filters.and(filtro, Filters.regex("referenciaArtista.nombreArtista", filtroBusqueda.getNombreArtista(), "i"));
            }

            // 2. Considerar los géneros restringidos (si existen)
            if (filtroBusqueda.getGenerosRestringidos() != null && !filtroBusqueda.getGenerosRestringidos().isEmpty()) {
                filtro = Filters.and(filtro, Filters.nin("generoMusical", filtroBusqueda.getGenerosRestringidos()));
            }

            // 3. Considerar el intervalo de fechas (años desde y hasta)
            if (filtroBusqueda.getAnioDesde() > 0) {
                filtro = Filters.and(filtro, Filters.gte("fechaLanzamiento", Instant.parse(filtroBusqueda.getAnioDesde() + "-01-01T00:00:00Z")));
            }
            if (filtroBusqueda.getAnioHasta() > 0) {
                filtro = Filters.and(filtro, Filters.lte("fechaLanzamiento", Instant.parse(filtroBusqueda.getAnioHasta() + "-12-31T23:59:59Z")));
            }

            // 4. Considerar solo los géneros mencionados (si se especifican)
            if (filtroBusqueda.getGeneros() != null && !filtroBusqueda.getGeneros().isEmpty()) {
                filtro = Filters.and(filtro, Filters.in("generoMusical", filtroBusqueda.getGeneros()));
            }

            // 5. Considerar la coincidencia de búsqueda (para artistas, álbumes y canciones)
            if (filtroBusqueda.getCoincidenciaBusqueda() != null && !filtroBusqueda.getCoincidenciaBusqueda().isEmpty()) {
                String patron = filtroBusqueda.getCoincidenciaBusqueda();
                Bson regexCoincidencia = Filters.regex("nombre", patron, "i");  // Filtro para el nombre del álbum
                Bson regexArtista = Filters.regex("referenciaArtista.nombreArtista", patron, "i");  // Filtro para el nombre del artista
                Bson regexCanciones = Filters.regex("canciones", patron, "i");  // Filtro para las canciones

                // Combinamos todos los filtros de coincidencia con "OR"
                filtro = Filters.and(filtro, Filters.or(regexCoincidencia, regexArtista, regexCanciones));
            }

            // Ejecutar la consulta en MongoDB utilizando el filtro compuesto
            FindIterable<Album> resultados = this.albumes.find(filtro);
            for (Album album : resultados) {
                albumesEncontrados.add(album);
            }

        } catch (Exception e) {
            // Manejo de excepciones
            throw new DAOException("Error al obtener los álbumes por filtro");
        }

        return albumesEncontrados;
    }

    @Override
    public List<Album> obtenerTodos() throws DAOException {
        try {
            return albumes.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los álbumes");
        }
    }

    @Override
    public List<Album> obtenerTodosPorArtista(ObjectId idArtista) throws DAOException {
        Bson filtro = Filters.eq("idArtista", idArtista);

        List<Album> resultado = albumes.find(filtro).into(new ArrayList<>());

        return resultado;
    }

    @Override
    public void insercionMasiva() throws DAOException {
        // TODO: 
    }

    @Override
    public Album obtenerPorId(ObjectId id) throws DAOException {
        try {
            return albumes.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los álbumes");
        }
    }
}
