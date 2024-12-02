/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo7.persistencia;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        Artista artista = new Artista();
        artista.setNombreArtista("Kendrick Lamar ");
        artista.setTipo("Solista");
        artista.setDescripcion("Kendrick Lamar es un rapero, compositor y productor estadounidense, considerado uno de los artistas más influyentes y talentosos de su generación. Nació el 17 de junio de 1987 en Compton, California, un área conocida por su conexión con la cultura del hip-hop y su historia de tensiones sociales.");
        artista.setGeneroMusical("Hip-Hop");
        artista.setImagenURL("https://acortar.link/6YxRuK");
        
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
        }
    }
}
