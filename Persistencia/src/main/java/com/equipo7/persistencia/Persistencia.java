/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.equipo7.persistencia;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.dao.CancionesDAO;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.dao.interfaces.ICancionesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.equipo7.persistencia.entidades.Integrante;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author neri
 */
public class Persistencia {
    
    public static void main(String[] args) {
        ArtistasDAO artistasDAO = null;
        AlbumesDAO albumesDAO = null;
        try {
            artistasDAO = ArtistasDAO.getInstance();
            albumesDAO = AlbumesDAO.getInstance();
        } catch (ConexionException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        /*
        // KENDRICK LAMAR
        Artista artista = new Artista();
        artista.setNombreArtista("Kendrick Lamar");
        artista.setTipo("Solista");
        artista.setDescripcion("Kendrick Lamar es un rapero, compositor y productor estadounidense, considerado uno de los artistas más influyentes y talentosos de su generación. Nació el 17 de junio de 1987 en Compton, California, un área conocida por su conexión con la cultura del hip-hop y su historia de tensiones sociales.");
        artista.setGeneroMusical("Hip-Hop");
        artista.setImagenURL("https://acortar.link/1ue7Xy");

        try {
            artistasDAO.registrar(artista);

            System.out.println("### id nuevo: %s".formatted(artista.getId().toString()));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        LocalDateTime fechaSalidaAlbum = LocalDateTime.of(2012, 10, 22, 0, 0); // 22 de octubre de 2012 a medianoche
        Instant albumReleaseInstant = fechaSalidaAlbum.toInstant(ZoneOffset.UTC);

        Album album = new Album();
        album.setNombre("m.A.A.d city");
        album.setFechaLanzamiento(albumReleaseInstant);
        album.setReferenciaArtista(artista.getId());
        album.setGeneroMusical(artista.getGeneroMusical());
        album.setImagenPortadaUrl("https://acortar.link/ATDUyY");
        album.setCanciones(Arrays.asList(
                "Sherane a.k.a Master Splinter's Daughter",
                "Bitch, Dont't Kill My Vibe",
                "The Art of Peer Pressure",
                "Money Trees",
                "m.A.A.d city",
                "Sing About Me, I'm Dying Of Thirst"
        ));

        Album album2 = new Album();
        album2.setNombre("Mr. Morale & the Big Steppers");
        album2.setFechaLanzamiento(albumReleaseInstant);
        album2.setReferenciaArtista(artista.getId()); // Requiere que 'artista' esté definido
        album2.setGeneroMusical(artista.getGeneroMusical());
        album2.setImagenPortadaUrl("https://acortar.link/l4jPKv");
        album2.setCanciones(Arrays.asList(
                "United In Grief",
                "N95",
                "Worldwide Steppers",
                "Die Hard",
                "Father Time",
                "Rich Spirit",
                "We Cry Together",
                "Purple Hearts"
        ));

        try {
            albumesDAO.insercionMasiva(Arrays.asList(album, album2));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // MF DOOM
        Artista mfDoom = new Artista();
        mfDoom.setNombreArtista("MF DOOM");
        mfDoom.setTipo("Solista");
        mfDoom.setDescripcion("MF DOOM, nacido como Daniel Dumile, fue un rapero y productor británico-estadounidense conocido por su lírica compleja y su estilo distintivo con máscaras. Fue una figura icónica del hip-hop underground.");
        mfDoom.setGeneroMusical("Hip-Hop");
        mfDoom.setImagenURL("https://acortar.link/CveRjh");

        try {
            artistasDAO.registrar(mfDoom);
            System.out.println("### id nuevo: %s".formatted(mfDoom.getId().toString()));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        Album mfDoomAlbum1 = new Album();
        mfDoomAlbum1.setNombre("Madvillainy");
        mfDoomAlbum1.setFechaLanzamiento(LocalDateTime.of(2004, 3, 23, 0, 0).toInstant(ZoneOffset.UTC));
        mfDoomAlbum1.setReferenciaArtista(mfDoom.getId());
        mfDoomAlbum1.setGeneroMusical(mfDoom.getGeneroMusical());
        mfDoomAlbum1.setImagenPortadaUrl("https://acortar.link/nQfQFR");
        mfDoomAlbum1.setCanciones(Arrays.asList(
                "Accordion", "Meat Grinder", "Figaro", "Fancy Clown", "All Caps"
        ));

        Album mfDoomAlbum2 = new Album();
        mfDoomAlbum2.setNombre("Operation: Doomsday");
        mfDoomAlbum2.setFechaLanzamiento(LocalDateTime.of(1999, 4, 20, 0, 0).toInstant(ZoneOffset.UTC));
        mfDoomAlbum2.setReferenciaArtista(mfDoom.getId());
        mfDoomAlbum2.setGeneroMusical(mfDoom.getGeneroMusical());
        mfDoomAlbum2.setImagenPortadaUrl("https://acortar.link/ikROqx");
        mfDoomAlbum2.setCanciones(Arrays.asList(
                "The Time We Faced Doom (Skit)",
                "Doomsday",
                "Rhymes Like Dimes",
                "The Finest",
                "Go With The Flow",
                "Gas Drawls",
                "?" // Representa una pista secreta o desconocida
        ));

        try {
            albumesDAO.insercionMasiva(Arrays.asList(mfDoomAlbum1, mfDoomAlbum2));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Tyler, the Creator
        Artista tyler = new Artista();
        tyler.setNombreArtista("Tyler, the Creator");
        tyler.setTipo("Solista");
        tyler.setDescripcion("Tyler, the Creator es un rapero, cantante y productor estadounidense. Fundador del colectivo Odd Future, es conocido por su creatividad y experimentación en géneros musicales.");
        tyler.setGeneroMusical("Hip-Hop");
        tyler.setImagenURL("https://acortar.link/lV3kKa");

        try {
            artistasDAO.registrar(tyler);
            System.out.println("### id nuevo: %s".formatted(tyler.getId().toString()));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        Album tylerAlbum1 = new Album();
        tylerAlbum1.setNombre("IGOR");
        tylerAlbum1.setFechaLanzamiento(LocalDateTime.of(2019, 5, 17, 0, 0).toInstant(ZoneOffset.UTC));
        tylerAlbum1.setReferenciaArtista(tyler.getId());
        tylerAlbum1.setGeneroMusical(tyler.getGeneroMusical());
        tylerAlbum1.setImagenPortadaUrl("https://acortar.link/IGOR");
        tylerAlbum1.setCanciones(Arrays.asList(
                "IGOR'S THEME", "EARFQUAKE", "I THINK", "RUNNING OUT OF TIME", "WHAT'S GOOD"
        ));

        // TODO: insertar tyler
        // Crear el artista Bándalos Chinos
        Artista bChinos = new Artista();
        bChinos.setNombreArtista("Bándalos Chinos");
        bChinos.setTipo("Banda");
        bChinos.setDescripcion("Bándalos Chinos es una banda de pop/rock argentina formada en 2009, conocida por su estilo fresco y melódico.");
        bChinos.setGeneroMusical("Pop/Rock");
        bChinos.setImagenURL("https://acortar.link/PyL8NO");
        bChinos.setIntegrantes(Arrays.asList(
                new Integrante("Goyo Degano", "Vocalista", new Date(2009 - 1900, 0, 1), null, true),
                new Integrante("Tomás Verduga", "Guitarra y Voz", new Date(2009 - 1900, 0, 1), null, true),
                new Integrante("Nicolás Rodríguez del Pozo", "Bajo", new Date(2009 - 1900, 0, 1), null, true),
                new Integrante("Matías Verduga", "Batería", new Date(2009 - 1900, 0, 1), null, true),
                new Integrante("Iñaki Colombo", "Guitarra y Teclados", new Date(2009 - 1900, 0, 1), null, true),
                new Integrante("Renzo Montalbano", "Saxofón y Percusión", new Date(2010 - 1900, 0, 1), null, true)
        ));

        try {
            artistasDAO.registrar(bChinos);
            System.out.println("### id nuevo: %s".formatted(bChinos.getId().toString()));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

// Crear el primer álbum
        Album bChinosAlbum1 = new Album();
        bChinosAlbum1.setNombre("Bach");
        bChinosAlbum1.setFechaLanzamiento(LocalDateTime.of(2018, 8, 31, 0, 0).toInstant(ZoneOffset.UTC));
        bChinosAlbum1.setReferenciaArtista(bChinos.getId());
        bChinosAlbum1.setGeneroMusical(bChinos.getGeneroMusical());
        bChinosAlbum1.setImagenPortadaUrl("https://acortar.link/2mH8Kb");
        bChinosAlbum1.setCanciones(Arrays.asList(
                "El Temblor",
                "Demasiado",
                "Vámonos de Viaje",
                "Súper V",
                "Sin Señal",
                "Tu Órbita"
        ));

// Crear el segundo álbum
        Album bChinosAlbum2 = new Album();
        bChinosAlbum2.setNombre("Paranoia Pop");
        bChinosAlbum2.setFechaLanzamiento(LocalDateTime.of(2020, 10, 9, 0, 0).toInstant(ZoneOffset.UTC));
        bChinosAlbum2.setReferenciaArtista(bChinos.getId());
        bChinosAlbum2.setGeneroMusical(bChinos.getGeneroMusical());
        bChinosAlbum2.setImagenPortadaUrl("https://acortar.link/z4WCJc");
        bChinosAlbum2.setCanciones(Arrays.asList(
                "Mi Manera de Ser",
                "Sin Vos No Puedo",
                "La Final",
                "AYNMG",
                "El Ídolo",
                "Algo Nuevo"
        ));

// Registrar los álbumes
        try {
            albumesDAO.insercionMasiva(Arrays.asList(bChinosAlbum1, bChinosAlbum2));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

// Inserción masiva de álbumes
        // obtiene los albumes por el id del artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(artista.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // obtener artistas por nombre
        try {
            System.out.println(artistasDAO.obtenerTodosPorNombre("kendrick"));
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println(albumesDAO.obtenerGenerosMusicales());
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        ICancionesDAO cancionesDAO = null;
        try {
            cancionesDAO = CancionesDAO.getInstance();
        } catch (ConexionException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        try {
            for (Cancion cancion: cancionesDAO.obtenerCancionesPorArtista(new ObjectId("674f5f12f766715b4f3d9aef"))) {
                System.out.println(cancion);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        try {
            for (Cancion cancion : cancionesDAO.obtenerCancionesPorGenero("Pop")) {
                System.out.println(cancion);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
