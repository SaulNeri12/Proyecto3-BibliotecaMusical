/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class albumesDAOTest {
    /*
    private AlbumesDAO albumesDAO;

    @BeforeAll
    public void setup() {
        try {
            albumesDAO = AlbumesDAO.getInstance();
        } catch (ConexionException e) {
            fail("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    public void testInsertarAlbum() {
        try {
            Album album = new Album();
            
            album.setNombre("Álbum de Prueba");
            album.setGeneroMusical("Pop");
            album.setFechaLanzamiento(new Date());
            album.setReferenciaArtista(new ObjectId("64f9c0e9c0e4f15c2c000001")); // Cambia por un ID válido

            albumesDAO.albumes.insertOne(album); // Inserción directa como ejemplo
        } catch (Exception e) {
            fail("Error al insertar el álbum: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void testObtenerTodos() {
        try {
            List<Album> albumes = albumesDAO.obtenerTodos();
            assertNotNull(albumes, "La lista de álbumes no debería ser nula");
            assertTrue(!albumes.isEmpty(), "Debería haber al menos un álbum en la base de datos");
        } catch (DAOException e) {
            fail("Error al obtener todos los álbumes: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void testObtenerPorId() {
        try {
            ObjectId id = new ObjectId("6749461ca805be570cb473bc"); // Cambia por un ID válido
            Album album = albumesDAO.obtenerPorId(id);
            assertNotNull(album, "El álbum no debería ser nulo");
            assertEquals("Álbum de Prueba", album.getNombre(), "El nombre del álbum no coincide");
        } catch (DAOException e) {
            fail("Error al obtener el álbum por ID: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void testObtenerTodosPorArtista() {
        try {
            ObjectId idArtista = new ObjectId("64f9c0e9c0e4f15c2c000001"); // Cambia por un ID válido
            List<Album> albumes = albumesDAO.obtenerTodosPorArtista(idArtista);
            assertNotNull(albumes, "La lista de álbumes no debería ser nula");
            assertTrue(!albumes.isEmpty(), "Debería haber álbumes asociados al artista");
        } catch (DAOException e) {
            fail("Error al obtener álbumes por artista: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    public void testObtenerTodosPorNombre() {
        try {
            Album album = albumesDAO.obtenerTodosPorNombre("Álbum de Prueba");
            assertNotNull(album, "El álbum no debería ser nulo");
            assertEquals("Álbum de Prueba", album.getNombre(), "El nombre del álbum no coincide");
        } catch (DAOException e) {
            fail("Error al obtener el álbum por nombre: " + e.getMessage());
        }
    }

    @Test
@Order(6)
public void testObtenerTodosPorFiltro() {
    try {
        // Usando el Builder de FiltroBusqueda para configurar los filtros
        FiltroBusqueda filtro = new FiltroBusqueda.Builder()
                .conNombreArtista("Artista de Prueba")   // Filtrar por nombre de artista
                .conGeneros(List.of("Pop", "Rock"))      // Filtrar solo géneros "Pop" y "Rock"
                .desdeAnio(2020)                         // Año de lanzamiento desde 2020
                .hastaAnio(2023)                         // Año de lanzamiento hasta 2023
                .agregarGeneroRestringido("Metal")       // Excluir género "Metal"
                .build();

        // Invocamos el método con el filtro creado
        List<Album> albumes = albumesDAO.obtenerTodosPorFiltro(filtro);

        // Validaciones de los resultados
        assertNotNull(albumes, "La lista de álbumes no debería ser nula");
        assertFalse(albumes.isEmpty(), "Debería haber álbumes que cumplan con el filtro");
        
        // Verificación adicional del contenido
        for (Album album : albumes) {
            assertTrue(album.getGeneroMusical().equalsIgnoreCase("Pop") 
                        || album.getGeneroMusical().equalsIgnoreCase("Rock"), 
                        "El álbum tiene un género que no cumple con el filtro");

            int anioLanzamiento = album.getFechaLanzamiento().getYear(); // Asumiendo que obtienes el año como parte de la fecha
            assertTrue(anioLanzamiento >= 2020 && anioLanzamiento <= 2023, 
                        "El álbum no está dentro del rango de años");
        }
    } catch (DAOException e) {
        fail("Error al obtener álbumes por filtro: " + e.getMessage());
    }
}*/
}
