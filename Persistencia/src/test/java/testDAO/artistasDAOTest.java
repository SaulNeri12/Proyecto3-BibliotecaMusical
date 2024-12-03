/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class artistasDAOTest {
    
    /*
    private ArtistasDAO artistasDAO;
    private AlbumesDAO albumesDAO;

    @BeforeAll
    public void setup() throws DAOException {
        try {
            artistasDAO = ArtistasDAO.getInstance();
            albumesDAO = AlbumesDAO.getInstance();
        } catch (ConexionException e) {
            fail("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    @BeforeEach
    void limpiarBaseDeDatos() throws DAOException, ConexionException {
        
        // Limpiar todos los usuarios antes de cada prueba
        Conexion.getInstance().getBibliotecaMusicalBD()
                .getCollection("artistas")
                .deleteMany(new org.bson.Document());

    }
    @Test
    void testRegistrarUsuario() throws DAOException {
        Artista artista = new Artista("artista prueba", "prueba", "pruebaaa", "hola");

        assertDoesNotThrow(() -> artistasDAO.registrar(artista),
                "No debería lanzar excepciones al registrar un artista válido");
    }

    @Test
    public void testRegistrarArtistaDuplicado() {
        Artista artista = new Artista();
        artista.setNombreArtista("Juan");

        assertThrows(DAOException.class, () -> {
            artistasDAO.registrar(artista);
            artistasDAO.registrar(artista); // Segundo intento debería fallar
        });
    }
    @Test
    void testArtistaExiste() throws DAOException {
        // Registrar un artista
        Artista artista = new Artista();
        artista.setNombreArtista("TestArtist");
        artista.setDescripcion("Un artista de prueba");
        artista.setTipo("Cantante");
        artista.setGeneroMusical("Pop");

        artistasDAO.registrar(artista);

        // Verificar si el artista existe
        boolean existe = artistasDAO.artistaExiste("TestArtist");
        assertTrue(existe, "El artista debería existir en la base de datos");

        // Verificar si un artista inexistente no existe
        boolean noExiste = artistasDAO.artistaExiste("NonExistentArtist");
        assertFalse(noExiste, "El artista no debería existir en la base de datos");
    }
    //@Test
    void testObtenerArtistasPorFiltro() throws DAOException {
        Artista artista1 = new Artista();
        artista1.setNombreArtista("TestArtist1");
        artista1.setDescripcion("Descripción del artista 1");
        artista1.setGeneroMusical("Pop");
        artistasDAO.registrar(artista1);

        Artista artista2 = new Artista();
        artista2.setNombreArtista("TestArtist2");
        artista2.setDescripcion("Descripción del artista 2");
        artista2.setGeneroMusical("Rock");
        artistasDAO.registrar(artista2);

        // Crear un filtro para obtener artistas de género "Pop"
        FiltroBusqueda filtro = new FiltroBusqueda.Builder()
                .conGeneros(Arrays.asList("Pop"))
                .hastaAnio(2020)
                .build();

        List<Artista> artistas = artistasDAO.obtenerTodosPorFiltro(filtro);
        assertEquals(1, artistas.size(), "Debería haber 1 artista con género Pop");
        assertEquals("TestArtist1", artistas.get(0).getNombreArtista(), "El nombre del artista debería coincidir");
    }
    @Test
    void testDocumentoAObjeto() {
        // Crear un documento BSON de ejemplo
        org.bson.Document document = new org.bson.Document();
        document.append("_id", new ObjectId());
        document.append("nombre", "TestArtist");
        document.append("descripcion", "Un artista de prueba");
        document.append("tipo", "Cantante");
        document.append("genero", "Pop");
        document.append("referenciasAlbumes", List.of(new ObjectId()));

        // Convertir el documento a un objeto Artista
        Artista artista = artistasDAO.documentoAObjeto(document);

        assertNotNull(artista, "El artista no debería ser nulo");
        assertEquals("TestArtist", artista.getNombreArtista(), "El nombre del artista debería ser 'TestArtist'");
        assertEquals("Un artista de prueba", artista.getDescripcion(), "La descripción del artista debería ser correcta");
        assertEquals("Cantante", artista.getTipo(), "El tipo del artista debería ser 'Cantante'");
        assertEquals("Pop", artista.getGeneroMusical(), "El género del artista debería ser 'Pop'");
    }
    @Test
    void agregarArtistaConAlbum() throws DAOException{
        // 1. Generar un ObjectId para el álbum inicial
        ObjectId idAlbumInicial = new ObjectId();
        // 2. Crear un artista con el ObjectId del álbum inicial
        Artista nuevoArtista = new Artista(
                new ObjectId(),
                "The Black Eyed Peas", 
                "he Black Eyed Peas are an American musical group from Los Angeles", 
                "Banda",
                "Pop", 
                List.of(idAlbumInicial));
        ObjectId idArtista = artistasDAO.registrar(nuevoArtista);
        // 3. Crear el álbum utilizando el ObjectId previamente generado
        Album nuevoAlbum = new Album(
                idAlbumInicial, 
                "THE E.N.D.(THE ENERGY NEVER DIES)", 
                new Date(2009),
                idArtista,
                "Pop", 
                "", 
                List.of("Boom Boom Pow","Meet Me Halfway","Imma Be","I Gotta Feeling","Alive","Rock That Body"));
        albumesDAO.registrar(nuevoAlbum);
        
    }
    
    
*/
}
