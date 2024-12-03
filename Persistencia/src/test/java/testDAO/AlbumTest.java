/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;
import com.equipo7.persistencia.entidades.Album;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la entidad Album.
 */
public class AlbumTest {

    private Album album;

    @BeforeEach
    void setUp() {
        album = new Album();
    }

    @Test
    void testConstructorVacio() {
        assertNotNull(album.getCanciones());
        assertTrue(album.getCanciones().isEmpty());
        assertNull(album.getId());
        assertNull(album.getNombre());
        assertNull(album.getFechaLanzamiento());
        assertNull(album.getGeneroMusical());
        assertNull(album.getImagenPortadaUrl());
    }

    @Test
    void testConstructorConId() {
        ObjectId id = new ObjectId();
        Album albumConId = new Album(id);
        assertEquals(id, albumConId.getId());
    }

    @Test
    void testConstructorCompleto() {
        ObjectId id = new ObjectId();
        Date fecha = new Date();
        List<String> canciones = Arrays.asList("Canción 1", "Canción 2");
        Album albumCompleto = new Album(id, "Álbum Test", fecha, "Rock", "url_imagen", canciones);

        assertEquals(id, albumCompleto.getId());
        assertEquals("Álbum Test", albumCompleto.getNombre());
        assertEquals(fecha, albumCompleto.getFechaLanzamiento());
        assertEquals("Rock", albumCompleto.getGeneroMusical());
        assertEquals("url_imagen", albumCompleto.getImagenPortadaUrl());
        assertEquals(canciones, albumCompleto.getCanciones());
    }

    @Test
    void testSettersYGetters() {
        ObjectId id = new ObjectId();
        Date fecha = new Date();
        List<String> canciones = new ArrayList<>(Arrays.asList("Canción A", "Canción B"));

        album.setId(id);
        album.setNombre("Álbum Prueba");
        album.setFechaLanzamiento(fecha);
        album.setGeneroMusical("Pop");
        album.setImagenPortadaUrl("url_test");
        album.setCanciones(canciones);

        assertEquals(id, album.getId());
        assertEquals("Álbum Prueba", album.getNombre());
        assertEquals(fecha, album.getFechaLanzamiento());
        assertEquals("Pop", album.getGeneroMusical());
        assertEquals("url_test", album.getImagenPortadaUrl());
        assertEquals(canciones, album.getCanciones());
    }

    @Test
    void testReferenciaArtista() {
        ObjectId artistaId = new ObjectId();
        album.setReferenciaArtista(artistaId);

        assertEquals(artistaId, album.getReferenciaArtista());
    }

    @Test
    void testToString() {
        ObjectId id = new ObjectId();
        Date fecha = new Date();
        List<String> canciones = Arrays.asList("Canción 1", "Canción 2");

        album.setId(id);
        album.setNombre("Álbum de Prueba");
        album.setFechaLanzamiento(fecha);
        album.setGeneroMusical("Jazz");
        album.setImagenPortadaUrl("url_imagen");
        album.setCanciones(canciones);

        String esperado = "Album { " +
                "_id=" + id.toHexString() + ", " +
                "nombre='Álbum de Prueba', " +
                "fechaLanzamiento=" + fecha.toString() + ", " +
                "generoMusical='Jazz', " +
                "imagenPortadaUrl='url_imagen', " +
                "canciones=[Canción 1, Canción 2] }";

        assertEquals(esperado, album.toString());
    }

    @Test
    void testConstructorReferencias() {
        ObjectId artistaId = new ObjectId();
        List<String> canciones = Arrays.asList("Canción 1", "Canción 2");

        Album albumReferencias = new Album("Álbum Referencia", artistaId, "Clásico", "url_portada", canciones);

        assertEquals("Álbum Referencia", albumReferencias.getNombre());
        assertEquals(artistaId, albumReferencias.getReferenciaArtista());
        assertEquals("Clásico", albumReferencias.getGeneroMusical());
        assertEquals("url_portada", albumReferencias.getImagenPortadaUrl());
        assertEquals(canciones, albumReferencias.getCanciones());
    }
}
