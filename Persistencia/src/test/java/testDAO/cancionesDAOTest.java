/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.CancionesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Cancion;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author gaspa
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class cancionesDAOTest {
    
    private CancionesDAO cancionesDAO;
    private AlbumesDAO albumesDAO;
    
    @BeforeAll
    public void setUp() {
        try {
            cancionesDAO = CancionesDAO.getInstance();
            albumesDAO = AlbumesDAO.getInstance();
            
        } catch (ConexionException e) {
            fail("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    @Test
    void testRegistrarAlbumCancion() throws DAOException{
        Album album = new Album("pulver", new Date(2006), "Narcotic Metal");
        albumesDAO.registrar(album);
        
        ObjectId albumId = album.getId();
        
        Cancion cancion = new Cancion("cancion prueba",albumId);
        cancionesDAO.crearCancion(cancion);
        List<ObjectId> cancionesId = new ArrayList<>();
        cancionesId.add(cancion.getId());
        album.setCanciones(cancionesId);
        
        albumesDAO.actualizar(album);
    }
    @Test
    public void testObtenerCancionPorId() throws DAOException {
        // Crear y agregar una canción a la base de datos
        Album album = new Album("October Rust", new Date(1996), "Doom Metal");
        albumesDAO.registrar(album);
        
        ObjectId albumId = album.getId();
        Cancion cancion = new Cancion("Love You to Death", albumId);
        cancionesDAO.crearCancion(cancion);
        
        List<ObjectId> cancionesId = new ArrayList<>();
        cancionesId.add(cancion.getId());
        album.setCanciones(cancionesId);
        albumesDAO.actualizar(album);
        
        // Obtener la canción por su ID
        ObjectId cancionId = cancion.getId();
        Cancion cancionObtenida = cancionesDAO.obtenerCancionPorId(cancionId);

        assertNotNull(cancionObtenida, "No se pudo obtener la canción por su ID");
        assertEquals(cancionId, cancionObtenida.getId(), "Los IDs de la canción no coinciden");
    }
    @Test
    public void testObtenerCancionesPorAlbum() throws DAOException {
        // Crear un álbum y canciones asociadas
        Album album = new Album("Hypnotize", new Date(2005), "Alternative Metal");
        albumesDAO.registrar(album);
        
        ObjectId albumId = album.getId();
        Cancion cancion1 = new Cancion("Dreaming", albumId);
        Cancion cancion2 = new Cancion("U-Fig", albumId);
        
        cancionesDAO.crearCancion(cancion1);
        cancionesDAO.crearCancion(cancion2);
        
        List<ObjectId> cancionesId = new ArrayList<>();
        cancionesId.add(cancion1.getId());
        cancionesId.add(cancion2.getId());
        album.setCanciones(cancionesId);
        albumesDAO.actualizar(album);
        
        // Obtener las canciones asociadas al álbum
        List<Cancion> cancionesDelAlbum = cancionesDAO.obtenerCancionesPorAlbum(albumId);

        assertNotNull(cancionesDelAlbum, "No se pudieron obtener las canciones del álbum");
        assertTrue(!cancionesDelAlbum.isEmpty(), "No se encontraron canciones para el álbum");
    }
    @Test
    void testObtenerCancionesPorGenero() throws DAOException {
        // Prueba para obtener canciones del género "Pop"
        List<Cancion> cancionesAltMet = cancionesDAO.obtenerCancionesPorGenero("Alternative Metal");

        assertNotNull(cancionesAltMet, "La lista de canciones no debe ser nula.");
        assertEquals(2, cancionesAltMet.size(), "Debe haber 2 canciones con el género Alternative Metal.");
        
        // Verificar que las canciones devueltas pertenecen al álbum con género "Pop"
        for (Cancion cancion : cancionesAltMet) {
            Album album = albumesDAO.obtenerPorId(cancion.getIdAlbum()); // Obtener el álbum asociado
            assertEquals("Alternative Metal", album.getGeneroMusical(), "El género del álbum debe ser Alternative Metal.");
        }

        // Prueba para obtener canciones del género "Rock"
        List<Cancion> cancionesDoom = cancionesDAO.obtenerCancionesPorGenero("Doom Metal");

        assertNotNull(cancionesDoom, "La lista de canciones no debe ser nula.");
        assertEquals(1, cancionesDoom.size(), "Debe haber 1 canción con el género Doom Metal.");
        
        // Verificar que las canciones devueltas pertenecen al álbum con género "Rock"
        for (Cancion cancion : cancionesDoom) {
            Album album = albumesDAO.obtenerPorId(cancion.getIdAlbum());
            assertEquals("Doom Metal", album.getGeneroMusical(), "El género del álbum debe ser Doom Metal.");
        }
    }
    

}
