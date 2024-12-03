/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testDAO;

/**
 *
 * @author caarl
 */
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.Cancion;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasIntegracion {

    @Test
    public void testRelacionCancionAlbumArtista() {
        /*
        // Crear un artista
        Artista artista = new Artista(
            "Artista Prueba",
            "Tipo Banda",
            "Descripción del artista",
            "Rock",
            Arrays.asList()
        );
        artista.setId(new ObjectId());

       artista.setId(new ObjectId());

      Album album = new Album(
    new ObjectId(), // Genera el ObjectId
    "Álbum Prueba",
    new Date(),
    "Pop",
    "http://imagen.portada.com/album.jpg",
    Arrays.asList("Canción 1", "Canción 2")
*
);
        album.setId(new ObjectId());
        album.setReferenciaArtista(artista.getId());

        // Crear una canción y relacionarla al álbum
        Cancion cancion = new Cancion("Canción Prueba", album.getId());
        cancion.setIdAlbum(new ObjectId());

        // Verificaciones
        assertEquals("Artista Prueba", artista.getNombreArtista());
        assertEquals("Álbum Prueba", album.getNombre());
        assertEquals(album.getId(), cancion.getIdAlbum());
        assertEquals("http://imagen.portada.com/album.jpg", album.getImagenPortadaUrl());*/
    }
}