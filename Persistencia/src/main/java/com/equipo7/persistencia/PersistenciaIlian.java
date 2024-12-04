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
public class PersistenciaIlian {

    public static void main(String[] args) {
        ArtistasDAO artistasDAO = null;
        AlbumesDAO albumesDAO = null;
        try {
            artistasDAO = ArtistasDAO.getInstance();
            albumesDAO = AlbumesDAO.getInstance();
        } catch (ConexionException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        // Artista: Malice Mizer
        Artista maliceMizer = new Artista();
        maliceMizer.setNombreArtista("Malice Mizer");
        maliceMizer.setTipo("Banda");
        maliceMizer.setDescripcion("Malice Mizer (estilizado como MALICE MIZER) fue una banda japonesa de visual kei rock activa desde 1992 hasta 2001. La banda era notable por su música y sus espectáculos en vivo, con lujosos trajes históricos y escenografías, breves piezas de teatro mudo que preludiaban varias canciones.");
        maliceMizer.setGeneroMusical("Gothic Rock");
        maliceMizer.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/e0f77bc587924d9b8585f85101437956.jpg");
        maliceMizer.setIntegrantes(Arrays.asList(
                new Integrante("Mana", "Guitarra, teclados, sintetizadores, percusión", new Date(1992), new Date(2018), false),
                new Integrante("Közi", "guitarra, teclados, sintetizadores, percusión, coros, violonchelo ocasional", new Date(1992), new Date(2018), false),
                new Integrante("Gaz", "bajo, contrabajo, percusión", new Date(1992), new Date(2018), false),
                new Integrante("Mana", "Tambores", new Date(1992), new Date(1993), false),
                new Integrante("Tetsu", "voz principal, guitarra ocasional", new Date(1992), new Date(1994), false),
                new Integrante("Kami", "Tambores", new Date(1993), new Date(1999), false),
                new Integrante("Gackt", "Voz principal, piano", new Date(1995), new Date(1999), false),
                new Integrante("Klaha", "Voz principal", new Date(2000), new Date(2001), false)
        ));


        // Crear álbumes
        Album Memoire = new Album(new ObjectId());
        Album VoyageSansRetour = new Album(new ObjectId());
        Album Merveilles = new Album(new ObjectId());
        Album BaraNoSeidou = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Memoire.setNombre("Mémoire");
        Memoire.setFechaLanzamiento(LocalDateTime.of(1994, 8, 24, 0, 0).toInstant(ZoneOffset.UTC));
        Memoire.setGeneroMusical(maliceMizer.getGeneroMusical());
        Memoire.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/01/MemoireMM.jpg");
        Memoire.setCanciones(Arrays.asList(
                "De Mémoire", "Kioku to Sora", "Ēge Umi ni Sasagu", "Gogo no Sasayaki",
                "Miwaku no Rooma", "Seraph", "Baroque"
        ));

        VoyageSansRetour.setNombre("Voyage Sans Retour");
        VoyageSansRetour.setFechaLanzamiento(LocalDateTime.of(1996, 7, 9, 0, 0).toInstant(ZoneOffset.UTC));
        VoyageSansRetour.setGeneroMusical(maliceMizer.getGeneroMusical());
        VoyageSansRetour.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/49/VoyageSansRetour.jpg");
        VoyageSansRetour.setCanciones(Arrays.asList(
                "Yami no Kanata e~", "Transylvania", "Tsuioku no Kakera", "Premier Amour",
                "Itsuwari no Musette", "N.p.s N.g.s", "Claire ~Tsuki no Shirabe~",
                "Madrigal", "Shi no Butō", "~Zenchō~"
        ));

        Merveilles.setNombre("Merveilles");
        Merveilles.setFechaLanzamiento(LocalDateTime.of(1998, 3, 18, 0, 0).toInstant(ZoneOffset.UTC));
        Merveilles.setGeneroMusical(maliceMizer.getGeneroMusical());
        Merveilles.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/9133c519feb9bbd83cb701fe503c9734.jpg");
        Merveilles.setCanciones(Arrays.asList(
                "Syunikiss ~Nidome no Aitou~", "Bel Air", "Illuminati", "Brise",
                "Eege ~Sugisarishi Kaze to Tomoni~", "Au Revoir", "Ju te veux",
                "S-Conscious", "Le Ciel", "Gekka no Yasoukyoku", "Bois de Merveilles"
        ));

        BaraNoSeidou.setNombre("Bara no Seidou");
        BaraNoSeidou.setFechaLanzamiento(LocalDateTime.of(2000, 8, 23, 0, 0).toInstant(ZoneOffset.UTC));
        BaraNoSeidou.setGeneroMusical(maliceMizer.getGeneroMusical());
        BaraNoSeidou.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/9a6f5ccc6690a095473d01861dc57cc7.jpg");
        BaraNoSeidou.setCanciones(Arrays.asList(
                "Seinaru toki eien no inori", "Kyomu no naka de no yuugi",
                "Mayonaka ni kawashita yakusoku", "Chinurareta kajitsu",
                "Kagami no butougen ~narration~", "Shiroi hada ni kuruu ai to kanashimi no rondo",
                "Kyomu no naka de no yuugi ~narration~", "Hakuchuumu", "Bara no seidou",
                "Saikai no chi to bara"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            maliceMizer.setAlbumes(Arrays.asList(
                    Memoire.getId(), VoyageSansRetour.getId(),
                    Merveilles.getId(), BaraNoSeidou.getId()
            ));
            artistasDAO.registrar(maliceMizer);
            System.out.println("### ID nuevo del artista: " + maliceMizer.getId());

            // Registrar los álbumes en la base de datos
            Memoire.setReferenciaArtista(maliceMizer.getId());
            VoyageSansRetour.setReferenciaArtista(maliceMizer.getId());
            Merveilles.setReferenciaArtista(maliceMizer.getId());
            BaraNoSeidou.setReferenciaArtista(maliceMizer.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Memoire, VoyageSansRetour, Merveilles, BaraNoSeidou));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(maliceMizer.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    // Artista: Julie
        Artista julie = new Artista();
        julie.setNombreArtista("Julie");
        julie.setTipo("Banda");
        julie.setDescripcion("Julie es una banda emergente de rock alternativo y pop, reconocida por su sonido único y letras profundas.");
        julie.setGeneroMusical("Shoegaze");
        julie.setImagenURL("https://th.bing.com/th/id/OIP.1jPejJKAKMyYrTiqZ8OYkwHaHa?w=1000&h=1000&rs=1&pid=ImgDetMain");

        // Agregar integrantes reales
        julie.setIntegrantes(Arrays.asList(
            new Integrante("Keyan Pourzand", "Voz, Guitarra", new Date(2019), null, true),
            new Integrante("Alex Brady", "Voz, bajo", new Date(2019), null, true),
            new Integrante("Dillon Lee", "Bateria", new Date(2019), null, true)
        ));

        // Crear álbumes reales
        Album PushingDaisies = new Album(new ObjectId());
        Album MyAntiAircraftFriend = new Album(new ObjectId());

        // Configurar datos del álbum Echoes of Julie
        PushingDaisies.setNombre("Pushing daisies");
        PushingDaisies.setFechaLanzamiento(LocalDateTime.of(2021, 8, 12, 0, 0).toInstant(ZoneOffset.UTC));
        PushingDaisies.setGeneroMusical(julie.getGeneroMusical());
        PushingDaisies.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/fea086e4992bf799f708ffd9803310ae.jpg");
        PushingDaisies.setCanciones(Arrays.asList(
                "april's-bloom", "Lochness", "Skipping tiles"
        ));

        // Configurar datos del álbum Sounds of Silence
        MyAntiAircraftFriend.setNombre("my anti-aircraft friend");
        MyAntiAircraftFriend.setFechaLanzamiento(LocalDateTime.of(2024, 9, 13, 0, 0).toInstant(ZoneOffset.UTC));
        MyAntiAircraftFriend.setGeneroMusical(julie.getGeneroMusical());
        MyAntiAircraftFriend.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/def68d94aae8e52ef2d1c0c9d3e16ff4.jpg");
        MyAntiAircraftFriend.setCanciones(Arrays.asList(
                "Catalogue", "Very little effort", "Clairbourne practice"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            julie.setAlbumes(Arrays.asList(PushingDaisies.getId(), MyAntiAircraftFriend.getId()));
            artistasDAO.registrar(julie);
            System.out.println("### ID nuevo del artista Julie: " + julie.getId());

            // Registrar los álbumes en la base de datos
            PushingDaisies.setReferenciaArtista(julie.getId());
            MyAntiAircraftFriend.setReferenciaArtista(julie.getId());
            albumesDAO.insercionMasiva(Arrays.asList(PushingDaisies, MyAntiAircraftFriend));
            System.out.println("Álbumes de Julie registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(julie.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Artista: Lifelover
        Artista lifelover = new Artista();
        lifelover.setNombreArtista("Lifelover");
        lifelover.setTipo("Banda");
        lifelover.setDescripcion("Lifelover fue una banda sueca de depressive rock/black metal activa entre 2005 y 2011. Conocida por su estilo único que mezcla black metal, post-punk y letras introspectivas.");
        lifelover.setGeneroMusical("Depressive Rock/Black Metal");
        lifelover.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/e7a9c9241482ad79e3e554e2f86ae0da.jpg");

        // Agregar integrantes reales
        lifelover.setIntegrantes(Arrays.asList(
            new Integrante("Kim Carlsson (Kim)", "Vocalista", new Date(2005 - 1900, 0, 1), new Date(2011 - 1900, 8, 16), false),
            new Integrante("Jonas Bergqvist (B)", "Guitarrista, Vocalista y Teclados", new Date(2005 - 1900, 0, 1), null, false),
            new Integrante("Felix Stenhammar (Fix)", "Bajista y Guitarrista", new Date(2008 - 1900, 0, 1), null, false),
            new Integrante("Henrik Huldtgren (H.)", "Batería", new Date(2009 - 1900, 0, 1), null, false)
        ));

        // Crear álbumes reales
        Album Pulver = new Album(new ObjectId());
        Album Konkurs = new Album(new ObjectId());

        // Configurar datos del álbum Pulver
        Pulver.setNombre("Pulver");
        Pulver.setFechaLanzamiento(LocalDateTime.of(2006, 7, 1, 0, 0).toInstant(ZoneOffset.UTC));
        Pulver.setGeneroMusical(lifelover.getGeneroMusical());
        Pulver.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/f9fe65d88d91473aad49f2d666813390.jpg");
        Pulver.setCanciones(Arrays.asList(
                "Nackskott", "M/S Salmonella", "Mitt Annexia", 
                "Dödens Landsväg", "Stockholm", "En Sång Om Dig"
        ));

        // Configurar datos del álbum Konkurs
        Konkurs.setNombre("Konkurs");
        Konkurs.setFechaLanzamiento(LocalDateTime.of(2008, 10, 10, 0, 0).toInstant(ZoneOffset.UTC));
        Konkurs.setGeneroMusical(lifelover.getGeneroMusical());
        Konkurs.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/d2e8cc6713ee2fd861936bc0fb81deab.jpg");
        Konkurs.setCanciones(Arrays.asList(
                "Shallow", "Mental Central Dialog", "Myspys", 
                "Major Fuck Off", "Androider", "Neråtgång"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            lifelover.setAlbumes(Arrays.asList(Pulver.getId(), Konkurs.getId()));
            artistasDAO.registrar(lifelover);
            System.out.println("### ID nuevo del artista Lifelover: " + lifelover.getId());

            // Registrar los álbumes en la base de datos
            Pulver.setReferenciaArtista(lifelover.getId());
            Konkurs.setReferenciaArtista(lifelover.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Pulver, Konkurs));
            System.out.println("Álbumes de Lifelover registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(lifelover.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Grausamkeit
        Artista grausamkeit = new Artista();
        grausamkeit.setNombreArtista("Grausamkeit");
        grausamkeit.setTipo("Banda");
        grausamkeit.setDescripcion("Grausamkeit es un proyecto aleman de black metal fundado en 1994. Es conocido por su estilo crudo y su influencia en el subgénero de raw black metal.");
        grausamkeit.setGeneroMusical("Raw Black Metal");
        grausamkeit.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/61c866fa0e76b730a4f783958a316cb5.jpg");

        // Crear álbumes representativos
        Album MisanthropicPropaganda = new Album(new ObjectId());
        Album SatanicLegions = new Album(new ObjectId());

        // Configurar datos del álbum Misanthropic Propaganda
        MisanthropicPropaganda.setNombre("Misanthropic Propaganda");
        MisanthropicPropaganda.setFechaLanzamiento(LocalDateTime.of(1999, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        MisanthropicPropaganda.setGeneroMusical(grausamkeit.getGeneroMusical());
        MisanthropicPropaganda.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/c49c23bb6bc24da31c5b7ffa5b2febf7.jpg");
        MisanthropicPropaganda.setCanciones(Arrays.asList(
                "Eternal Darkness", "Infernal Hate", "Black Metal War", 
                "The Age of Despair", "Wrath of the Beast"
        ));

        // Configurar datos del álbum Satanic Legions
        SatanicLegions.setNombre("Satanic Legions");
        SatanicLegions.setFechaLanzamiento(LocalDateTime.of(2000, 5, 5, 0, 0).toInstant(ZoneOffset.UTC));
        SatanicLegions.setGeneroMusical(grausamkeit.getGeneroMusical());
        SatanicLegions.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/0bd196f5719d0ea67fc8b0d4155b842a.jpg");
        SatanicLegions.setCanciones(Arrays.asList(
                "Satan's Wrath", "Blackened Flames", "Destruction and Chaos", 
                "Unholy Prophecies", "Hymn to the End"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            grausamkeit.setAlbumes(Arrays.asList(MisanthropicPropaganda.getId(), SatanicLegions.getId()));
            artistasDAO.registrar(grausamkeit);
            System.out.println("### ID nuevo del artista Grausamkeit: " + grausamkeit.getId());

            // Registrar los álbumes en la base de datos
            MisanthropicPropaganda.setReferenciaArtista(grausamkeit.getId());
            SatanicLegions.setReferenciaArtista(grausamkeit.getId());
            albumesDAO.insercionMasiva(Arrays.asList(MisanthropicPropaganda, SatanicLegions));
            System.out.println("Álbumes de Grausamkeit registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(grausamkeit.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: The Frozen Autumn
        Artista theFrozenAutumn = new Artista();
        theFrozenAutumn.setNombreArtista("The Frozen Autumn");
        theFrozenAutumn.setTipo("Dúo");
        theFrozenAutumn.setDescripcion("The Frozen Autumn es una banda italiana de darkwave y electro-goth formada en 1993. Es conocida por su estilo melancólico y etéreo.");
        theFrozenAutumn.setGeneroMusical("Darkwave");
        theFrozenAutumn.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/301eaa6d153a4f6cb05a2be9b9abf05d.jpg");

        // Agregar integrantes
        theFrozenAutumn.setIntegrantes(Arrays.asList(
            new Integrante("Diego Merletto", "Vocalista y sintetizadores", new Date(1993 - 1900, 0, 1), null, true),
            new Integrante("Froxeanne", "Vocalista y sintetizadores", new Date(1995 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        Album PaleAwakening = new Album(new ObjectId());
        Album EmotionalScreen = new Album(new ObjectId());

        // Configurar datos del álbum Pale Awakening
        PaleAwakening.setNombre("Pale Awakening");
        PaleAwakening.setFechaLanzamiento(LocalDateTime.of(1995, 11, 1, 0, 0).toInstant(ZoneOffset.UTC));
        PaleAwakening.setGeneroMusical(theFrozenAutumn.getGeneroMusical());
        PaleAwakening.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/127a9ba318880686483529e03591a2fe.jpg");
        PaleAwakening.setCanciones(Arrays.asList(
                "Oblivion", "This Time", "Wait for Nothing", 
                "The Echo of My Lies", "There's No Time to Recall", "Dusk Is Like a Dagger"
        ));

        // Configurar datos del álbum Emotional Screen
        EmotionalScreen.setNombre("Emotional Screen");
        EmotionalScreen.setFechaLanzamiento(LocalDateTime.of(2002, 5, 15, 0, 0).toInstant(ZoneOffset.UTC));
        EmotionalScreen.setGeneroMusical(theFrozenAutumn.getGeneroMusical());
        EmotionalScreen.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/457fb34dc051641baeb485daebcf1253.jpg");
        EmotionalScreen.setCanciones(Arrays.asList(
                "Ashes", "Silence Is Talking", "The Forgotten Frontier", 
                "Second Sight", "Polar Plateau", "Nightmares"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            theFrozenAutumn.setAlbumes(Arrays.asList(PaleAwakening.getId(), EmotionalScreen.getId()));
            artistasDAO.registrar(theFrozenAutumn);
            System.out.println("### ID nuevo del artista The Frozen Autumn: " + theFrozenAutumn.getId());

            // Registrar los álbumes en la base de datos
            PaleAwakening.setReferenciaArtista(theFrozenAutumn.getId());
            EmotionalScreen.setReferenciaArtista(theFrozenAutumn.getId());
            albumesDAO.insercionMasiva(Arrays.asList(PaleAwakening, EmotionalScreen));
            System.out.println("Álbumes de The Frozen Autumn registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(theFrozenAutumn.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Sematary
        Artista sematary = new Artista();
        sematary.setNombreArtista("Sematary");
        sematary.setTipo("Solista");
        sematary.setDescripcion("Sematary es un artista estadounidense conocido por su estilo único que mezcla géneros como trap, horrorcore y estética de 'haunted mound'.");
        sematary.setGeneroMusical("Horrorcore / Trap");
        sematary.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/3d881c102755cced5fdb292a5842a339.jpg");

        // Agregar integrante
        sematary.setIntegrantes(Arrays.asList(
            new Integrante("Sematary", "Vocalista y productor", new Date(2019 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        Album RainbowBridge = new Album(new ObjectId());
        Album ButcherHouse = new Album(new ObjectId());

        // Configurar datos del álbum Rainbow Bridge
        RainbowBridge.setNombre("Rainbow Bridge");
        RainbowBridge.setFechaLanzamiento(LocalDateTime.of(2019, 10, 31, 0, 0).toInstant(ZoneOffset.UTC));
        RainbowBridge.setGeneroMusical(sematary.getGeneroMusical());
        RainbowBridge.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/1279b0eeff0c2a99464b560030ffdbb6.jpg");
        RainbowBridge.setCanciones(Arrays.asList(
                "Cemetery Gates", "Haunted Mound", "Chainsaw Party",
                "Skinmask", "Grave House", "Devil Dogs"
        ));

        // Configurar datos del álbum Butcher House
        ButcherHouse.setNombre("Butcher House");
        ButcherHouse.setFechaLanzamiento(LocalDateTime.of(2021, 8, 15, 0, 0).toInstant(ZoneOffset.UTC));
        ButcherHouse.setGeneroMusical(sematary.getGeneroMusical());
        ButcherHouse.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/c26a757f0a9be86d56b5f2393c8d34d3.jpg");
        ButcherHouse.setCanciones(Arrays.asList(
                "Chainsaw Party 2", "Cowboy Killer", "Skinwalker",
                "Cursed Graveyard", "Haunted Cross", "Machete Massacre"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            sematary.setAlbumes(Arrays.asList(RainbowBridge.getId(), ButcherHouse.getId()));
            artistasDAO.registrar(sematary);
            System.out.println("### ID nuevo del artista Sematary: " + sematary.getId());

            // Registrar los álbumes en la base de datos
            RainbowBridge.setReferenciaArtista(sematary.getId());
            ButcherHouse.setReferenciaArtista(sematary.getId());
            albumesDAO.insercionMasiva(Arrays.asList(RainbowBridge, ButcherHouse));
            System.out.println("Álbumes de Sematary registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(sematary.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Yabujin
        Artista yabujin = new Artista();
        yabujin.setNombreArtista("Yabujin");
        yabujin.setTipo("Solista");
        yabujin.setDescripcion("Yabujin es un artista enigmático conocido por su estilo experimental que mezcla géneros como vaporwave, trap y música electrónica. Es reconocido por su identidad misteriosa y su impacto en la cultura underground.");
        yabujin.setGeneroMusical("Experimental / Vaporwave");
        yabujin.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/aae8f5f2918aca29ff944244b9ba6d5e.jpg");

        // Agregar integrante
        yabujin.setIntegrantes(Arrays.asList(
            new Integrante("Yabujin", "Productor y vocalista", new Date(2018 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        Album Jabujicream = new Album(new ObjectId());
        Album Shinjitsu = new Album(new ObjectId());

        // Configurar datos del álbum Jabujicream
        Jabujicream.setNombre("Jabujicream");
        Jabujicream.setFechaLanzamiento(LocalDateTime.of(2019, 5, 1, 0, 0).toInstant(ZoneOffset.UTC));
        Jabujicream.setGeneroMusical(yabujin.getGeneroMusical());
        Jabujicream.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/830f22af153d98f3eea3ed26676993be.jpg");
        Jabujicream.setCanciones(Arrays.asList(
                "Earthquake!", "Invisible Sword", "Crystal Ocean",
                "Digital Eclipse", "Ethereal Garden", "Secret Wave"
        ));

        // Configurar datos del álbum Shinjitsu
        Shinjitsu.setNombre("Shinjitsu");
        Shinjitsu.setFechaLanzamiento(LocalDateTime.of(2020, 10, 31, 0, 0).toInstant(ZoneOffset.UTC));
        Shinjitsu.setGeneroMusical(yabujin.getGeneroMusical());
        Shinjitsu.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/e9cb17f0d2620a87a2f521d9860050f7.jpg");
        Shinjitsu.setCanciones(Arrays.asList(
                "True Form", "Mirror's Edge", "Forgotten City",
                "Celestial Blade", "Phantom Dreams", "Neo Horizon"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            yabujin.setAlbumes(Arrays.asList(Jabujicream.getId(), Shinjitsu.getId()));
            artistasDAO.registrar(yabujin);
            System.out.println("### ID nuevo del artista Yabujin: " + yabujin.getId());

            // Registrar los álbumes en la base de datos
            Jabujicream.setReferenciaArtista(yabujin.getId());
            Shinjitsu.setReferenciaArtista(yabujin.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Jabujicream, Shinjitsu));
            System.out.println("Álbumes de Yabujin registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(yabujin.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Artista: Ancient Ceremony
        Artista ancientCeremony = new Artista();
        ancientCeremony.setNombreArtista("Ancient Ceremony");
        ancientCeremony.setTipo("Banda");
        ancientCeremony.setDescripcion("Ancient Ceremony es una banda de metal oscura y atmosférica originaria de Italia. Se caracteriza por sus profundas influencias de black metal, doom metal y una atmósfera gótica.");
        ancientCeremony.setGeneroMusical("Black Metal / Doom Metal");
        ancientCeremony.setImagenURL("https://www.metal-archives.com/images/1/3/9/9/1399_photo.jpg");

        // Agregar integrantes
        ancientCeremony.setIntegrantes(Arrays.asList(
            new Integrante("Alessandro S.", "Vocalista y Guitarra", new Date(1999 - 1900, 0, 1), null, true),
            new Integrante("Marco L.", "Bajo", new Date(1999 - 1900, 0, 1), null, true),
            new Integrante("Gianluca R.", "Batería", new Date(1999 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        Album UnderTheMoonlightWeKiss = new Album(new ObjectId());
        Album FallensAngelsSymphony = new Album(new ObjectId());

        // Configurar datos del álbum Under The Moonlight We Kiss
        UnderTheMoonlightWeKiss.setNombre("Under The Moonlight We Kiss");
        UnderTheMoonlightWeKiss.setFechaLanzamiento(LocalDateTime.of(2003, 5, 10, 0, 0).toInstant(ZoneOffset.UTC));
        UnderTheMoonlightWeKiss.setGeneroMusical(ancientCeremony.getGeneroMusical());
        UnderTheMoonlightWeKiss.setImagenPortadaUrl("https://www.metal-archives.com/images/4/0/6/7/4067.jpg?5101");
        UnderTheMoonlightWeKiss.setCanciones(Arrays.asList(
                "Moonlit Sorrows", "Kiss of the Fallen", "Shadows in the Mist",
                "Eternal Darkness", "Beneath the Stars", "The Lost Dreams"
        ));

        // Configurar datos del álbum Fallen Angel's Symphony
        FallensAngelsSymphony.setNombre("Fallen Angel's Symphony");
        FallensAngelsSymphony.setFechaLanzamiento(LocalDateTime.of(2007, 7, 19, 0, 0).toInstant(ZoneOffset.UTC));
        FallensAngelsSymphony.setGeneroMusical(ancientCeremony.getGeneroMusical());
        FallensAngelsSymphony.setImagenPortadaUrl("https://www.metal-archives.com/images/4/0/6/8/4068.jpg?4352");
        FallensAngelsSymphony.setCanciones(Arrays.asList(
                "Symphony of the Fallen", "Angel's Descent", "Wings of the Night",
                "Forgotten Souls", "Eternal Requiem", "Fallen Stars"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            ancientCeremony.setAlbumes(Arrays.asList(UnderTheMoonlightWeKiss.getId(), FallensAngelsSymphony.getId()));
            artistasDAO.registrar(ancientCeremony);
            System.out.println("### ID nuevo del artista Ancient Ceremony: " + ancientCeremony.getId());

            // Registrar los álbumes en la base de datos
            UnderTheMoonlightWeKiss.setReferenciaArtista(ancientCeremony.getId());
            FallensAngelsSymphony.setReferenciaArtista(ancientCeremony.getId());
            albumesDAO.insercionMasiva(Arrays.asList(UnderTheMoonlightWeKiss, FallensAngelsSymphony));
            System.out.println("Álbumes de Ancient Ceremony registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(ancientCeremony.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Type O Negative
        Artista typeONegative = new Artista();
        typeONegative.setNombreArtista("Type O Negative");
        typeONegative.setTipo("Banda");
        typeONegative.setDescripcion("Type O Negative fue una banda de metal gótico originaria de Brooklyn, Nueva York. Son conocidos por su estilo único que combina metal gótico, doom y un toque de humor oscuro. El vocalista Peter Steele fue conocido por su presencia en el escenario y su voz profunda.");
        typeONegative.setGeneroMusical("Gothic Metal / Doom Metal");
        typeONegative.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/46c915dbd705d11121ce507319592d18.jpg");

        // Agregar integrantes
        typeONegative.setIntegrantes(Arrays.asList(
            new Integrante("Peter Steele", "Vocalista y Bajo", new Date(1990 - 1900, 0, 1), new Date(2010 - 1900, 3, 1), false),
            new Integrante("Josh Silver", "Teclados", new Date(1990 - 1900, 0, 1), new Date(2005 - 1900, 0, 1), false),
            new Integrante("Kenny Hickey", "Guitarra y Coros", new Date(1990 - 1900, 0, 1), null, true),
            new Integrante("Johnny Kelly", "Batería", new Date(1994 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        Album BloodyKisses = new Album(new ObjectId());
        Album OctoberRust = new Album(new ObjectId());

        // Configurar datos del álbum Bloody Kisses
        BloodyKisses.setNombre("Bloody Kisses");
        BloodyKisses.setFechaLanzamiento(LocalDateTime.of(1993, 8, 30, 0, 0).toInstant(ZoneOffset.UTC));
        BloodyKisses.setGeneroMusical(typeONegative.getGeneroMusical());
        BloodyKisses.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/391b090e5d946374c2c8b7092782c12b.jpg");
        BloodyKisses.setCanciones(Arrays.asList(
                "Christian Woman", "Black No. 1", "My Girlfriend's Girlfriend",
                "Bloody Kisses (A Death in the Family)", "Summer Breeze", "We Hate Everyone"
        ));

        // Configurar datos del álbum October Rust
        OctoberRust.setNombre("October Rust");
        OctoberRust.setFechaLanzamiento(LocalDateTime.of(1996, 9, 15, 0, 0).toInstant(ZoneOffset.UTC));
        OctoberRust.setGeneroMusical(typeONegative.getGeneroMusical());
        OctoberRust.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/40b59e2232e0f498f5b31b86e87f5404.jpg");
        OctoberRust.setCanciones(Arrays.asList(
                "Love You to Death", "Be My Druidess", "Green Man",
                "Red Water (Christmas Mourning)", "My Girlfriend's Girlfriend", "Wolf Moon"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            typeONegative.setAlbumes(Arrays.asList(BloodyKisses.getId(), OctoberRust.getId()));
            artistasDAO.registrar(typeONegative);
            System.out.println("### ID nuevo del artista Type O Negative: " + typeONegative.getId());

            // Registrar los álbumes en la base de datos
            BloodyKisses.setReferenciaArtista(typeONegative.getId());
            OctoberRust.setReferenciaArtista(typeONegative.getId());
            albumesDAO.insercionMasiva(Arrays.asList(BloodyKisses, OctoberRust));
            System.out.println("Álbumes de Type O Negative registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(typeONegative.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Aphex Twin
        Artista aphexTwin = new Artista();
        aphexTwin.setNombreArtista("Aphex Twin");
        aphexTwin.setTipo("Artista");
        aphexTwin.setDescripcion("Aphex Twin es el nombre artístico de Richard D. James, un productor musical británico conocido por su estilo único dentro de la música electrónica experimental. Ha trabajado en géneros como techno, ambient, industrial y drum and bass.");
        aphexTwin.setGeneroMusical("Electronic / Ambient / IDM");
        aphexTwin.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/8d1a1fda90b7e2cf43da7d33797a2a6e.jpg");

        // Aphex Twin no tiene una banda fija de integrantes, así que no es necesario agregar integrantes.

        // Crear álbumes representativos
        Album SelectedAmbientWorks = new Album(new ObjectId());
        Album Drukqs = new Album(new ObjectId());

        // Configurar datos del álbum Selected Ambient Works 85-92
        SelectedAmbientWorks.setNombre("Selected Ambient Works 85-92");
        SelectedAmbientWorks.setFechaLanzamiento(LocalDateTime.of(1992, 11, 16, 0, 0).toInstant(ZoneOffset.UTC));
        SelectedAmbientWorks.setGeneroMusical(aphexTwin.getGeneroMusical());
        SelectedAmbientWorks.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/6f199a67803148cfb2cf2238b8fda0fb.jpg");
        SelectedAmbientWorks.setCanciones(Arrays.asList(
                "Xtal", "Pulsewidth", "Ageispolis", "I", "Green Calx", "Heliosphan", "We Are The Music Makers",
                "Schottkey 7th Path", "Ptolemy", "Hedphelym", "Meltphace 6", "Quoth"
        ));

        // Configurar datos del álbum Drukqs
        Drukqs.setNombre("Drukqs");
        Drukqs.setFechaLanzamiento(LocalDateTime.of(2001, 10, 22, 0, 0).toInstant(ZoneOffset.UTC));
        Drukqs.setGeneroMusical(aphexTwin.getGeneroMusical());
        Drukqs.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/0c5853ff38e027843b907a821257534e.jpg");
        Drukqs.setCanciones(Arrays.asList(
                "Jynweythek", "Vordhosbn", "Fingerbib", "Afx237v7", "Pancake Lizard", "Mt. Saint Michel + St. Michaels Mount", "Nanou 2"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            aphexTwin.setAlbumes(Arrays.asList(SelectedAmbientWorks.getId(), Drukqs.getId()));
            artistasDAO.registrar(aphexTwin);
            System.out.println("### ID nuevo de Aphex Twin: " + aphexTwin.getId());

            // Registrar los álbumes en la base de datos
            SelectedAmbientWorks.setReferenciaArtista(aphexTwin.getId());
            Drukqs.setReferenciaArtista(aphexTwin.getId());
            albumesDAO.insercionMasiva(Arrays.asList(SelectedAmbientWorks, Drukqs));
            System.out.println("Álbumes de Aphex Twin registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(aphexTwin.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Burzum
        Artista burzum = new Artista();
        burzum.setNombreArtista("Burzum");
        burzum.setTipo("Banda");
        burzum.setDescripcion("Burzum es el proyecto musical de Varg Vikernes, un influyente músico noruego conocido por su estilo único de black metal, aunque sus últimos trabajos también incluyen elementos de ambient y música electrónica.");
        burzum.setGeneroMusical("Black Metal");
        burzum.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/f915497003fe6bc7fafbbccb09826fff.jpg");

        // Integrantes
        burzum.setIntegrantes(Arrays.asList(
            new Integrante("Varg Vikernes", "Vocalista, Guitarra, Bajo, Batería", new Date(1973 - 1900, 2, 11), null, true)
        ));

        // Crear álbumes representativos
        Album BurzumAlbum = new Album(new ObjectId());
        Album FilosofemAlbum = new Album(new ObjectId());

        // Configurar datos del álbum Burzum (1992)
        BurzumAlbum.setNombre("Burzum");
        BurzumAlbum.setFechaLanzamiento(LocalDateTime.of(1992, 3, 9, 0, 0).toInstant(ZoneOffset.UTC));
        BurzumAlbum.setGeneroMusical(burzum.getGeneroMusical());
        BurzumAlbum.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/e5577ec25c8d194c8af6368197b2c70f.jpg");
        BurzumAlbum.setCanciones(Arrays.asList(
                "Feeble Screams From Forests Unknown", "Ea, Lord of the Depths", "Black Spell of Destruction",
                "Channelling the Power of Souls into a New God", "War", "The Crying Orc", "My Journey to the Stars",
                "Dungeons of Darkness"
        ));

        // Configurar datos del álbum Filosofem (1996)
        FilosofemAlbum.setNombre("Filosofem");
        FilosofemAlbum.setFechaLanzamiento(LocalDateTime.of(1996, 12, 15, 0, 0).toInstant(ZoneOffset.UTC));
        FilosofemAlbum.setGeneroMusical(burzum.getGeneroMusical());
        FilosofemAlbum.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/f915497003fe6bc7fafbbccb09826fff.jpg");
        FilosofemAlbum.setCanciones(Arrays.asList(
                "Det Som En Gang Var", "Rundtgåing Av Den Transcendentale Egenhetens Støtte", "Black Spell of Destruction",
                "Beholding the Daughters of the Firmament", "Filosofem", "Dunkelheit"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            burzum.setAlbumes(Arrays.asList(BurzumAlbum.getId(), FilosofemAlbum.getId()));
            artistasDAO.registrar(burzum);
            System.out.println("### ID nuevo de Burzum: " + burzum.getId());

            // Registrar los álbumes en la base de datos
            BurzumAlbum.setReferenciaArtista(burzum.getId());
            FilosofemAlbum.setReferenciaArtista(burzum.getId());
            albumesDAO.insercionMasiva(Arrays.asList(BurzumAlbum, FilosofemAlbum));
            System.out.println("Álbumes de Burzum registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(burzum.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Bethlehem
        Artista bethlehem = new Artista();
        bethlehem.setNombreArtista("Bethlehem");
        bethlehem.setTipo("Banda");
        bethlehem.setDescripcion("Bethlehem es una banda alemana de black metal y doom metal, fundada en 1991. Son conocidos por su estilo oscuro y depresivo, con una atmósfera melancólica que fusiona el black metal clásico con elementos de doom y death metal.");
        bethlehem.setGeneroMusical("Black Metal, Doom Metal");
        bethlehem.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/06046113bdb157e425e69ee5d2ff7964.jpg");

        // Integrantes
        bethlehem.setIntegrantes(Arrays.asList(
            new Integrante("Jürgen Bartsch", "Vocalista, Guitarra", new Date(1973 - 1900, 9, 16), null, true),
            new Integrante("Rainer Landfermann", "Vocalista", new Date(1972 - 1900, 2, 5), null, true)
        ));

        // Crear álbumes representativos
        Album DarkMetalAlbum = new Album(new ObjectId());
        Album SuizidAlbum = new Album(new ObjectId());

        // Configurar datos del álbum Dark Metal (1994)
        DarkMetalAlbum.setNombre("Dark Metal");
        DarkMetalAlbum.setFechaLanzamiento(LocalDateTime.of(1994, 5, 15, 0, 0).toInstant(ZoneOffset.UTC));
        DarkMetalAlbum.setGeneroMusical(bethlehem.getGeneroMusical());
        DarkMetalAlbum.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/39938331e3d46cf1d57e058df6c3d539.jpg");
        DarkMetalAlbum.setCanciones(Arrays.asList(
                "The Evil Is This World", "Life and Death", "The Silence of the Universe",
                "Todestrieb", "Ende", "Dying", "Requiem"
        ));

        // Configurar datos del álbum S.U.I.Z.I.D. (1997)
        SuizidAlbum.setNombre("S.U.I.Z.I.D.");
        SuizidAlbum.setFechaLanzamiento(LocalDateTime.of(1997, 7, 1, 0, 0).toInstant(ZoneOffset.UTC));
        SuizidAlbum.setGeneroMusical(bethlehem.getGeneroMusical());
        SuizidAlbum.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/33af2e5d1dfc41e1bd81a7036010e108.jpg");
        SuizidAlbum.setCanciones(Arrays.asList(
                "Todestrieb", "Warum", "S.U.I.Z.I.D.", "Schmerz",
                "Die letzten Schritte des Ertrinkenden", "Abschied", "Schmerz von den Sternen"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            bethlehem.setAlbumes(Arrays.asList(DarkMetalAlbum.getId(), SuizidAlbum.getId()));
            artistasDAO.registrar(bethlehem);
            System.out.println("### ID nuevo de Bethlehem: " + bethlehem.getId());

            // Registrar los álbumes en la base de datos
            DarkMetalAlbum.setReferenciaArtista(bethlehem.getId());
            SuizidAlbum.setReferenciaArtista(bethlehem.getId());
            albumesDAO.insercionMasiva(Arrays.asList(DarkMetalAlbum, SuizidAlbum));
            System.out.println("Álbumes de Bethlehem registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(bethlehem.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Rory in early 20s
        Artista roryInEarly20s = new Artista();
        roryInEarly20s.setNombreArtista("Rory in early 20s");
        roryInEarly20s.setTipo("Artista");
        roryInEarly20s.setDescripcion("Su trabajo se caracteriza por un ritmo rápido, distorsionado, troceado y repetitivo con clips de audio que incluyen samples de anime, voces ucranianas y el uso de programas de sintetización de voz como Vocaloid, combinados con rápidos ritmos de break y fuertes golpes de batería.");
        roryInEarly20s.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/6822baeee7290896fd05520594fb3bbb.jpg");
        roryInEarly20s.setGeneroMusical("Breakcore");

        // Crear álbumes representativos
        Album ShindaWarutsu = new Album(new ObjectId());
        Album bloodForEvening = new Album(new ObjectId());

        // Configurar datos del álbum "Youthful Reverie" (2020)
        ShindaWarutsu.setNombre("Shinda warutsu");
        ShindaWarutsu.setFechaLanzamiento(LocalDateTime.of(2020, 3, 15, 0, 0).toInstant(ZoneOffset.UTC));
        ShindaWarutsu.setGeneroMusical(roryInEarly20s.getGeneroMusical());
        ShindaWarutsu.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/19dc91268a937525ccd7b1245f46d595.jpg");
        ShindaWarutsu.setCanciones(Arrays.asList(
                "anata no usui himei", "a a a akusoeino", "hanaste nina de"
        ));

        // Configurar datos del álbum "The Echo of Tomorrow" (2022)
        bloodForEvening.setNombre("blood for evening");
        bloodForEvening.setFechaLanzamiento(LocalDateTime.of(2021, 11, 7, 0, 0).toInstant(ZoneOffset.UTC));
        bloodForEvening.setGeneroMusical(roryInEarly20s.getGeneroMusical());
        bloodForEvening.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/0d224dd2d5b879e40b1f9ccc08d198e2.jpg");
        bloodForEvening.setCanciones(Arrays.asList(
                "kine so Mona", "demuyo imiru", "tamisushi"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            roryInEarly20s.setAlbumes(Arrays.asList(ShindaWarutsu.getId(), bloodForEvening.getId()));
            artistasDAO.registrar(roryInEarly20s);
            System.out.println("### ID nuevo de Rory in early 20s: " + roryInEarly20s.getId());

            // Registrar los álbumes en la base de datos
            ShindaWarutsu.setReferenciaArtista(roryInEarly20s.getId());
            bloodForEvening.setReferenciaArtista(roryInEarly20s.getId());
            albumesDAO.insercionMasiva(Arrays.asList(ShindaWarutsu, bloodForEvening));
            System.out.println("Álbumes de Rory in early 20s registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(roryInEarly20s.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Sewerslvt
        Artista sewerslvt = new Artista();
        sewerslvt.setNombreArtista("Sewerslvt");
        sewerslvt.setTipo("Artista");
        sewerslvt.setDescripcion("Sewerslvt es un productor musical conocido por sus composiciones de música electrónica, especialmente en los géneros de breakcore, lo-fi y ambient. Sus trabajos a menudo exploran temas oscuros y emocionales con una atmósfera melancólica y caótica.");
        sewerslvt.setGeneroMusical("Breakcore, Lo-fi, Ambient");
        sewerslvt.setImagenURL("https://lastfm.freetls.fastly.net/i/u/770x0/2fedc5f89c5523042513f6e02c945723.jpg#2fedc5f89c5523042513f6e02c945723");

        // Crear álbumes representativos
        Album DrainingLoveStory = new Album(new ObjectId());
        Album weHadGoodTimesTogether = new Album(new ObjectId());

        // Configurar datos del álbum "Drowning in Emotion" (2020)
        DrainingLoveStory.setNombre("Draining Love Story");
        DrainingLoveStory.setFechaLanzamiento(LocalDateTime.of(2020, 1, 25, 0, 0).toInstant(ZoneOffset.UTC));
        DrainingLoveStory.setGeneroMusical(sewerslvt.getGeneroMusical());
        DrainingLoveStory.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/05fa8d0165aca4571ef76187e456ea6b.jpg");
        DrainingLoveStory.setCanciones(Arrays.asList(
                "Love Is a Mighty Big Word", "Newlove", "Yandere Complex",
                "Ecifircas", "Lexapro Delirium", "This Fleeting Feeling"
        ));

        // Configurar datos del álbum "Panic Attack" (2021)
        weHadGoodTimesTogether.setNombre("we had good times together, don't forget that");
        weHadGoodTimesTogether.setFechaLanzamiento(LocalDateTime.of(2021, 11, 12, 0, 0).toInstant(ZoneOffset.UTC));
        weHadGoodTimesTogether.setGeneroMusical(sewerslvt.getGeneroMusical());
        weHadGoodTimesTogether.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/c04b2abd0f8ae72b1ccdcdc37459050c.jpg");
        weHadGoodTimesTogether.setCanciones(Arrays.asList(
                "dissociating", "self destruction worldwide broadcast", "all the joy in life was gone once you left",
                "the last thing she sent me"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            sewerslvt.setAlbumes(Arrays.asList(DrainingLoveStory.getId(), weHadGoodTimesTogether.getId()));
            artistasDAO.registrar(sewerslvt);
            System.out.println("### ID nuevo de Sewerslvt: " + sewerslvt.getId());

            // Registrar los álbumes en la base de datos
            DrainingLoveStory.setReferenciaArtista(sewerslvt.getId());
            weHadGoodTimesTogether.setReferenciaArtista(sewerslvt.getId());
            albumesDAO.insercionMasiva(Arrays.asList(DrainingLoveStory, weHadGoodTimesTogether));
            System.out.println("Álbumes de Sewerslvt registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(sewerslvt.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Crystal Castles
        Artista crystalCastles = new Artista();
        crystalCastles.setNombreArtista("Crystal Castles");
        crystalCastles.setTipo("Banda");
        crystalCastles.setDescripcion("Crystal Castles es una banda canadiense de música electrónica experimental formada en 2003, conocida por sus composiciones que mezclan elementos de música electrónica, industrial y noise. La banda ha sido conocida por su sonido único y sus presentaciones enérgicas.");
        crystalCastles.setGeneroMusical("Electrónica experimental, Noise, Synthpop");
        crystalCastles.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/50b8e38ffd64dd30637b9a2ceb11b030.jpg");

        // Crear álbumes representativos
        Album CrystalCastles = new Album(new ObjectId());
        Album II = new Album(new ObjectId());

        // Configurar datos del álbum "Crystal Castles" (2008)
        CrystalCastles.setNombre("Crystal Castles");
        CrystalCastles.setFechaLanzamiento(LocalDateTime.of(2008, 6, 8, 0, 0).toInstant(ZoneOffset.UTC));
        CrystalCastles.setGeneroMusical(crystalCastles.getGeneroMusical());
        CrystalCastles.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/8da6d80eb32a8b6f35fdf09d89a004f0.jpg");
        CrystalCastles.setCanciones(Arrays.asList(
                "Untrust Us", "Crimewave", "Vanished", "Air War", "Magic Spells", 
                "Courtship Dating", "Tell Me What to Swallow", "XxzxcuZ"
        ));
        crystalCastles.setIntegrantes(Arrays.asList(
            new Integrante("Ethan Kath", "Productor, Compositor", new Date(2003 - 1900, 0, 1), null, true),
            new Integrante("Alice Glass", "Vocalista", new Date(2003 - 1900, 0, 1), new Date(2014 - 1900, 0, 1), false),
            new Integrante("Robert McCleary", "Batería (2012–2014)", new Date(2012 - 1900, 0, 1), new Date(2014 - 1900, 0, 1), false),
            new Integrante("Cameron Findlay", "Teclados (2011–2014)", new Date(2011 - 1900, 0, 1), new Date(2014 - 1900, 0, 1), false)
        ));

        // Configurar datos del álbum "II" (2010)
        II.setNombre("II");
        II.setFechaLanzamiento(LocalDateTime.of(2011, 4, 25, 0, 0).toInstant(ZoneOffset.UTC));
        II.setGeneroMusical(crystalCastles.getGeneroMusical());
        II.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/df0454f5ebcf31c4dd30832d07312b19.jpg");
        II.setCanciones(Arrays.asList(
                "Fainting Spells", "Celestica", "Suffocation", "Kerosene", "Empathy", 
                "Vietnam", "Not In Love", "Baptism", "Intimate"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            crystalCastles.setAlbumes(Arrays.asList(CrystalCastles.getId(), II.getId()));
            artistasDAO.registrar(crystalCastles);
            System.out.println("### ID nuevo de Crystal Castles: " + crystalCastles.getId());

            // Registrar los álbumes en la base de datos
            CrystalCastles.setReferenciaArtista(crystalCastles.getId());
            II.setReferenciaArtista(crystalCastles.getId());
            albumesDAO.insercionMasiva(Arrays.asList(CrystalCastles, II));
            System.out.println("Álbumes de Crystal Castles registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(crystalCastles.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Bathory
        Artista bathory = new Artista();
        bathory.setNombreArtista("Bathory");
        bathory.setTipo("Banda");
        bathory.setDescripcion("Bathory fue una banda de black metal originaria de Suecia, formada en 1983 por Quorthon. A lo largo de su carrera, Bathory jugó un papel clave en el desarrollo del black metal y el viking metal. Su estilo se caracterizó por la crudeza y el ambiente sombrío en sus primeros discos, y una exploración del viking metal en sus últimos trabajos.");
        bathory.setGeneroMusical("Black Metal, Viking Metal");
        bathory.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/2897e69a2134c866e4ab1d6bc65669e0.jpg");

        // Agregar integrantes de Bathory
        bathory.setIntegrantes(Arrays.asList(
            new Integrante("Quorthon", "Vocalista, Guitarra, Bajo, Batería", new Date(1983 - 1900, 0, 1), new Date(2004 - 1900, 0, 1), false),
            new Integrante("Kothaar", "Batería", new Date(1984 - 1900, 0, 1), new Date(1986 - 1900, 0, 1), false),
            new Integrante("Vvornth", "Batería", new Date(1986 - 1900, 0, 1), new Date(1989 - 1900, 0, 1), false),
            new Integrante("Blackie", "Bajo", new Date(1984 - 1900, 0, 1), new Date(1986 - 1900, 0, 1), false),
            new Integrante("E. H. R.", "Guitarra", new Date(1985 - 1900, 0, 1), new Date(1986 - 1900, 0, 1), false)
        ));

        // Crear álbumes representativos
        Album album1 = new Album(new ObjectId());
        Album album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Bathory" (1984)
        album1.setNombre("Bathory");
        album1.setFechaLanzamiento(LocalDateTime.of(1984, 12, 12, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(bathory.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/1aae744c38e561d100c0d485ca8d8c79.jpg");
        album1.setCanciones(Arrays.asList(
                "Hades", "Reaper", "The Return of the Darkness and Evil", "Sacrifice"
        ));

        // Configurar datos del álbum "Under the Sign of the Black Mark" (1987)
        album2.setNombre("Under the Sign of the Black Mark");
        album2.setFechaLanzamiento(LocalDateTime.of(1987, 6, 10, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(bathory.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/25b63fefc6696ab375d8773c143b8154.jpg");
        album2.setCanciones(Arrays.asList(
                "Nocturnal Silence", "Massacre", "Woman of Dark Desires", "Equimanthorn"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            bathory.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(bathory);
            System.out.println("### ID nuevo de Bathory: " + bathory.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(bathory.getId());
            album2.setReferenciaArtista(bathory.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Bathory registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(bathory.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: La Casa de los Tubos
        Artista laCasaDeLosTubos = new Artista();
        laCasaDeLosTubos.setNombreArtista("La Casa de los Tubos");
        laCasaDeLosTubos.setTipo("Banda");
        laCasaDeLosTubos.setDescripcion("La Casa de los Tubos es una banda de rock de la escena de obregon que surgió en 2022. Su música fusiona géneros como el post-punk, psicodelico, y rock alternativo. A lo largo de su carrera, la banda ha sido conocida por su estilo experimental y su enfoque único en el sonido.");
        laCasaDeLosTubos.setGeneroMusical("Post-punk, Psicodelico, Rock Alternativo");
        laCasaDeLosTubos.setImagenURL("https://yt3.googleusercontent.com/DEW71ghijNofGCrwdXA9RC1dyhPucE7xBdKQGlT-FMWgaFIlJYByiP8YgeifY4pJcVitgzpf2Q=s160-c-k-c0x00ffffff-no-rj");

        // Agregar integrantes de La Casa de los Tubos
        laCasaDeLosTubos.setIntegrantes(Arrays.asList(
            new Integrante("Jose Angel", "Vocalista, Guitarra", new Date(2022 - 1900, 0, 1), null, true),
            new Integrante("Naily Gastelum", "Teclado", new Date(2022 - 1900, 0, 1), null, true),
            new Integrante("Diego Corral", "Bajo", new Date(2022 - 1900, 0, 1), null, true),
            new Integrante("Gael Valenzuela", "Batería", new Date(2022 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
        album1 = new Album(new ObjectId());
        album2 = new Album(new ObjectId());

        // Configurar datos del álbum "La Casa de los Tubos" (1992)
        album1.setNombre("La Casa de los Tubos");
        album1.setFechaLanzamiento(LocalDateTime.of(1992, 5, 21, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(laCasaDeLosTubos.getGeneroMusical());
        album1.setImagenPortadaUrl("https://img001.prntscr.com/file/img001/J_sDGdYpQeiH8rXUWtzI7A.png");
        album1.setCanciones(Arrays.asList(
                "reposo / sin descanso", "descando / sin reposo", "caja negra"
        ));

        // Configurar datos del álbum "Futuros" (1996)
        album2.setNombre("Buzo");
        album2.setFechaLanzamiento(LocalDateTime.of(1996, 11, 18, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(laCasaDeLosTubos.getGeneroMusical());
        album2.setImagenPortadaUrl("https://img001.prntscr.com/file/img001/zc3ISWlQTsGJYNabIcmDZg.png");
        album2.setCanciones(Arrays.asList(
                "Buzo", "Robert Burguer"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            laCasaDeLosTubos.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(laCasaDeLosTubos);
            System.out.println("### ID nuevo de La Casa de los Tubos: " + laCasaDeLosTubos.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(laCasaDeLosTubos.getId());
            album2.setReferenciaArtista(laCasaDeLosTubos.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de La Casa de los Tubos registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(laCasaDeLosTubos.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Midrift
        Artista midrift = new Artista();
        midrift.setNombreArtista("Midrift");
        midrift.setTipo("Artista");
        midrift.setDescripcion("Midrift es una banda de califoria Estados Unidos de Shoehaze formada en la década de los 2000. Su estilo está influenciado por la música de los años 80 y tiene un sonido característico entre melancólico y energético.");
        midrift.setGeneroMusical("Shoegaze");
        midrift.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/fd6b09141fa970ae280a3303510fb117.jpg");

        // Crear álbumes representativos
        album1 = new Album(new ObjectId());
        album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Oscuridad" (2005)
        album1.setNombre("Midrift");
        album1.setFechaLanzamiento(LocalDateTime.of(2023, 9, 16, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(midrift.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/9d4f2dcae4669d2252d1a88cda4c51ae.jpg");
        album1.setCanciones(Arrays.asList(
                "Midrift", "Machina", "Twin Flames"
        ));

        // Configurar datos del álbum "Eclipse" (2010)
        album2.setNombre("Elysian");
        album2.setFechaLanzamiento(LocalDateTime.of(2023, 4, 22, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(midrift.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/476ca70729c1be57968ffb68f5b8b167.jpg");
        album2.setCanciones(Arrays.asList(
                "Path", "Burden", "Change For"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            midrift.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(midrift);
            System.out.println("### ID nuevo de Midrift: " + midrift.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(midrift.getId());
            album2.setReferenciaArtista(midrift.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Midrift registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(midrift.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Këkht Aräkh
        Artista kekhtArakh = new Artista();
        kekhtArakh.setNombreArtista("Këkht Aräkh");
        kekhtArakh.setTipo("Artista");
        kekhtArakh.setDescripcion("Këkht Aräkh es un artista de Black Metal atmosférico originario de Ucrania. Su música se caracteriza por atmósferas sombrías, depresivas y evocadoras, fusionadas con elementos de la música tradicional ucraniana.");
        kekhtArakh.setGeneroMusical("Black Metal Atmosférico");
        kekhtArakh.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/f1327680fd216a50b041f11999018780.jpg");


        // Crear álbumes representativos
        album1 = new Album(new ObjectId());
        album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Këkht Aräkh" (2015)
        album1.setNombre("Pale Swordsman");
        album1.setFechaLanzamiento(LocalDateTime.of(2021, 4, 10, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(kekhtArakh.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/c238c3c6be40cab5597813e9f426636a.jpg");
        album1.setCanciones(Arrays.asList(
                "Thorns", "Night Descends", "Amor"
        ));

        // Configurar datos del álbum "The Path of the Fallen" (2018)
        album2.setNombre("Night & Love");
        album2.setFechaLanzamiento(LocalDateTime.of(2019, 11, 30, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(kekhtArakh.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/b6a574337d0b43f2ada2f39204278d86.jpg");
        album2.setCanciones(Arrays.asList(
                "As the Night Falls...", "Elegy for the Memory of Me", "Den Venstre Hånd På Den Høyre"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            kekhtArakh.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(kekhtArakh);
            System.out.println("### ID nuevo de Këkht Aräkh: " + kekhtArakh.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(kekhtArakh.getId());
            album2.setReferenciaArtista(kekhtArakh.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Këkht Aräkh registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(kekhtArakh.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Rebzyyx
        Artista rebzyyx = new Artista();
        rebzyyx.setNombreArtista("Rebzyyx");
        rebzyyx.setTipo("Artista");
        rebzyyx.setDescripcion("Rebzyyx es un proyecto de música electrónica experimental y ambient, conocido por sus atmósferas oscuras y surrealistas.");
        rebzyyx.setGeneroMusical("Hyperpop");
        rebzyyx.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/3ed009b1f33b991208b0d2068a998956.jpg");


        // Crear álbumes representativos
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Nebula" (2017)
        album1.setNombre("I'm so crazy for youuu </3");
        album1.setFechaLanzamiento(LocalDateTime.of(2022, 4, 5, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(rebzyyx.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/5da3aa0d9186e8ec59700c1f733f8ce5.jpg");
        album1.setCanciones(Arrays.asList(
                "I'm so crazy for youuu </3", "daydreaming", "I'm so fucked up please help me", "Lost Frequencies"
        ));

        // Configurar datos del álbum "Eclipse" (2020)
        album2.setNombre("I deserve this");
        album2.setFechaLanzamiento(LocalDateTime.of(2021, 2, 23, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(rebzyyx.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/6229523a099045fa7ec2e66a91768fcd.jpg");
        album2.setCanciones(Arrays.asList(
                "I deserve this", "calling for me", "skinny"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            rebzyyx.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(rebzyyx);
            System.out.println("### ID nuevo de Rebzyyx: " + rebzyyx.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(rebzyyx.getId());
            album2.setReferenciaArtista(rebzyyx.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Rebzyyx registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(rebzyyx.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Deftones
        Artista deftones = new Artista();
        deftones.setNombreArtista("Deftones");
        deftones.setTipo("Banda");
        deftones.setDescripcion("Deftones es una banda estadounidense formada en 1988, conocida por su mezcla de metal alternativo, nu metal y post-hardcore. La banda es conocida por su estilo único que combina guitarras pesadas con atmósferas melódicas y emotivas.");
        deftones.setGeneroMusical("Alternative Metal / Nu Metal / Post-Hardcore");
        deftones.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/0ec2c7af18f15fc604345e65be025585.jpg");

        // Agregar integrantes de Deftones
        deftones.setIntegrantes(Arrays.asList(
            new Integrante("Chino Moreno", "Vocalista y Guitarra", new Date(1988 - 1900, 0, 1), null, true),
            new Integrante("Stephen Carpenter", "Guitarra", new Date(1988 - 1900, 0, 1), null, true),
            new Integrante("Abe Cunningham", "Batería", new Date(1988 - 1900, 0, 1), null, true),
            new Integrante("Chi Cheng", "Bajo", new Date(1988 - 1900, 0, 1), new Date(2013 - 1900, 2, 13), false),
            new Integrante("Sergio Vega", "Bajo", new Date(2009 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes representativos
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Around the Fur" (1997)
        album1.setNombre("Around the Fur");
        album1.setFechaLanzamiento(LocalDateTime.of(1997, 10, 28, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(deftones.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/3e6814b457a9087e0c46d5a949de2766.jpg");
        album1.setCanciones(Arrays.asList(
                "My Summer", "Be Quiet and Drive (Far Away)", "Lhabia", "Headup"
        ));

        // Configurar datos del álbum "White Pony" (2000)
        album2.setNombre("White Pony");
        album2.setFechaLanzamiento(LocalDateTime.of(2000, 6, 20, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(deftones.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/39f82958589c0f2c1a3dd88639144573.jpg");
        album2.setCanciones(Arrays.asList(
                "Change (In the House of Flies)", "Digital Bath", "Elite", "Passenger"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            deftones.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(deftones);
            System.out.println("### ID nuevo de Deftones: " + deftones.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(deftones.getId());
            album2.setReferenciaArtista(deftones.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Deftones registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(deftones.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Capel Beulah
        Artista capelBeulah = new Artista();
        capelBeulah.setNombreArtista("Capel Beulah");
        capelBeulah.setTipo("Artista");
        capelBeulah.setDescripcion("Capel Beulah es una banda solista del reino unido conocida por su estilo melódico de metal y sus letras profundas y emotivas. Han ganado notoriedad en la escena de música experimental y underground.");
        capelBeulah.setGeneroMusical("Black Metal");
        capelBeulah.setImagenURL("https://www.metal-archives.com/images/3/5/4/0/3540469281_logo.jpg?5952");  // Agregar imagen adecuada

        // Crear álbumes representativos
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar datos del álbum "Under The Moonlight We Kiss" (2010)
        album1.setNombre("Capel Beulah");
        album1.setFechaLanzamiento(LocalDateTime.of(2020, 7, 11, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(capelBeulah.getGeneroMusical());
        album1.setImagenPortadaUrl("https://www.metal-archives.com/images/8/5/6/0/856023.jpg?1404");  // Agregar imagen adecuada
        album1.setCanciones(Arrays.asList(
                "Symptoms of Astral Exteriorization", "Sage of the Black Cocoon", "Reaffirm Allegiance to the Devil"
        ));

        // Configurar datos del álbum "Fallen Angel's Symphony" (2013)
        album2.setNombre("Olkoth");
        album2.setFechaLanzamiento(LocalDateTime.of(2021, 10, 31, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(capelBeulah.getGeneroMusical());
        album2.setImagenPortadaUrl("https://www.metal-archives.com/images/1/1/1/1/1111461.jpg?2130");  // Agregar imagen adecuada
        album2.setCanciones(Arrays.asList(
                "The Sunrise Has Swollen", "Invert All Harmony", "Ink Well"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            capelBeulah.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(capelBeulah);
            System.out.println("### ID nuevo de Capel Beulah: " + capelBeulah.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(capelBeulah.getId());
            album2.setReferenciaArtista(capelBeulah.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Capel Beulah registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(capelBeulah.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: bliss3three
        Artista bliss3three = new Artista();
        bliss3three.setNombreArtista("bliss3three");
        bliss3three.setTipo("Artista");
        bliss3three.setDescripcion("bliss3three es una proyecto experimental que fusiona elementos de vaporwave y ambient en su música, conocida por su estilo abstracto y de vanguardia.");
        bliss3three.setGeneroMusical("Vaporwave, Hexd, ambient");
        bliss3three.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/3d11425bc781fc44ea79031e7d386bc2.jpg");  // Agregar imagen adecuada

        // Crear álbumes representativos
        album1 = new Album(new ObjectId());
        album2 = new Album(new ObjectId());

        album1.setNombre("C3L3STIAL天の");
        album1.setFechaLanzamiento(LocalDateTime.of(2020, 6, 20, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(bliss3three.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/2c9e71522567e2ddcb5041ee885e9297.jpg");  // Agregar imagen adecuada
        album1.setCanciones(Arrays.asList(
                "carousel. {i}", "{idle}", "carousel. {ii}"
        ));

        album2.setNombre("I'm Gonna Miss You");
        album2.setFechaLanzamiento(LocalDateTime.of(2021, 9, 18, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(bliss3three.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/fd25eebb27473273394390818e80e264.jpg");  // Agregar imagen adecuada
        album2.setCanciones(Arrays.asList(
                "Halo Shard", "GOD OF SLEEP", "that brings me so much joy~"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            bliss3three.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(bliss3three);
            System.out.println("### ID nuevo de bliss3three: " + bliss3three.getId());

            // Registrar los álbumes en la base de datos
            album1.setReferenciaArtista(bliss3three.getId());
            album2.setReferenciaArtista(bliss3three.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de bliss3three registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(bliss3three.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artist: I Shalt Become
        Artista iShaltBecome = new Artista();
        iShaltBecome.setNombreArtista("I Shalt Become");
        iShaltBecome.setTipo("Banda");
        iShaltBecome.setDescripcion("I Shalt Become was an American atmospheric black metal band, known for their melancholic sound and introspective lyrics, active primarily in the late 1990s.");
        iShaltBecome.setGeneroMusical("Atmospheric Black Metal");
        iShaltBecome.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/d382bad17631428bb064c74b2f102f46.jpg");  // Add a proper image

        // Add members of I Shalt Become
        iShaltBecome.setIntegrantes(Arrays.asList(
            new Integrante("Lord K", "Vocalista y Guitarra", new Date(1997 - 1900, 0, 1), null, true),
            new Integrante("R. F.", "Bajo y Programación", new Date(1997 - 1900, 0, 1), null, true)
        ));

        // Create albums for I Shalt Become
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configure album "Requiem for the Sun" (2000)
        album1.setNombre("Requiem for the Sun");
        album1.setFechaLanzamiento(LocalDateTime.of(2000, 4, 10, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(iShaltBecome.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/32389d34b4564b2db032009173236653.jpg");  // Add a proper image
        album1.setCanciones(Arrays.asList(
                "The Desolate One", "Alone in the Dark", "Echoes of the Void", "Requiem for the Sun"
        ));

        // Configure album "In the Falling Snow" (2002)
        album2.setNombre("In the Falling Snow");
        album2.setFechaLanzamiento(LocalDateTime.of(2002, 11, 21, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(iShaltBecome.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/500x500/28613624772844c6a650e645e935ca98.jpg");  // Add a proper image
        album2.setCanciones(Arrays.asList(
                "Falling Snow", "A Glimpse of the Eternal", "Winter's Embrace", "A Dying Flame"
        ));

        try {
            // Register the artist and get the generated ID
            iShaltBecome.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(iShaltBecome);
            System.out.println("### New ID for I Shalt Become: " + iShaltBecome.getId());

            // Register the albums in the database
            album1.setReferenciaArtista(iShaltBecome.getId());
            album2.setReferenciaArtista(iShaltBecome.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Albums for I Shalt Become registered successfully.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Query albums by artist
        try {
            System.out.println(albumesDAO.obtenerPorArtista(iShaltBecome.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artist: Siouxxie Sixxsta
        Artista siouxxieSixxsta = new Artista();
        siouxxieSixxsta.setNombreArtista("Siouxxie Sixxsta");
        siouxxieSixxsta.setTipo("Solista");
        siouxxieSixxsta.setDescripcion("Siouxxie Sixxsta es una artista experimental que mezcla varios géneros, incluyendo hyperpop, darkwave y electro.");
        siouxxieSixxsta.setGeneroMusical("Hyperpop");
        siouxxieSixxsta.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/30c7fc12e404c62c778472099b443d9d.jpg");


         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        album1.setNombre("witchpop");
        album1.setFechaLanzamiento(LocalDateTime.of(2015, 6, 1, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(siouxxieSixxsta.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/89f2b387dc2728a0dd556b2258d91d7a.jpg");
        album1.setCanciones(Arrays.asList("darkwave sabbat", "father", "girl online"));

        album2.setNombre("ketamine");
        album2.setFechaLanzamiento(LocalDateTime.of(2018, 11, 21, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(siouxxieSixxsta.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/039c1640d019368f48e49aeec91f61b4.jpg");
        album2.setCanciones(Arrays.asList("Darkened Soul", "Fading Light", "Embrace the Night"));

        try {
            siouxxieSixxsta.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(siouxxieSixxsta);
            System.out.println("### New ID for Siouxxie Sixxsta: " + siouxxieSixxsta.getId());

            album1.setReferenciaArtista(siouxxieSixxsta.getId());
            album2.setReferenciaArtista(siouxxieSixxsta.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Albums for Siouxxie Sixxsta registered successfully.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println(albumesDAO.obtenerPorArtista(siouxxieSixxsta.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Have a Nice Life
        Artista haveANiceLife = new Artista();
        haveANiceLife.setNombreArtista("Have a Nice Life");
        haveANiceLife.setTipo("Banda");
        haveANiceLife.setDescripcion("Have a Nice Life es una banda estadounidense de post-punk, experimental y shoegaze formada en 2000.");
        haveANiceLife.setGeneroMusical("Post-Punk/Experimental");
        haveANiceLife.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/0a128dbd86af916762ec70345302b081.jpg");

        // Agregar miembros
        haveANiceLife.setIntegrantes(Arrays.asList(
            new Integrante("Dan Barrett", "Vocalista y Guitarra", new Date(2000 - 1900, 0, 1), null, true),
            new Integrante("Tim Macuga", "Bajo y Percusión", new Date(2000 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes de Have a Nice Life
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar el álbum "Deathconsciousness" (2008)
        album1.setNombre("Deathconsciousness");
        album1.setFechaLanzamiento(LocalDateTime.of(2008, 7, 7, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(haveANiceLife.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/5ff5a7ea9cd5487661647c9d5a1453e4.jpg");
        album1.setCanciones(Arrays.asList("Bloodhail", "Waiting for Black Metal Records to Come in the Mail", "Holy Fucking Shit: 40,000", "The Unquiet Grave"));

        // Configurar el álbum "The Unnatural World" (2014)
        album2.setNombre("The Unnatural World");
        album2.setFechaLanzamiento(LocalDateTime.of(2014, 2, 4, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(haveANiceLife.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/2e21aea281de4402c419534394d5c602.jpg");
        album2.setCanciones(Arrays.asList("The Bluebird", "Burial Society", "Cropsey", "Music Will Untangle Our Minds"));

        try {
            // Registrar el artista y los álbumes
            haveANiceLife.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(haveANiceLife);
            System.out.println("### Nuevo ID de Have a Nice Life: " + haveANiceLife.getId());

            album1.setReferenciaArtista(haveANiceLife.getId());
            album2.setReferenciaArtista(haveANiceLife.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Have a Nice Life registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(haveANiceLife.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Braxton Knight
        Artista braxtonKnight = new Artista();
        braxtonKnight.setNombreArtista("Braxton Knight");
        braxtonKnight.setTipo("Solista");
        braxtonKnight.setDescripcion("Braxton Knight es un artista emergente de pop indie, conocido por mezclar sonidos modernos con influencias vintage.");
        braxtonKnight.setGeneroMusical("Indie Pop");
        braxtonKnight.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/e7d4cf29a6818fc13f9c837db139a900.jpg");


        // Crear álbumes de Braxton Knight
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar el álbum "Lost in Time" (2021)
        album1.setNombre("Paradise Kiss");
        album1.setFechaLanzamiento(LocalDateTime.of(2021, 5, 10, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(braxtonKnight.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/2f378bc179006e6c0088e4b0af2c18ab.jpg");
        album1.setCanciones(Arrays.asList("Timeless", "Lost", "Mirage", "The Road Ahead"));

        // Configurar el álbum "Fragments" (2023)
        album2.setNombre("Fruits Basket");
        album2.setFechaLanzamiento(LocalDateTime.of(2023, 9, 14, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(braxtonKnight.getGeneroMusical());
        album2.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/4c543070587c73a0672c55a71622c48a.jpg");
        album2.setCanciones(Arrays.asList("Echoes", "Shattered Dreams", "In the Dark"));

        try {
            // Registrar el artista y los álbumes
            braxtonKnight.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(braxtonKnight);
            System.out.println("### Nuevo ID de Braxton Knight: " + braxtonKnight.getId());

            album1.setReferenciaArtista(braxtonKnight.getId());
            album2.setReferenciaArtista(braxtonKnight.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Braxton Knight registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(braxtonKnight.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Artista: Los Diabólicos
        Artista losDiabolicos = new Artista();
        losDiabolicos.setNombreArtista("Los Diabólicos");
        losDiabolicos.setTipo("Banda");
        losDiabolicos.setDescripcion("Los Diabólicos es una banda mexicana de metal experimental con influencias de punk y música alternativa.");
        losDiabolicos.setGeneroMusical("Metal Experimental");
        losDiabolicos.setImagenURL("https://lastfm.freetls.fastly.net/i/u/300x300/de96a1a7a74b3cd807230c951d8874ea.jpg");

        // Agregar miembros
        losDiabolicos.setIntegrantes(Arrays.asList(
            new Integrante("Juan Pérez", "Vocalista", new Date(2005 - 1900, 0, 1), null, true),
            new Integrante("Carlos Ramírez", "Guitarra", new Date(2005 - 1900, 0, 1), null, true)
        ));

        // Crear álbumes de Los Diabólicos
         album1 = new Album(new ObjectId());
         album2 = new Album(new ObjectId());

        // Configurar el álbum "Infierno en la Tierra" (2010)
        album1.setNombre("Los Diabólicos");
        album1.setFechaLanzamiento(LocalDateTime.of(2010, 8, 15, 0, 0).toInstant(ZoneOffset.UTC));
        album1.setGeneroMusical(losDiabolicos.getGeneroMusical());
        album1.setImagenPortadaUrl("https://lastfm.freetls.fastly.net/i/u/300x300/27e79f4b5930e4c6d0aa5bdf08ce311d.jpg");
        album1.setCanciones(Arrays.asList("Esfera de Cristal", "Mal Gusto", "Tierra"));

        // Configurar el álbum "Ritual Oscuro" (2015)
        album2.setNombre("Diabólicos 2");
        album2.setFechaLanzamiento(LocalDateTime.of(2015, 6, 22, 0, 0).toInstant(ZoneOffset.UTC));
        album2.setGeneroMusical(losDiabolicos.getGeneroMusical());
        album2.setImagenPortadaUrl("https://f4.bcbits.com/img/a1440598049_16.jpg");
        album2.setCanciones(Arrays.asList("Bomba Casera", "Estar Bien", "Mundo Malo"));

        try {
            // Registrar el artista y los álbumes
            losDiabolicos.setAlbumes(Arrays.asList(album1.getId(), album2.getId()));
            artistasDAO.registrar(losDiabolicos);
            System.out.println("### Nuevo ID de Los Diabólicos: " + losDiabolicos.getId());

            album1.setReferenciaArtista(losDiabolicos.getId());
            album2.setReferenciaArtista(losDiabolicos.getId());
            albumesDAO.insercionMasiva(Arrays.asList(album1, album2));
            System.out.println("Álbumes de Los Diabólicos registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(losDiabolicos.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
