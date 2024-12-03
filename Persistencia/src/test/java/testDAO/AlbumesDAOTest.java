/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

/**
 *
 * @author caarl
 */


import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlbumesDAOTest {

    /*
    private AlbumesDAO albumesDAO;

    @BeforeAll
    public void setup() throws DAOException {
        try {
            albumesDAO = AlbumesDAO.getInstance();
        } catch (Exception e) {
            fail("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    @BeforeEach
    void limpiarBaseDeDatos() throws DAOException, ConexionException {
        // Limpiar la colección de álbumes antes de cada prueba
        Conexion.getInstance().getBibliotecaMusicalBD()
                .getCollection("albumes")
                .deleteMany(new org.bson.Document());
    }

    @Test
    void testRegistrarAlbum() throws DAOException {
        Album album = new Album("Álbum de prueba", new Date(), "Pop", Arrays.asList("Canción 1", "Canción 2"));
        assertDoesNotThrow(() -> albumesDAO.registrar(album),
                "No debería lanzar excepciones al registrar un álbum válido");
    }

    @Test
    void testRegistrarAlbumDuplicado() throws DAOException {
        Album album = new Album("Álbum duplicado", new Date(), "Rock", Arrays.asList("Canción A", "Canción B"));
        albumesDAO.registrar(album);
        // Intentamos registrar el mismo álbum de nuevo
        assertThrows(DAOException.class, () -> albumesDAO.registrar(album), 
                "No debería permitir registrar álbumes duplicados");
    }

    @Test
    void testObtenerTodosLosAlbumes() throws DAOException {
        Album album1 = new Album("Álbum 1", new Date(), "Pop", Arrays.asList("Canción 1", "Canción 2"));
        Album album2 = new Album("Álbum 2", new Date(), "Rock", Arrays.asList("Canción 3", "Canción 4"));
        albumesDAO.registrar(album1);
        albumesDAO.registrar(album2);

        List<Album> albumes = albumesDAO.obtenerTodos();
        assertNotNull(albumes);
        assertTrue(albumes.size() >= 2, "Debería haber al menos 2 álbumes registrados");
    }

    @Test
    void testObtenerAlbumPorNombre() throws DAOException {
        Album album = new Album("Álbum de búsqueda", new Date(), "Jazz", Arrays.asList("Canción X", "Canción Y"));
        albumesDAO.registrar(album);

        List<Album> albumesEncontrados = albumesDAO.obtenerTodosPorNombre("Álbum de búsqueda");
        assertNotNull(albumesEncontrados);
        assertEquals(1, albumesEncontrados.size(), "Debería haber 1 álbum con ese nombre");
        assertEquals("Álbum de búsqueda", albumesEncontrados.get(0).getNombre(), "El nombre del álbum debería coincidir");
    }

    

    @Test
    void testInsercionMasiva() throws DAOException {
        Album album1 = new Album("Álbum 1 masivo", new Date(), "Pop", Arrays.asList("Canción X", "Canción Y"));
        Album album2 = new Album("Álbum 2 masivo", new Date(), "Rock", Arrays.asList("Canción Z", "Canción W"));
        
        List<Album> albumes = Arrays.asList(album1, album2);
        assertDoesNotThrow(() -> albumesDAO.insercionMasiva(albumes), 
                "No debería lanzar excepciones al realizar inserción masiva");
    }

    @Test
    void testObtenerAlbumPorArtista() throws DAOException {
        Album album = new Album("Álbum Artista", new Date(), "Pop", Arrays.asList("Canción 1", "Canción 2"));
        album.setReferenciaArtista(new ObjectId()); // Asumimos que se asigna el ID del artista
        albumesDAO.registrar(album);

        List<Album> albumesPorArtista = albumesDAO.obtenerTodosPorArtista("Artista Ejemplo");
        assertNotNull(albumesPorArtista);
        assertTrue(albumesPorArtista.size() >= 1, "Debería haber al menos un álbum relacionado con el artista");
    }*/
}

