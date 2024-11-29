/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class artistasDAOTest {
    
    private ArtistasDAO artistasDAO;

    @BeforeAll
    public void setup() {
        try {
            artistasDAO = ArtistasDAO.getInstance();
        } catch (ConexionException e) {
            fail("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    @BeforeEach
    public void prepararDatos() {
        try {
            // Inserta datos de prueba antes de cada test
            Artista artista1 = new Artista();
            artista1.setId(new ObjectId());
            artista1.setNombreArtista("Artista Prueba 1");
            artista1.setGeneroMusical("Pop");
            artista1.setDescripcion("descripcion prueba 1");
            artista1.setTipo("Solista");
            

            Artista artista2 = new Artista();
            artista2.setId(new ObjectId());
            artista2.setId(new ObjectId());
            artista2.setNombreArtista("Artista Prueba 2");
            artista2.setGeneroMusical("Rock");
            artista2.setDescripcion("descripcion prueba 2");
            artista2.setTipo("Solista");

            Artista artista3 = new Artista();
            artista3.setId(new ObjectId());
            artista3.setNombreArtista("Artista Filtrado");
            artista3.setGeneroMusical("Jazz");
            artista3.setDescripcion("Descripcion prueba 3");
            artista3.setTipo("Banda");

            artistasDAO.registrar(artista1);
            artistasDAO.registrar(artista2);
            artistasDAO.registrar(artista3);
        } catch (Exception e) {
            fail("Error al preparar datos de prueba: " + e.getMessage());
        }
    }

    @AfterEach
    public void limpiarDatos() {
        try {
            // Limpia los datos después de cada test
            artistasDAO.deleteMany(new org.bson.Document());
        } catch (Exception e) {
            fail("Error al limpiar datos de prueba: " + e.getMessage());
        }
    }
    
    
    @Test
    @Order(1)
    public void testRegistrarArtista() throws DAOException {

            Artista artista = new Artista();
            artista.setNombreArtista("Nuevo Artista");
            artista.setGeneroMusical("Pop");
            artista.setDescripcion("Argentina");
            artista.setTipo("hola");

            assertDoesNotThrow(() -> artistasDAO.registrar(artista),
                    "No debería lanzar excepciones al registrar un usuario válido");

    }
    
    @Test
    @Order(2)
    public void testObtenerTodos() {
        List<Artista> artistas = artistasDAO.obtenerTodos();
        assertNotNull(artistas, "La lista de artistas no debería ser nula");
        assertTrue(artistas.size() >= 3, "Debería haber al menos tres artistas en la base de datos");
    }
    
    @Test
    @Order(3)
    public void testObtenerPorNombre() {
        List<Artista> artistas = artistasDAO.obtenerTodosPorNombre("Artista Prueba");
        assertNotNull(artistas, "La lista de artistas no debería ser nula");
        assertTrue(artistas.size() >= 2, "Debería haber al menos dos artistas con 'Artista Prueba' en el nombre");
    }

    @Test
    @Order(4)
    public void testObtenerPorId() {
        // Inserta un artista específico para probar el ID
        ObjectId idTest = new ObjectId();
        Artista artista = new Artista();
        artista.setId(idTest);
        artista.setNombreArtista("Artista Específico");
        artista.setGeneroMusical("Clásica");
        artista.setDescripcion("descripcion prueba");
        artista.setTipo("Solista");
        artistasDAO.registrar(artista);
        Artista resultado = artistasDAO.obtener(idTest);
        assertNotNull(resultado, "El artista no debería ser nulo");
        assertEquals("Artista Específico", resultado.getNombreArtista(), "El nombre del artista no coincide");
    }
    
    
    //@Test
    @Order(5)
    public void testObtenerPorFiltro() {
        FiltroBusqueda filtro = new FiltroBusqueda.Builder()
            
            .conGeneros(Arrays.asList("Rock", "Pop"))
            .desdeAnio(2000)
            .hastaAnio(2020)
            .build();
        List<Artista> artistas = artistasDAO.obtenerTodosPorFiltro(filtro);
        assertNotNull(artistas, "La lista de artistas no debería ser nula");
        assertTrue(artistas.size() >= 1, "Debería haber al menos tres artistas en la base de datos");
    }
}
