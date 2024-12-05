/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.equipo7.persistencia;

/**
 *
 * @author caarl
 */

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.Integrante;
import excepciones.DAOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;




public class PersistenciaCarlosDamian {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ArtistasDAO artistasDAO = null;
        AlbumesDAO albumesDAO = null;

        try {
            artistasDAO = ArtistasDAO.getInstance();
            albumesDAO = AlbumesDAO.getInstance();
        } catch (ConexionException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        // Artista: Coldplay
        Artista coldplay = new Artista();
        coldplay.setNombreArtista("Coldplay");
        coldplay.setTipo("Banda");
        coldplay.setDescripcion("Coldplay es una banda británica de pop rock formada en Londres en 1996. Es conocida por sus melodías pegadizas y letras emotivas.");
        coldplay.setGeneroMusical("Pop Rock");
        coldplay.setImagenURL("https://upload.wikimedia.org/wikipedia/en/4/48/Coldplay_logo.svg");
        coldplay.setIntegrantes(Arrays.asList(
                new Integrante("Chris Martin", "Voz principal, piano, guitarra", new Date(1996), null, true),
                new Integrante("Jonny Buckland", "Guitarra principal", new Date(1996), null, true),
                new Integrante("Guy Berryman", "Bajo", new Date(1996), null, true),
                new Integrante("Will Champion", "Batería, coros", new Date(1997), null, true)
        ));

        // Crear álbumes
        Album parachutes = new Album(new ObjectId());
        Album aRushOfBlood = new Album(new ObjectId());

        // Configurar datos de los álbumes
        parachutes.setNombre("Parachutes");
        parachutes.setFechaLanzamiento(LocalDateTime.of(2000, 7, 10, 0, 0).toInstant(ZoneOffset.UTC));
        parachutes.setGeneroMusical(coldplay.getGeneroMusical());
        parachutes.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a3/Coldplayparachutesalbumcover.jpg");
        parachutes.setCanciones(Arrays.asList(
                "Don't Panic", "Shiver", "Yellow", "Trouble",
                "Sparks", "High Speed", "We Never Change", "Everything's Not Lost"
        ));

        aRushOfBlood.setNombre("A Rush of Blood to the Head");
        aRushOfBlood.setFechaLanzamiento(LocalDateTime.of(2002, 8, 26, 0, 0).toInstant(ZoneOffset.UTC));
        aRushOfBlood.setGeneroMusical(coldplay.getGeneroMusical());
        aRushOfBlood.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/28/Coldplay_-_A_Rush_of_Blood_to_the_Head.png");
        aRushOfBlood.setCanciones(Arrays.asList(
                "Politik", "In My Place", "The Scientist", "Clocks",
                "Green Eyes", "Warning Sign", "A Whisper", "Amsterdam"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            coldplay.setAlbumes(Arrays.asList(
                    parachutes.getId(), aRushOfBlood.getId()
            ));
            artistasDAO.registrar(coldplay);
            System.out.println("### ID nuevo del artista: " + coldplay.getId());

            // Registrar los álbumes en la base de datos
            parachutes.setReferenciaArtista(coldplay.getId());
            aRushOfBlood.setReferenciaArtista(coldplay.getId());
            albumesDAO.insercionMasiva(Arrays.asList(parachutes, aRushOfBlood));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(coldplay.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

       // Artista: Queen
Artista queen = new Artista();
queen.setNombreArtista("Queen");
queen.setTipo("Banda");
queen.setDescripcion("Queen es una banda británica de rock formada en Londres en 1970. Es considerada una de las bandas más influyentes de todos los tiempos, conocida por su estilo teatral y versatilidad musical.");
queen.setGeneroMusical("Rock");
queen.setImagenURL("https://upload.wikimedia.org/wikipedia/en/5/50/Queen_band_logo.jpg");
queen.setIntegrantes(Arrays.asList(
        new Integrante("Freddie Mercury", "Voz principal, piano", new Date(1970), new Date(1991), false),
        new Integrante("Brian May", "Guitarra, coros", new Date(1970), null, true),
        new Integrante("Roger Taylor", "Batería, coros", new Date(1970), null, true),
        new Integrante("John Deacon", "Bajo", new Date(1971), new Date(1997), false)
));

// Crear álbumes
Album aNightAtTheOpera = new Album(new ObjectId());
Album newsOfTheWorld = new Album(new ObjectId());

// Configurar datos de los álbumes
aNightAtTheOpera.setNombre("A Night at the Opera");
aNightAtTheOpera.setFechaLanzamiento(LocalDateTime.of(1975, 11, 21, 0, 0).toInstant(ZoneOffset.UTC));
aNightAtTheOpera.setGeneroMusical(queen.getGeneroMusical());
aNightAtTheOpera.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/8/80/Queen_A_Night_at_the_Opera.png");
aNightAtTheOpera.setCanciones(Arrays.asList(
        "Death on Two Legs", "Lazing on a Sunday Afternoon", "I'm in Love with My Car", 
        "You're My Best Friend", "'39", "Bohemian Rhapsody", "Seaside Rendezvous", "The Prophet's Song"
));

newsOfTheWorld.setNombre("News of the World");
newsOfTheWorld.setFechaLanzamiento(LocalDateTime.of(1977, 10, 28, 0, 0).toInstant(ZoneOffset.UTC));
newsOfTheWorld.setGeneroMusical(queen.getGeneroMusical());
newsOfTheWorld.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/35/Queen_News_Of_The_World.png");
newsOfTheWorld.setCanciones(Arrays.asList(
        "We Will Rock You", "We Are the Champions", "Sheer Heart Attack", "All Dead, All Dead",
        "Spread Your Wings", "Fight from the Inside", "Get Down, Make Love", "Sleeping on the Sidewalk"
));

try {
    // Registrar al artista y obtener el ID generado
    queen.setAlbumes(Arrays.asList(
            aNightAtTheOpera.getId(), newsOfTheWorld.getId()
    ));
    artistasDAO.registrar(queen);
    System.out.println("### ID nuevo del artista: " + queen.getId());

    // Registrar los álbumes en la base de datos
    aNightAtTheOpera.setReferenciaArtista(queen.getId());
    newsOfTheWorld.setReferenciaArtista(queen.getId());
    albumesDAO.insercionMasiva(Arrays.asList(aNightAtTheOpera, newsOfTheWorld));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(queen.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: Michael Jackson
Artista michaelJackson = new Artista();
michaelJackson.setNombreArtista("Michael Jackson");
michaelJackson.setTipo("Solista");
michaelJackson.setDescripcion("Michael Jackson fue un cantante, compositor y bailarín estadounidense conocido como el 'Rey del Pop'. Fue una figura global en la música y el entretenimiento durante más de cuatro décadas.");
michaelJackson.setGeneroMusical("Pop");
michaelJackson.setImagenURL("https://upload.wikimedia.org/wikipedia/en/b/bb/Michael_Jackson.jpg");
michaelJackson.setIntegrantes(Arrays.asList(
        new Integrante("Michael Jackson", "Voz principal, compositor, bailarín", new Date(1964), new Date(2009), false)
));

// Crear álbumes
Album thriller = new Album(new ObjectId());
Album bad = new Album(new ObjectId());

// Configurar datos de los álbumes
thriller.setNombre("Thriller");
thriller.setFechaLanzamiento(LocalDateTime.of(1982, 11, 30, 0, 0).toInstant(ZoneOffset.UTC));
thriller.setGeneroMusical(michaelJackson.getGeneroMusical());
thriller.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png");
thriller.setCanciones(Arrays.asList(
        "Wanna Be Startin' Somethin'", "Baby Be Mine", "The Girl Is Mine", 
        "Thriller", "Beat It", "Billie Jean", "Human Nature", "P.Y.T. (Pretty Young Thing)", 
        "The Lady in My Life"
));

bad.setNombre("Bad");
bad.setFechaLanzamiento(LocalDateTime.of(1987, 8, 31, 0, 0).toInstant(ZoneOffset.UTC));
bad.setGeneroMusical(michaelJackson.getGeneroMusical());
bad.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a1/Michael_Jackson_-_Bad.png");
bad.setCanciones(Arrays.asList(
        "Bad", "The Way You Make Me Feel", "Speed Demon", "Liberian Girl", 
        "Just Good Friends", "Another Part of Me", "Man in the Mirror", 
        "I Just Can't Stop Loving You", "Dirty Diana", "Smooth Criminal"
));

try {
    // Registrar al artista y obtener el ID generado
    michaelJackson.setAlbumes(Arrays.asList(
            thriller.getId(), bad.getId()
    ));
    artistasDAO.registrar(michaelJackson);
    System.out.println("### ID nuevo del artista: " + michaelJackson.getId());

    // Registrar los álbumes en la base de datos
    thriller.setReferenciaArtista(michaelJackson.getId());
    bad.setReferenciaArtista(michaelJackson.getId());
    albumesDAO.insercionMasiva(Arrays.asList(thriller, bad));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(michaelJackson.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: BTS
Artista bts = new Artista();
bts.setNombreArtista("BTS");
bts.setTipo("Banda");
bts.setDescripcion("BTS, también conocidos como Bangtan Sonyeondan o Beyond the Scene, es una boyband surcoreana formada en Seúl en 2013. Se han convertido en un fenómeno global conocido por su música, coreografías impresionantes y letras profundas.");
bts.setGeneroMusical("K-Pop");
bts.setImagenURL("https://upload.wikimedia.org/wikipedia/en/e/eb/BTS_Map_of_the_Soul_Persona.jpg");
bts.setIntegrantes(Arrays.asList(
        new Integrante("RM", "Rapero principal", new Date(2013), null, true),
        new Integrante("Jin", "Vocalista", new Date(2013), null, true),
        new Integrante("Suga", "Rapero", new Date(2013), null, true),
        new Integrante("J-Hope", "Rapero, bailarín", new Date(2013), null, true),
        new Integrante("Jimin", "Vocalista, bailarín", new Date(2013), null, true),
        new Integrante("V", "Vocalista", new Date(2013), null, true),
        new Integrante("Jungkook", "Vocalista principal", new Date(2013), null, true)
));

// Crear álbumes
Album mapOfTheSoulPersona = new Album(new ObjectId());
Album be = new Album(new ObjectId());

// Configurar datos de los álbumes
mapOfTheSoulPersona.setNombre("Map of the Soul: Persona");
mapOfTheSoulPersona.setFechaLanzamiento(LocalDateTime.of(2019, 4, 12, 0, 0).toInstant(ZoneOffset.UTC));
mapOfTheSoulPersona.setGeneroMusical(bts.getGeneroMusical());
mapOfTheSoulPersona.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/eb/BTS_Map_of_the_Soul_Persona.jpg");
mapOfTheSoulPersona.setCanciones(Arrays.asList(
        "Intro: Persona", "Boy With Luv", "Mikrokosmos", 
        "Make It Right", "Home", "Jamais Vu", "Dionysus"
));

be.setNombre("BE");
be.setFechaLanzamiento(LocalDateTime.of(2020, 11, 20, 0, 0).toInstant(ZoneOffset.UTC));
be.setGeneroMusical(bts.getGeneroMusical());
be.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/db/BTS_BE_Album_Cover.jpg");
be.setCanciones(Arrays.asList(
        "Life Goes On", "Fly to My Room", "Blue & Grey", 
        "Skit", "Telepathy", "Dis-ease", "Stay", "Dynamite"
));

try {
    // Registrar al artista y obtener el ID generado
    bts.setAlbumes(Arrays.asList(
            mapOfTheSoulPersona.getId(), be.getId()
    ));
    artistasDAO.registrar(bts);
    System.out.println("### ID nuevo del artista: " + bts.getId());

    // Registrar los álbumes en la base de datos
    mapOfTheSoulPersona.setReferenciaArtista(bts.getId());
    be.setReferenciaArtista(bts.getId());
    albumesDAO.insercionMasiva(Arrays.asList(mapOfTheSoulPersona, be));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(bts.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Ariana Grande
Artista arianaGrande = new Artista();
arianaGrande.setNombreArtista("Ariana Grande");
arianaGrande.setTipo("Solista");
arianaGrande.setDescripcion("Ariana Grande es una cantante, actriz y productora estadounidense conocida por su poderosa voz, influenciada por la música pop, R&B y la música soul. Ha sido una de las artistas más exitosas de la música contemporánea.");
arianaGrande.setGeneroMusical("Pop, R&B");
arianaGrande.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/e6/Ariana_Grande_2019_by_Gage_Skidmore.jpg");
arianaGrande.setIntegrantes(Arrays.asList(
        new Integrante("Ariana Grande", "Vocalista principal", new Date(2013), null, true)
));

// Crear álbumes
Album yoursTruly = new Album(new ObjectId());
Album dangerousWoman = new Album(new ObjectId());
Album sweetener = new Album(new ObjectId());
Album thankUNext = new Album(new ObjectId());

// Configurar datos de los álbumes
yoursTruly.setNombre("Yours Truly");
yoursTruly.setFechaLanzamiento(LocalDateTime.of(2013, 9, 3, 0, 0).toInstant(ZoneOffset.UTC));
yoursTruly.setGeneroMusical(arianaGrande.getGeneroMusical());
yoursTruly.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a9/Ariana_Grande_-_Yours_Truly.png");
yoursTruly.setCanciones(Arrays.asList(
        "Honeymoon Avenue", "Baby I", "Right There", 
        "Tattooed Heart", "The Way", "You'll Never Know", "Almost Is Never Enough"
));

dangerousWoman.setNombre("Dangerous Woman");
dangerousWoman.setFechaLanzamiento(LocalDateTime.of(2016, 5, 20, 0, 0).toInstant(ZoneOffset.UTC));
dangerousWoman.setGeneroMusical(arianaGrande.getGeneroMusical());
dangerousWoman.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/2e/Ariana_Grande_-_Dangerous_Woman.png");
dangerousWoman.setCanciones(Arrays.asList(
        "Moonlight", "Dangerous Woman", "Be Alright", 
        "Into You", "Side to Side", "Let Me Love You", "Greedy"
));

sweetener.setNombre("Sweetener");
sweetener.setFechaLanzamiento(LocalDateTime.of(2018, 8, 17, 0, 0).toInstant(ZoneOffset.UTC));
sweetener.setGeneroMusical(arianaGrande.getGeneroMusical());
sweetener.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a7/Ariana_Grande_-_Sweetener.png");
sweetener.setCanciones(Arrays.asList(
        "Raindrops (An Angel Cried)", "Blazed", "The Light Is Coming", 
        "R.E.M.", "Sweetener", "No Tears Left to Cry", "Successful"
));

thankUNext.setNombre("thank u, next");
thankUNext.setFechaLanzamiento(LocalDateTime.of(2019, 2, 8, 0, 0).toInstant(ZoneOffset.UTC));
thankUNext.setGeneroMusical(arianaGrande.getGeneroMusical());
thankUNext.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/8/83/Ariana_Grande_-_Thank_U_Next.png");
thankUNext.setCanciones(Arrays.asList(
        "Imagine", "Needy", "Thank U, Next", 
        "NASA", "Bloodline", "Fake Smile", "Bad Idea"
));

try {
    // Registrar al artista y obtener el ID generado
    arianaGrande.setAlbumes(Arrays.asList(
            yoursTruly.getId(), dangerousWoman.getId(),
            sweetener.getId(), thankUNext.getId()
    ));
    artistasDAO.registrar(arianaGrande);
    System.out.println("### ID nuevo del artista: " + arianaGrande.getId());

    // Registrar los álbumes en la base de datos
    yoursTruly.setReferenciaArtista(arianaGrande.getId());
    dangerousWoman.setReferenciaArtista(arianaGrande.getId());
    sweetener.setReferenciaArtista(arianaGrande.getId());
    thankUNext.setReferenciaArtista(arianaGrande.getId());
    albumesDAO.insercionMasiva(Arrays.asList(yoursTruly, dangerousWoman, sweetener, thankUNext));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(arianaGrande.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: The Beatles
Artista theBeatles = new Artista();
theBeatles.setNombreArtista("The Beatles");
theBeatles.setTipo("Banda");
theBeatles.setDescripcion("The Beatles fue una banda británica de rock formada en Liverpool en 1960, considerada una de las más influyentes y exitosas de la historia de la música popular. Sus innovadoras composiciones y su estilo único transformaron la música del siglo XX.");
theBeatles.setGeneroMusical("Rock, Pop");
theBeatles.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/a/a1/The_Fab_Four.jpg");
theBeatles.setIntegrantes(Arrays.asList(
        new Integrante("John Lennon", "Voz principal, guitarra rítmica, piano", new Date(1960), new Date(1970), false),
        new Integrante("Paul McCartney", "Bajo, voz principal, guitarra, piano", new Date(1960), new Date(1970), false),
        new Integrante("George Harrison", "Guitarra líder, voz", new Date(1960), new Date(1970), false),
        new Integrante("Ringo Starr", "Batería, percusión, voz", new Date(1960), new Date(1970), false)
));

// Crear álbumes
Album pleasePleaseMe = new Album(new ObjectId());
Album rubberSoul = new Album(new ObjectId());
Album revolver = new Album(new ObjectId());
Album abbeyRoad = new Album(new ObjectId());

// Configurar datos de los álbumes
pleasePleaseMe.setNombre("Please Please Me");
pleasePleaseMe.setFechaLanzamiento(LocalDateTime.of(1963, 3, 22, 0, 0).toInstant(ZoneOffset.UTC));
pleasePleaseMe.setGeneroMusical(theBeatles.getGeneroMusical());
pleasePleaseMe.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/0b/The_Beatles_-_Please_Please_Me.jpg");
pleasePleaseMe.setCanciones(Arrays.asList(
        "I Saw Her Standing There", "Misery", "Anna (Go to Him)", 
        "Chains", "Boys", "Love Me Do", "P.S. I Love You"
));

rubberSoul.setNombre("Rubber Soul");
rubberSoul.setFechaLanzamiento(LocalDateTime.of(1965, 12, 3, 0, 0).toInstant(ZoneOffset.UTC));
rubberSoul.setGeneroMusical(theBeatles.getGeneroMusical());
rubberSoul.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a2/The_Beatles_-_Rubber_Soul.jpg");
rubberSoul.setCanciones(Arrays.asList(
        "Drive My Car", "Norwegian Wood (This Bird Has Flown)", "You Won't See Me", 
        "Nowhere Man", "Think for Yourself", "The Word", "Michelle"
));

revolver.setNombre("Revolver");
revolver.setFechaLanzamiento(LocalDateTime.of(1966, 8, 5, 0, 0).toInstant(ZoneOffset.UTC));
revolver.setGeneroMusical(theBeatles.getGeneroMusical());
revolver.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a4/The_Beatles_-_Revolver.jpg");
revolver.setCanciones(Arrays.asList(
        "Taxman", "Eleanor Rigby", "I'm Only Sleeping", 
        "Love You To", "Here, There and Everywhere", "Yellow Submarine", "She Said She Said"
));

abbeyRoad.setNombre("Abbey Road");
abbeyRoad.setFechaLanzamiento(LocalDateTime.of(1969, 9, 26, 0, 0).toInstant(ZoneOffset.UTC));
abbeyRoad.setGeneroMusical(theBeatles.getGeneroMusical());
abbeyRoad.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/42/The_Beatles_-_Abbey_Road.jpg");
abbeyRoad.setCanciones(Arrays.asList(
        "Come Together", "Something", "Maxwell's Silver Hammer", 
        "Oh! Darling", "Octopus's Garden", "Here Comes the Sun", "Because"
));

try {
    // Registrar al artista y obtener el ID generado
    theBeatles.setAlbumes(Arrays.asList(
            pleasePleaseMe.getId(), rubberSoul.getId(),
            revolver.getId(), abbeyRoad.getId()
    ));
    artistasDAO.registrar(theBeatles);
    System.out.println("### ID nuevo del artista: " + theBeatles.getId());

    // Registrar los álbumes en la base de datos
    pleasePleaseMe.setReferenciaArtista(theBeatles.getId());
    rubberSoul.setReferenciaArtista(theBeatles.getId());
    revolver.setReferenciaArtista(theBeatles.getId());
    abbeyRoad.setReferenciaArtista(theBeatles.getId());
    albumesDAO.insercionMasiva(Arrays.asList(pleasePleaseMe, rubberSoul, revolver, abbeyRoad));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(theBeatles.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: David Bowie
Artista davidBowie = new Artista();
davidBowie.setNombreArtista("David Bowie");
davidBowie.setTipo("Solista");
davidBowie.setDescripcion("David Bowie fue un influyente músico, cantante y compositor británico conocido por su capacidad para reinventarse constantemente a lo largo de su carrera. Su música abarcó una variedad de géneros, incluidos rock, pop, electrónica y soul.");
davidBowie.setGeneroMusical("Rock, Pop, Glam Rock");
davidBowie.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/3/3b/David_Bowie_1974.jpg");
davidBowie.setIntegrantes(Arrays.asList(
        new Integrante("David Bowie", "Voz principal, guitarra, piano, bajo, saxofón", new Date(1963), new Date(2016), false)
));

// Crear álbumes
Album hunkyDory = new Album(new ObjectId());
Album theRiseAndFallOfZiggyStardust = new Album(new ObjectId());
Album youngAmericans = new Album(new ObjectId());
Album heroes = new Album(new ObjectId());

// Configurar datos de los álbumes
hunkyDory.setNombre("Hunky Dory");
hunkyDory.setFechaLanzamiento(LocalDateTime.of(1971, 12, 17, 0, 0).toInstant(ZoneOffset.UTC));
hunkyDory.setGeneroMusical(davidBowie.getGeneroMusical());
hunkyDory.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/14/David_Bowie_-_Hunky_Dory.jpg");
hunkyDory.setCanciones(Arrays.asList(
        "Changes", "Oh! You Pretty Things", "Eight Line Poem", 
        "Life on Mars?", "Kooks", "Quicksand", "The Bewlay Brothers"
));

theRiseAndFallOfZiggyStardust.setNombre("The Rise and Fall of Ziggy Stardust and the Spiders from Mars");
theRiseAndFallOfZiggyStardust.setFechaLanzamiento(LocalDateTime.of(1972, 6, 16, 0, 0).toInstant(ZoneOffset.UTC));
theRiseAndFallOfZiggyStardust.setGeneroMusical(davidBowie.getGeneroMusical());
theRiseAndFallOfZiggyStardust.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/c3/Ziggy_Stardust.jpg");
theRiseAndFallOfZiggyStardust.setCanciones(Arrays.asList(
        "Five Years", "Soul Love", "Moonage Daydream", 
        "Starman", "It Ain't Easy", "Lady Stardust", "Rock 'n' Roll Suicide"
));

youngAmericans.setNombre("Young Americans");
youngAmericans.setFechaLanzamiento(LocalDateTime.of(1975, 3, 7, 0, 0).toInstant(ZoneOffset.UTC));
youngAmericans.setGeneroMusical(davidBowie.getGeneroMusical());
youngAmericans.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6c/Young_Americans_album_cover.jpg");
youngAmericans.setCanciones(Arrays.asList(
        "Young Americans", "Win", "Fame", 
        "Right", "Across the Universe", "Can You Hear Me", "Suffragette City"
));

heroes.setNombre("Heroes");
heroes.setFechaLanzamiento(LocalDateTime.of(1977, 10, 14, 0, 0).toInstant(ZoneOffset.UTC));
heroes.setGeneroMusical(davidBowie.getGeneroMusical());
heroes.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/f/f6/David_Bowie_Heroes.jpg");
heroes.setCanciones(Arrays.asList(
        "Beauty and the Beast", "Joe the Lion", "Heroes", 
        "Sons of the Silent Age", "Blackout", "V-2 Schneider", "Warzawa"
));

try {
    // Registrar al artista y obtener el ID generado
    davidBowie.setAlbumes(Arrays.asList(
            hunkyDory.getId(), theRiseAndFallOfZiggyStardust.getId(),
            youngAmericans.getId(), heroes.getId()
    ));
    artistasDAO.registrar(davidBowie);
    System.out.println("### ID nuevo del artista: " + davidBowie.getId());

    // Registrar los álbumes en la base de datos
    hunkyDory.setReferenciaArtista(davidBowie.getId());
    theRiseAndFallOfZiggyStardust.setReferenciaArtista(davidBowie.getId());
    youngAmericans.setReferenciaArtista(davidBowie.getId());
    heroes.setReferenciaArtista(davidBowie.getId());
    albumesDAO.insercionMasiva(Arrays.asList(hunkyDory, theRiseAndFallOfZiggyStardust, youngAmericans, heroes));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(davidBowie.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: The Rolling Stones
Artista rollingStones = new Artista();
rollingStones.setNombreArtista("The Rolling Stones");
rollingStones.setTipo("Banda");
rollingStones.setDescripcion("The Rolling Stones es una de las bandas más influyentes de la historia del rock, formada en 1962 en Londres. Con su estilo característico de rock y blues, han dejado una huella profunda en la música popular durante más de cinco décadas.");
rollingStones.setGeneroMusical("Rock, Blues Rock, Hard Rock");
rollingStones.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/c/c5/Rolling_Stones_2022.jpg");
rollingStones.setIntegrantes(Arrays.asList(
        new Integrante("Mick Jagger", "Voz principal, armónica", new Date(1962), new Date(), false),
        new Integrante("Keith Richards", "Guitarra líder, coros", new Date(1962), new Date(), false),
        new Integrante("Charlie Watts", "Batería", new Date(1963), new Date(2021), true),
        new Integrante("Ronnie Wood", "Guitarra rítmica, bajo, coros", new Date(1975), new Date(), false)
));

// Crear álbumes
Album outOfOurHeads = new Album(new ObjectId());
Album stickyFingers = new Album(new ObjectId());
Album exileOnMainSt = new Album(new ObjectId());
Album someGirls = new Album(new ObjectId());

// Configurar datos de los álbumes
outOfOurHeads.setNombre("Out of Our Heads");
outOfOurHeads.setFechaLanzamiento(LocalDateTime.of(1965, 7, 30, 0, 0).toInstant(ZoneOffset.UTC));
outOfOurHeads.setGeneroMusical(rollingStones.getGeneroMusical());
outOfOurHeads.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/7/7c/The_Rolling_Stones_-_Out_Of_Our_Heads.jpg");
outOfOurHeads.setCanciones(Arrays.asList(
        "(I Can't Get No) Satisfaction", "The Last Time", "Play with Fire", 
        "As Tears Go By", "Heart of Stone"
));

stickyFingers.setNombre("Sticky Fingers");
stickyFingers.setFechaLanzamiento(LocalDateTime.of(1971, 4, 23, 0, 0).toInstant(ZoneOffset.UTC));
stickyFingers.setGeneroMusical(rollingStones.getGeneroMusical());
stickyFingers.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/4e/StickyFingersalbumcover.jpg");
stickyFingers.setCanciones(Arrays.asList(
        "Brown Sugar", "Wild Horses", "Dead Flowers", 
        "Sway", "Can't You Hear Me Knocking", "You Gotta Move"
));

exileOnMainSt.setNombre("Exile on Main St.");
exileOnMainSt.setFechaLanzamiento(LocalDateTime.of(1972, 5, 12, 0, 0).toInstant(ZoneOffset.UTC));
exileOnMainSt.setGeneroMusical(rollingStones.getGeneroMusical());
exileOnMainSt.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/63/Rolling_Stones_Exile_Album_1972.jpg");
exileOnMainSt.setCanciones(Arrays.asList(
        "Rocks Off", "Tumbling Dice", "Happy", 
        "Sweet Virginia", "Torn and Frayed", "Ventilator Blues"
));

someGirls.setNombre("Some Girls");
someGirls.setFechaLanzamiento(LocalDateTime.of(1978, 6, 9, 0, 0).toInstant(ZoneOffset.UTC));
someGirls.setGeneroMusical(rollingStones.getGeneroMusical());
someGirls.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a5/The_Rolling_Stones_-_Some_Girls.jpg");
someGirls.setCanciones(Arrays.asList(
        "Miss You", "Beast of Burden", "Shattered", 
        "Some Girls", "Lies", "Far Away Eyes"
));

try {
    // Registrar al artista y obtener el ID generado
    rollingStones.setAlbumes(Arrays.asList(
            outOfOurHeads.getId(), stickyFingers.getId(),
            exileOnMainSt.getId(), someGirls.getId()
    ));
    artistasDAO.registrar(rollingStones);
    System.out.println("### ID nuevo del artista: " + rollingStones.getId());

    // Registrar los álbumes en la base de datos
    outOfOurHeads.setReferenciaArtista(rollingStones.getId());
    stickyFingers.setReferenciaArtista(rollingStones.getId());
    exileOnMainSt.setReferenciaArtista(rollingStones.getId());
    someGirls.setReferenciaArtista(rollingStones.getId());
    albumesDAO.insercionMasiva(Arrays.asList(outOfOurHeads, stickyFingers, exileOnMainSt, someGirls));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(rollingStones.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: Nirvana
Artista nirvana = new Artista();
nirvana.setNombreArtista("Nirvana");
nirvana.setTipo("Banda");
nirvana.setDescripcion("Nirvana fue una banda estadounidense de rock alternativo formada en Aberdeen, Washington, en 1987. Fue una de las bandas más influyentes y populares de la escena grunge de Seattle durante los años 90. Con Kurt Cobain como líder, Nirvana dejó un legado musical imborrable, especialmente por su segundo álbum, 'Nevermind'.");
nirvana.setGeneroMusical("Grunge, Rock alternativo");
nirvana.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/1/16/Nirvana_-_Nevermind_%28album_cover%29.jpg");
nirvana.setIntegrantes(Arrays.asList(
        new Integrante("Kurt Cobain", "Voz principal, guitarra", new Date(1987), new Date(1994), true),
        new Integrante("Krist Novoselic", "Bajo, voz", new Date(1987), new Date(), false),
        new Integrante("Dave Grohl", "Batería, voz", new Date(1990), new Date(), false)
));

// Crear álbumes
Album nevermind = new Album(new ObjectId());
Album inUtero = new Album(new ObjectId());
Album bleach = new Album(new ObjectId());

// Configurar datos de los álbumes
nevermind.setNombre("Nevermind");
nevermind.setFechaLanzamiento(LocalDateTime.of(1991, 9, 24, 0, 0).toInstant(ZoneOffset.UTC));
nevermind.setGeneroMusical(nirvana.getGeneroMusical());
nevermind.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/3d/NirvanaNevermindalbumcover.jpg");
nevermind.setCanciones(Arrays.asList(
        "Smells Like Teen Spirit", "Come as You Are", "Breed", "Lithium",
        "Polly", "Territorial Pissings", "On a Plain", "Something in the Way"
));

inUtero.setNombre("In Utero");
inUtero.setFechaLanzamiento(LocalDateTime.of(1993, 9, 13, 0, 0).toInstant(ZoneOffset.UTC));
inUtero.setGeneroMusical(nirvana.getGeneroMusical());
inUtero.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/0b/NirvanaInUteroalbumcover.jpg");
inUtero.setCanciones(Arrays.asList(
        "Serve the Servants", "Scentless Apprentice", "Heart-Shaped Box", "Rape Me",
        "Frances Farmer Will Have Her Revenge on Seattle", "Dumb", "Very Ape"
));

bleach.setNombre("Bleach");
bleach.setFechaLanzamiento(LocalDateTime.of(1989, 6, 15, 0, 0).toInstant(ZoneOffset.UTC));
bleach.setGeneroMusical(nirvana.getGeneroMusical());
bleach.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/f/f4/Nirvana_Bleach.jpg");
bleach.setCanciones(Arrays.asList(
        "Blew", "Floyd the Barber", "About a Girl", "School",
        "Love Buzz", "Paper Cuts", "Negative Creep", "Scoff"
));

try {
    // Registrar al artista y obtener el ID generado
    nirvana.setAlbumes(Arrays.asList(
            nevermind.getId(), inUtero.getId(),
            bleach.getId()
    ));
    artistasDAO.registrar(nirvana);
    System.out.println("### ID nuevo del artista: " + nirvana.getId());

    // Registrar los álbumes en la base de datos
    nevermind.setReferenciaArtista(nirvana.getId());
    inUtero.setReferenciaArtista(nirvana.getId());
    bleach.setReferenciaArtista(nirvana.getId());
    albumesDAO.insercionMasiva(Arrays.asList(nevermind, inUtero, bleach));
    System.out.println("Álbumes registrados correctamente.");
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Consultar álbumes por artista
try {
    System.out.println(albumesDAO.obtenerPorArtista(nirvana.getId()));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


 // Artista: Daft Punk
        Artista daftPunk = new Artista();
        daftPunk.setNombreArtista("Daft Punk");
        daftPunk.setTipo("Dúo");
        daftPunk.setDescripcion("Daft Punk es un dúo francés de música electrónica formado en 1993, conocido por sus innovadoras contribuciones al género house y su estilo visual distintivo.");
        daftPunk.setGeneroMusical("Electronic, House, Disco");
        daftPunk.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/e1/Daft_Punk_-_Alive_2007.jpg");
        daftPunk.setIntegrantes(Arrays.asList(
                new Integrante("Thomas Bangalter", "Teclados, sintetizadores, programación, guitarra", new Date(1993), new Date(2021), true),
                new Integrante("Guy-Manuel de Homem-Christo", "Teclados, sintetizadores, programación", new Date(1993), new Date(2021), true)
        ));

        // Crear álbumes
        Album Homework = new Album(new ObjectId());
        Album Discovery = new Album(new ObjectId());
        Album RandomAccessMemories = new Album(new ObjectId());
        Album Alive2007 = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Homework.setNombre("Homework");
        Homework.setFechaLanzamiento(LocalDateTime.of(1997, 1, 20, 0, 0).toInstant(ZoneOffset.UTC));
        Homework.setGeneroMusical(daftPunk.getGeneroMusical());
        Homework.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/1b/Daft_Punk_-_Homework.jpg");
        Homework.setCanciones(Arrays.asList(
                "Da Funk", "Around the World", "Rollin' & Scratchin'", "Teachers", "High Fidelity"
        ));

        Discovery.setNombre("Discovery");
        Discovery.setFechaLanzamiento(LocalDateTime.of(2001, 3, 12, 0, 0).toInstant(ZoneOffset.UTC));
        Discovery.setGeneroMusical(daftPunk.getGeneroMusical());
        Discovery.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/9/96/Daft_Punk_-_Discovery.jpg");
        Discovery.setCanciones(Arrays.asList(
                "One More Time", "Aerodynamic", "Digital Love", "Harder, Better, Faster, Stronger"
        ));

        RandomAccessMemories.setNombre("Random Access Memories");
        RandomAccessMemories.setFechaLanzamiento(LocalDateTime.of(2013, 5, 17, 0, 0).toInstant(ZoneOffset.UTC));
        RandomAccessMemories.setGeneroMusical(daftPunk.getGeneroMusical());
        RandomAccessMemories.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/d1/Daft_Punk_-_Random_Access_Memories.png");
        RandomAccessMemories.setCanciones(Arrays.asList(
                "Give Life Back to Music", "The Game of Love", "Instant Crush", "Get Lucky"
        ));

        Alive2007.setNombre("Alive 2007");
        Alive2007.setFechaLanzamiento(LocalDateTime.of(2007, 12, 12, 0, 0).toInstant(ZoneOffset.UTC));
        Alive2007.setGeneroMusical(daftPunk.getGeneroMusical());
        Alive2007.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a6/Daft_Punk_-_Alive_2007.jpg");
        Alive2007.setCanciones(Arrays.asList(
                "Robot Rock / Oh Yeah", "Touch It / Technologic", "Television Rules the Nation / Crescendolls"
        ));

        try {
            // Registrar al artista y obtener el ID generado
            daftPunk.setAlbumes(Arrays.asList(
                    Homework.getId(), Discovery.getId(),
                    RandomAccessMemories.getId(), Alive2007.getId()
            ));
            artistasDAO.registrar(daftPunk);
            System.out.println("### ID nuevo del artista: " + daftPunk.getId());

            // Registrar los álbumes en la base de datos
            Homework.setReferenciaArtista(daftPunk.getId());
            Discovery.setReferenciaArtista(daftPunk.getId());
            RandomAccessMemories.setReferenciaArtista(daftPunk.getId());
            Alive2007.setReferenciaArtista(daftPunk.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Homework, Discovery, RandomAccessMemories, Alive2007));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(daftPunk.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         // Artista: Deadmau5
        Artista deadmau5 = new Artista();
        deadmau5.setNombreArtista("Deadmau5");
        deadmau5.setTipo("Dúo");
        deadmau5.setDescripcion("Deadmau5 es un productor y DJ canadiense de música electrónica conocido por su estilo progresivo house y sus shows en vivo con una máscara de ratón.");
        deadmau5.setGeneroMusical("Electronic, Progressive House");
        deadmau5.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/e5/Deadmau5_2014.jpg");
        deadmau5.setIntegrantes(Arrays.asList(
                new Integrante("Joel Zimmerman", "Productor, DJ", new Date(2000), new Date(2021), true)
        ));

        // Crear álbumes
        Album RandomAlbum1 = new Album(new ObjectId());
        Album RandomAlbum2 = new Album(new ObjectId());

        // Configurar datos de los álbumes
        RandomAlbum1.setNombre("Random Album 1");
        RandomAlbum1.setFechaLanzamiento(LocalDateTime.of(2010, 10, 20, 0, 0).toInstant(ZoneOffset.UTC));
        RandomAlbum1.setGeneroMusical(deadmau5.getGeneroMusical());
        RandomAlbum1.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/commons/e/e5/Deadmau5_2014.jpg");
        RandomAlbum1.setCanciones(Arrays.asList("Track 1", "Track 2", "Track 3"));

        RandomAlbum2.setNombre("Random Album 2");
        RandomAlbum2.setFechaLanzamiento(LocalDateTime.of(2012, 3, 5, 0, 0).toInstant(ZoneOffset.UTC));
        RandomAlbum2.setGeneroMusical(deadmau5.getGeneroMusical());
        RandomAlbum2.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/commons/e/e5/Deadmau5_2014.jpg");
        RandomAlbum2.setCanciones(Arrays.asList("Track 1", "Track 2", "Track 3"));

        try {
            // Registrar al artista y obtener el ID generado
            deadmau5.setAlbumes(Arrays.asList(RandomAlbum1.getId(), RandomAlbum2.getId()));
            artistasDAO.registrar(deadmau5);
            System.out.println("### ID nuevo del artista: " + deadmau5.getId());

            // Registrar los álbumes en la base de datos
            RandomAlbum1.setReferenciaArtista(deadmau5.getId());
            RandomAlbum2.setReferenciaArtista(deadmau5.getId());
            albumesDAO.insercionMasiva(Arrays.asList(RandomAlbum1, RandomAlbum2));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(deadmau5.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         // Artista: Flume
        Artista flume = new Artista();
        flume.setNombreArtista("Flume");
        flume.setTipo("Solista");
        flume.setDescripcion("Flume es un productor musical y DJ australiano conocido por su estilo único dentro del género future bass.");
        flume.setGeneroMusical("Electronic, Future Bass");
        flume.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/7/73/Flume_%28artist%29.jpg");
        flume.setIntegrantes(Arrays.asList(
                new Integrante("Harley Edward Streten", "Productor, DJ", new Date(2011), new Date(2021), true)
        ));

        // Crear álbumes
        Album Skin = new Album(new ObjectId());
        Album HiThisIsFlume = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Skin.setNombre("Skin");
        Skin.setFechaLanzamiento(LocalDateTime.of(2016, 5, 27, 0, 0).toInstant(ZoneOffset.UTC));
        Skin.setGeneroMusical(flume.getGeneroMusical());
        Skin.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/d0/Flume_Skin.jpg");
        Skin.setCanciones(Arrays.asList("Never Be Like You", "Say It", "Lose It"));

        HiThisIsFlume.setNombre("Hi This Is Flume");
        HiThisIsFlume.setFechaLanzamiento(LocalDateTime.of(2019, 11, 9, 0, 0).toInstant(ZoneOffset.UTC));
        HiThisIsFlume.setGeneroMusical(flume.getGeneroMusical());
        HiThisIsFlume.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/cf/Hi_This_Is_Flume.jpg");
        HiThisIsFlume.setCanciones(Arrays.asList("The Difference", "Rushing Back", "Hyperreal"));

        try {
            // Registrar al artista y obtener el ID generado
            flume.setAlbumes(Arrays.asList(Skin.getId(), HiThisIsFlume.getId()));
            artistasDAO.registrar(flume);
            System.out.println("### ID nuevo del artista: " + flume.getId());

            // Registrar los álbumes en la base de datos
            Skin.setReferenciaArtista(flume.getId());
            HiThisIsFlume.setReferenciaArtista(flume.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Skin, HiThisIsFlume));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(flume.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Artista: Skrillex
        Artista skrillex = new Artista();
        skrillex.setNombreArtista("Skrillex");
        skrillex.setTipo("Solista");
        skrillex.setDescripcion("Skrillex es un productor y DJ estadounidense conocido por su estilo dubstep y por revolucionar el sonido de la música electrónica moderna.");
        skrillex.setGeneroMusical("Dubstep, Electro House");
        skrillex.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/0/0e/Skrillex_in_2011.jpg");
        skrillex.setIntegrantes(Arrays.asList(
                new Integrante("Sonny John Moore", "Productor, DJ", new Date(2004), new Date(2021), true)
        ));

        // Crear álbumes
        Album ScaryMonstersAndNiceSprites = new Album(new ObjectId());
        Album Recess = new Album(new ObjectId());

        // Configurar datos de los álbumes
        ScaryMonstersAndNiceSprites.setNombre("Scary Monsters and Nice Sprites");
        ScaryMonstersAndNiceSprites.setFechaLanzamiento(LocalDateTime.of(2010, 10, 22, 0, 0).toInstant(ZoneOffset.UTC));
        ScaryMonstersAndNiceSprites.setGeneroMusical(skrillex.getGeneroMusical());
        ScaryMonstersAndNiceSprites.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/65/Skrillex_-_Scary_Monsters_and_Nice_Sprites.jpg");
        ScaryMonstersAndNiceSprites.setCanciones(Arrays.asList("Scary Monsters and Nice Sprites", "Rock n' Roll (Will Take You to the Mountain)", "Kill Everybody"));

        Recess.setNombre("Recess");
        Recess.setFechaLanzamiento(LocalDateTime.of(2014, 3, 18, 0, 0).toInstant(ZoneOffset.UTC));
        Recess.setGeneroMusical(skrillex.getGeneroMusical());
        Recess.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/5/52/Skrillex_-_Recess.jpg");
        Recess.setCanciones(Arrays.asList("Recess", "Stranger", "All Is Fair in Love and Brostep"));

        try {
            // Registrar al artista y obtener el ID generado
            skrillex.setAlbumes(Arrays.asList(ScaryMonstersAndNiceSprites.getId(), Recess.getId()));
            artistasDAO.registrar(skrillex);
            System.out.println("### ID nuevo del artista: " + skrillex.getId());

            // Registrar los álbumes en la base de datos
            ScaryMonstersAndNiceSprites.setReferenciaArtista(skrillex.getId());
            Recess.setReferenciaArtista(skrillex.getId());
            albumesDAO.insercionMasiva(Arrays.asList(ScaryMonstersAndNiceSprites, Recess));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(skrillex.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        // Artista: Marshmello
        Artista marshmello = new Artista();
        marshmello.setNombreArtista("Marshmello");
        marshmello.setTipo("Solista");
        marshmello.setDescripcion("Marshmello es un DJ y productor musical estadounidense conocido por sus composiciones de música electrónica y por su famoso casco de marshmallow.");
        marshmello.setGeneroMusical("Electronic, Future Bass, Trap");
        marshmello.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/a/a2/Marshmello_2019.jpg");
        marshmello.setIntegrantes(Arrays.asList(
                new Integrante("Chris Comstock", "Productor, DJ", new Date(2015), new Date(2021), true)
        ));

        // Crear álbumes
        Album Joytime = new Album(new ObjectId());
        Album JoytimeII = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Joytime.setNombre("Joytime");
        Joytime.setFechaLanzamiento(LocalDateTime.of(2016, 2, 22, 0, 0).toInstant(ZoneOffset.UTC));
        Joytime.setGeneroMusical(marshmello.getGeneroMusical());
        Joytime.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/c5/Marshmello_-_Joytime.jpg");
        Joytime.setCanciones(Arrays.asList("Keep It Mello", "Find Me", "Ritual"));

        JoytimeII.setNombre("Joytime II");
        JoytimeII.setFechaLanzamiento(LocalDateTime.of(2018, 6, 22, 0, 0).toInstant(ZoneOffset.UTC));
        JoytimeII.setGeneroMusical(marshmello.getGeneroMusical());
        JoytimeII.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6d/Marshmello_-_Joytime_II.jpg");
        JoytimeII.setCanciones(Arrays.asList("Tell Me", "Together", "Happier"));

        try {
            // Registrar al artista y obtener el ID generado
            marshmello.setAlbumes(Arrays.asList(Joytime.getId(), JoytimeII.getId()));
            artistasDAO.registrar(marshmello);
            System.out.println("### ID nuevo del artista: " + marshmello.getId());

            // Registrar los álbumes en la base de datos
            Joytime.setReferenciaArtista(marshmello.getId());
            JoytimeII.setReferenciaArtista(marshmello.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Joytime, JoytimeII));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(marshmello.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Artista: Avicii
        Artista avicii = new Artista();
        avicii.setNombreArtista("Avicii");
        avicii.setTipo("Solista");
        avicii.setDescripcion("Avicii, cuyo nombre real era Tim Bergling, fue un DJ y productor sueco que alcanzó fama mundial con su música electrónica melódica.");
        avicii.setGeneroMusical("Progressive House, Electro House");
        avicii.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/a/a0/Avicii_in_2016.jpg");
        avicii.setIntegrantes(Arrays.asList(
                new Integrante("Tim Bergling", "Productor, DJ", new Date(2006), new Date(2018), true)
        ));

        // Crear álbumes
        Album True = new Album(new ObjectId());
        Album Stories = new Album(new ObjectId());

        // Configurar datos de los álbumes
        True.setNombre("True");
        True.setFechaLanzamiento(LocalDateTime.of(2013, 9, 13, 0, 0).toInstant(ZoneOffset.UTC));
        True.setGeneroMusical(avicii.getGeneroMusical());
        True.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/1d/Avicii_-_True.png");
        True.setCanciones(Arrays.asList("Wake Me Up", "Hey Brother", "Addicted to You"));

        Stories.setNombre("Stories");
        Stories.setFechaLanzamiento(LocalDateTime.of(2015, 10, 2, 0, 0).toInstant(ZoneOffset.UTC));
        Stories.setGeneroMusical(avicii.getGeneroMusical());
        Stories.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/69/Avicii_Stories_Album_2015.png");
        Stories.setCanciones(Arrays.asList("Waiting for Love", "Pure Grinding", "For a Better Day"));

        try {
            // Registrar al artista y obtener el ID generado
            avicii.setAlbumes(Arrays.asList(True.getId(), Stories.getId()));
            artistasDAO.registrar(avicii);
            System.out.println("### ID nuevo del artista: " + avicii.getId());

            // Registrar los álbumes en la base de datos
            True.setReferenciaArtista(avicii.getId());
            Stories.setReferenciaArtista(avicii.getId());
            albumesDAO.insercionMasiva(Arrays.asList(True, Stories));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(avicii.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         // Artista: Zedd
        Artista zedd = new Artista();
        zedd.setNombreArtista("Zedd");
        zedd.setTipo("Solista");
        zedd.setDescripcion("Zedd, cuyo nombre real es Anton Zaslavski, es un DJ y productor alemán conocido por sus éxitos en el género de electro house y música de baile electrónica.");
        zedd.setGeneroMusical("Electro House, Progressive House");
        zedd.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/c/cd/Zedd_2015.jpg");
        zedd.setIntegrantes(Arrays.asList(
                new Integrante("Anton Zaslavski", "Productor, DJ", new Date(2009), new Date(2021), true)
        ));

        // Crear álbumes
        Album Clarity = new Album(new ObjectId());
        Album TrueColors = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Clarity.setNombre("Clarity");
        Clarity.setFechaLanzamiento(LocalDateTime.of(2012, 10, 2, 0, 0).toInstant(ZoneOffset.UTC));
        Clarity.setGeneroMusical(zedd.getGeneroMusical());
        Clarity.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6a/Zedd_Clarity_Album.jpg");
        Clarity.setCanciones(Arrays.asList("Clarity", "Stay", "Spectrum"));

        TrueColors.setNombre("True Colors");
        TrueColors.setFechaLanzamiento(LocalDateTime.of(2015, 5, 18, 0, 0).toInstant(ZoneOffset.UTC));
        TrueColors.setGeneroMusical(zedd.getGeneroMusical());
        TrueColors.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/7/7e/Zedd_True_Colors.jpg");
        TrueColors.setCanciones(Arrays.asList("I Want You to Know", "Beautiful Now", "Addicted to a Memory"));

        try {
            // Registrar al artista y obtener el ID generado
            zedd.setAlbumes(Arrays.asList(Clarity.getId(), TrueColors.getId()));
            artistasDAO.registrar(zedd);
            System.out.println("### ID nuevo del artista: " + zedd.getId());

            // Registrar los álbumes en la base de datos
            Clarity.setReferenciaArtista(zedd.getId());
            TrueColors.setReferenciaArtista(zedd.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Clarity, TrueColors));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(zedd.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         // Artista: Martin Garrix
        Artista martinGarrix = new Artista();
        martinGarrix.setNombreArtista("Martin Garrix");
        martinGarrix.setTipo("Solista");
        martinGarrix.setDescripcion("Martin Garrix es un DJ y productor neerlandés conocido por sus éxitos en la música electrónica y su participación en festivales de renombre.");
        martinGarrix.setGeneroMusical("Progressive House, Big Room House");
        martinGarrix.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/6/66/Martin_Garrix_2016.jpg");
        martinGarrix.setIntegrantes(Arrays.asList(
                new Integrante("Martijn Gerard Garritsen", "Productor, DJ", new Date(2012), new Date(2021), true)
        ));

        // Crear álbumes
        Album GoldSkies = new Album(new ObjectId());
        Album Heaven = new Album(new ObjectId());

        // Configurar datos de los álbumes
        GoldSkies.setNombre("Gold Skies");
        GoldSkies.setFechaLanzamiento(LocalDateTime.of(2014, 9, 19, 0, 0).toInstant(ZoneOffset.UTC));
        GoldSkies.setGeneroMusical(martinGarrix.getGeneroMusical());
        GoldSkies.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/35/Gold_Skies.jpg");
        GoldSkies.setCanciones(Arrays.asList("Animals", "Tremor", "Wizard"));

        Heaven.setNombre("Heaven");
        Heaven.setFechaLanzamiento(LocalDateTime.of(2017, 10, 12, 0, 0).toInstant(ZoneOffset.UTC));
        Heaven.setGeneroMusical(martinGarrix.getGeneroMusical());
        Heaven.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/69/Heaven_Martin_Garrix.jpg");
        Heaven.setCanciones(Arrays.asList("Heaven", "No Sleep", "Lions in the Wild"));

        try {
            // Registrar al artista y obtener el ID generado
            martinGarrix.setAlbumes(Arrays.asList(GoldSkies.getId(), Heaven.getId()));
            artistasDAO.registrar(martinGarrix);
            System.out.println("### ID nuevo del artista: " + martinGarrix.getId());

            // Registrar los álbumes en la base de datos
            GoldSkies.setReferenciaArtista(martinGarrix.getId());
            Heaven.setReferenciaArtista(martinGarrix.getId());
            albumesDAO.insercionMasiva(Arrays.asList(GoldSkies, Heaven));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(martinGarrix.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         // Artista: The Chainsmokers
        Artista theChainsmokers = new Artista();
        theChainsmokers.setNombreArtista("The Chainsmokers");
        theChainsmokers.setTipo("Dúo");
        theChainsmokers.setDescripcion("The Chainsmokers es un dúo estadounidense de música electrónica conocido por sus exitosos sencillos en el género de música electrónica pop.");
        theChainsmokers.setGeneroMusical("Electro Pop, Future Bass");
        theChainsmokers.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/d/d1/The_Chainsmokers_2017.png");
        theChainsmokers.setIntegrantes(Arrays.asList(
                new Integrante("Andrew Taggart", "DJ, productor", new Date(2012), new Date(2021), true),
                new Integrante("Alex Pall", "Productor, DJ", new Date(2012), new Date(2021), true)
        ));

        // Crear álbumes
        Album Memories = new Album(new ObjectId());
        Album WorldWarJoy = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Memories.setNombre("Memories... Do Not Open");
        Memories.setFechaLanzamiento(LocalDateTime.of(2017, 4, 7, 0, 0).toInstant(ZoneOffset.UTC));
        Memories.setGeneroMusical(theChainsmokers.getGeneroMusical());
        Memories.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/f/f7/The_Chainsmokers_-_Memories..._Do_Not_Open.png");
        Memories.setCanciones(Arrays.asList("Paris", "Something Just Like This", "The One"));

        WorldWarJoy.setNombre("World War Joy");
        WorldWarJoy.setFechaLanzamiento(LocalDateTime.of(2019, 12, 13, 0, 0).toInstant(ZoneOffset.UTC));
        WorldWarJoy.setGeneroMusical(theChainsmokers.getGeneroMusical());
        WorldWarJoy.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/7/74/The_Chainsmokers_-_World_War_Joy_Album.jpg");
        WorldWarJoy.setCanciones(Arrays.asList("Who Do You Love", "Call You Mine", "Do You Mean"));

        try {
            // Registrar al artista y obtener el ID generado
            theChainsmokers.setAlbumes(Arrays.asList(Memories.getId(), WorldWarJoy.getId()));
            artistasDAO.registrar(theChainsmokers);
            System.out.println("### ID nuevo del artista: " + theChainsmokers.getId());

            // Registrar los álbumes en la base de datos
            Memories.setReferenciaArtista(theChainsmokers.getId());
            WorldWarJoy.setReferenciaArtista(theChainsmokers.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Memories, WorldWarJoy));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(theChainsmokers.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        // Artista: Phonk
        Artista phonk = new Artista();
        phonk.setNombreArtista("Phonk");
        phonk.setTipo("Solista");
        phonk.setDescripcion("Phonk es un subgénero del hip-hop y rap que incorpora influencias del rap del sur de Estados Unidos y elementos de la música electrónica.");
        phonk.setGeneroMusical("Phonk");
        phonk.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/7/7e/Phonk_Music.jpg");
        phonk.setIntegrantes(Arrays.asList(
                new Integrante("Varios artistas", "Productores, MCs", new Date(2010), new Date(2021), false)
        ));

        // Crear álbumes
        Album MemphisPhonk = new Album(new ObjectId());
        Album PhonkVibes = new Album(new ObjectId());

        // Configurar datos de los álbumes
        MemphisPhonk.setNombre("Memphis Phonk");
        MemphisPhonk.setFechaLanzamiento(LocalDateTime.of(2014, 6, 14, 0, 0).toInstant(ZoneOffset.UTC));
        MemphisPhonk.setGeneroMusical(phonk.getGeneroMusical());
        MemphisPhonk.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/da/Memphis_Phonk.jpg");
        MemphisPhonk.setCanciones(Arrays.asList("Ridin' Slow", "Chopped & Screwed", "Flipping the Script"));

        PhonkVibes.setNombre("Phonk Vibes");
        PhonkVibes.setFechaLanzamiento(LocalDateTime.of(2018, 7, 15, 0, 0).toInstant(ZoneOffset.UTC));
        PhonkVibes.setGeneroMusical(phonk.getGeneroMusical());
        PhonkVibes.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/5/5d/Phonk_Vibes.jpg");
        PhonkVibes.setCanciones(Arrays.asList("Old School Phonk", "Memphis Blues", "Dark Nights"));

        try {
            // Registrar al artista y obtener el ID generado
            phonk.setAlbumes(Arrays.asList(MemphisPhonk.getId(), PhonkVibes.getId()));
            artistasDAO.registrar(phonk);
            System.out.println("### ID nuevo del artista: " + phonk.getId());

            // Registrar los álbumes en la base de datos
            MemphisPhonk.setReferenciaArtista(phonk.getId());
            PhonkVibes.setReferenciaArtista(phonk.getId());
            albumesDAO.insercionMasiva(Arrays.asList(MemphisPhonk, PhonkVibes));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(phonk.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
         // Artista: DJ Smokey
        Artista djSmokey = new Artista();
        djSmokey.setNombreArtista("DJ Smokey");
        djSmokey.setTipo("Solista");
        djSmokey.setDescripcion("DJ Smokey es un productor y DJ conocido por su estilo en el trap y el phonk, mezclando influencias del rap y la música electrónica.");
        djSmokey.setGeneroMusical("Trap, Phonk");
        djSmokey.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/5/55/DJ_Smokey.jpg");
        djSmokey.setIntegrantes(Arrays.asList(
                new Integrante("DJ Smokey", "Productor, DJ", new Date(2012), new Date(2021), true)
        ));

        // Crear álbumes
        Album SmokeySeason = new Album(new ObjectId());
        Album Phonkology = new Album(new ObjectId());

        // Configurar datos de los álbumes
        SmokeySeason.setNombre("Smokey Season");
        SmokeySeason.setFechaLanzamiento(LocalDateTime.of(2015, 11, 2, 0, 0).toInstant(ZoneOffset.UTC));
        SmokeySeason.setGeneroMusical(djSmokey.getGeneroMusical());
        SmokeySeason.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/aa/Smokey_Season.jpg");
        SmokeySeason.setCanciones(Arrays.asList("Phonk Radio", "Midnight Cruise", "Ghosts in the City"));

        Phonkology.setNombre("Phonkology");
        Phonkology.setFechaLanzamiento(LocalDateTime.of(2018, 6, 5, 0, 0).toInstant(ZoneOffset.UTC));
        Phonkology.setGeneroMusical(djSmokey.getGeneroMusical());
        Phonkology.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/f/fe/Phonkology.jpg");
        Phonkology.setCanciones(Arrays.asList("Wicked Minds", "Lost Souls", "Summer Nights"));

        try {
            // Registrar al artista y obtener el ID generado
            djSmokey.setAlbumes(Arrays.asList(SmokeySeason.getId(), Phonkology.getId()));
            artistasDAO.registrar(djSmokey);
            System.out.println("### ID nuevo del artista: " + djSmokey.getId());

            // Registrar los álbumes en la base de datos
            SmokeySeason.setReferenciaArtista(djSmokey.getId());
            Phonkology.setReferenciaArtista(djSmokey.getId());
            albumesDAO.insercionMasiva(Arrays.asList(SmokeySeason, Phonkology));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(djSmokey.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        



  

        // Artista: Freddie Dredd
        Artista freddieDredd = new Artista();
        freddieDredd.setNombreArtista("Freddie Dredd");
        freddieDredd.setTipo("Solista");
        freddieDredd.setDescripcion("Freddie Dredd es un productor y rapero conocido por su estilo único de rap lo-fi con influencias del trap y el phonk.");
        freddieDredd.setGeneroMusical("Phonk, Trap");
        freddieDredd.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/1/19/Freddie_Dredd_2018.jpg");
        freddieDredd.setIntegrantes(Arrays.asList(
                new Integrante("Freddie Dredd", "Productor, MC", new Date(2016), new Date(2021), true)
        ));

        // Crear álbumes
        Album Dredd = new Album(new ObjectId());
        Album Fear = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Dredd.setNombre("Dredd");
        Dredd.setFechaLanzamiento(LocalDateTime.of(2018, 3, 12, 0, 0).toInstant(ZoneOffset.UTC));
        Dredd.setGeneroMusical(freddieDredd.getGeneroMusical());
        Dredd.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a5/Dredd_Freddie_Dredd.jpg");
        Dredd.setCanciones(Arrays.asList("Opaul", "Shameless", "Feels"));

        Fear.setNombre("Fear");
        Fear.setFechaLanzamiento(LocalDateTime.of(2020, 9, 17, 0, 0).toInstant(ZoneOffset.UTC));
        Fear.setGeneroMusical(freddieDredd.getGeneroMusical());
        Fear.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/e2/Freddie_Dredd_Fear_Album.jpg");
        Fear.setCanciones(Arrays.asList("Death Note", "The Underground", "Let Me In"));

        try {
            // Registrar al artista y obtener el ID generado
            freddieDredd.setAlbumes(Arrays.asList(Dredd.getId(), Fear.getId()));
            artistasDAO.registrar(freddieDredd);
            System.out.println("### ID nuevo del artista: " + freddieDredd.getId());

            // Registrar los álbumes en la base de datos
            Dredd.setReferenciaArtista(freddieDredd.getId());
            Fear.setReferenciaArtista(freddieDredd.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Dredd, Fear));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(freddieDredd.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Artista: Kordhell
        Artista kordhell = new Artista();
        kordhell.setNombreArtista("Kordhell");
        kordhell.setTipo("Solista");
        kordhell.setDescripcion("Kordhell es un productor de música electrónica y rap que crea sonidos agresivos, combinando elementos del phonk y el horrorcore.");
        kordhell.setGeneroMusical("Phonk, Horrorcore");
        kordhell.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/e1/Kordhell.jpg");
        kordhell.setIntegrantes(Arrays.asList(
                new Integrante("Kordhell", "Productor, MC", new Date(2016), new Date(2021), true)
        ));

        // Crear álbumes
        Album Hellraiser = new Album(new ObjectId());
        Album DeathThreat = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Hellraiser.setNombre("Hellraiser");
        Hellraiser.setFechaLanzamiento(LocalDateTime.of(2017, 5, 19, 0, 0).toInstant(ZoneOffset.UTC));
        Hellraiser.setGeneroMusical(kordhell.getGeneroMusical());
        Hellraiser.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a0/Hellraiser_Kordhell.jpg");
        Hellraiser.setCanciones(Arrays.asList("Unleash Hell", "Inferno", "Nightmare"));

        DeathThreat.setNombre("Death Threat");
        DeathThreat.setFechaLanzamiento(LocalDateTime.of(2019, 2, 3, 0, 0).toInstant(ZoneOffset.UTC));
        DeathThreat.setGeneroMusical(kordhell.getGeneroMusical());
        DeathThreat.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/4e/DeathThreat_Kordhell.jpg");
        DeathThreat.setCanciones(Arrays.asList("Dead Inside", "Total Chaos", "Hell's Fury"));

        try {
            // Registrar al artista y obtener el ID generado
            kordhell.setAlbumes(Arrays.asList(Hellraiser.getId(), DeathThreat.getId()));
            artistasDAO.registrar(kordhell);
            System.out.println("### ID nuevo del artista: " + kordhell.getId());

            // Registrar los álbumes en la base de datos
            Hellraiser.setReferenciaArtista(kordhell.getId());
            DeathThreat.setReferenciaArtista(kordhell.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Hellraiser, DeathThreat));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(kordhell.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Artista: HAARPER
        Artista haarper = new Artista();
        haarper.setNombreArtista("HAARPER");
        haarper.setTipo("Solista");
        haarper.setDescripcion("HAARPER es un artista electrónico que fusiona elementos de la música house, trap y future bass.");
        haarper.setGeneroMusical("House, Future Bass, Trap");
        haarper.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/4/4f/HAARPER.jpg");
        haarper.setIntegrantes(Arrays.asList(
                new Integrante("HAARPER", "Productor", new Date(2015), new Date(2021), true)
        ));

        // Crear álbumes
        Album Echoes = new Album(new ObjectId());
        Album Nights = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Echoes.setNombre("Echoes");
        Echoes.setFechaLanzamiento(LocalDateTime.of(2017, 10, 8, 0, 0).toInstant(ZoneOffset.UTC));
        Echoes.setGeneroMusical(haarper.getGeneroMusical());
        Echoes.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a6/Echoes_HAARPER.jpg");
        Echoes.setCanciones(Arrays.asList("Lost in Time", "Vibes", "Faded"));

        Nights.setNombre("Nights");
        Nights.setFechaLanzamiento(LocalDateTime.of(2019, 3, 21, 0, 0).toInstant(ZoneOffset.UTC));
        Nights.setGeneroMusical(haarper.getGeneroMusical());
        Nights.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/9/94/Nights_HAARPER.jpg");
        Nights.setCanciones(Arrays.asList("Nocturnal", "Shadows", "Waves"));

        try {
            // Registrar al artista y obtener el ID generado
            haarper.setAlbumes(Arrays.asList(Echoes.getId(), Nights.getId()));
            artistasDAO.registrar(haarper);
            System.out.println("### ID nuevo del artista: " + haarper.getId());

            // Registrar los álbumes en la base de datos
            Echoes.setReferenciaArtista(haarper.getId());
            Nights.setReferenciaArtista(haarper.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Echoes, Nights));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(haarper.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        // Artista: DVRST
        Artista dvrst = new Artista();
        dvrst.setNombreArtista("DVRST");
        dvrst.setTipo("Solista");
        dvrst.setDescripcion("DVRST es un productor de música electrónica que crea una mezcla de phonk y trap experimental.");
        dvrst.setGeneroMusical("Phonk, Experimental Trap");
        dvrst.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/9/92/DVRST.jpg");
        dvrst.setIntegrantes(Arrays.asList(
                new Integrante("DVRST", "Productor", new Date(2016), new Date(2021), true)
        ));

        // Crear álbumes
        Album Gravity = new Album(new ObjectId());
        Album Alone = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Gravity.setNombre("Gravity");
        Gravity.setFechaLanzamiento(LocalDateTime.of(2018, 5, 17, 0, 0).toInstant(ZoneOffset.UTC));
        Gravity.setGeneroMusical(dvrst.getGeneroMusical());
        Gravity.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/3e/Gravity_DVRST.jpg");
        Gravity.setCanciones(Arrays.asList("Falling", "Into the Abyss", "Vortex"));

        Alone.setNombre("Alone");
        Alone.setFechaLanzamiento(LocalDateTime.of(2020, 8, 12, 0, 0).toInstant(ZoneOffset.UTC));
        Alone.setGeneroMusical(dvrst.getGeneroMusical());
        Alone.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/d3/Alone_DVRST.jpg");
        Alone.setCanciones(Arrays.asList("Solitude", "Shattered", "Echoes"));

        try {
            // Registrar al artista y obtener el ID generado
            dvrst.setAlbumes(Arrays.asList(Gravity.getId(), Alone.getId()));
            artistasDAO.registrar(dvrst);
            System.out.println("### ID nuevo del artista: " + dvrst.getId());

            // Registrar los álbumes en la base de datos
            Gravity.setReferenciaArtista(dvrst.getId());
            Alone.setReferenciaArtista(dvrst.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Gravity, Alone));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(dvrst.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        // Artista: KSLV Noh
        Artista kslvNoh = new Artista();
        kslvNoh.setNombreArtista("KSLV Noh");
        kslvNoh.setTipo("Solista");
        kslvNoh.setDescripcion("KSLV Noh es un productor musical conocido por su estilo de trap experimental, con sonidos oscuros y atmosféricos.");
        kslvNoh.setGeneroMusical("Trap, Experimental");
        kslvNoh.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/KSLV_Noh.jpg");
        kslvNoh.setIntegrantes(Arrays.asList(
                new Integrante("KSLV Noh", "Productor", new Date(2015), new Date(2021), true)
        ));

        // Crear álbumes
        Album Void = new Album(new ObjectId());
        Album Distorted = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Void.setNombre("Void");
        Void.setFechaLanzamiento(LocalDateTime.of(2017, 8, 10, 0, 0).toInstant(ZoneOffset.UTC));
        Void.setGeneroMusical(kslvNoh.getGeneroMusical());
        Void.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/19/Void_KSLV_Noh.jpg");
        Void.setCanciones(Arrays.asList("Eclipse", "Nebula", "Fallen"));

        Distorted.setNombre("Distorted");
        Distorted.setFechaLanzamiento(LocalDateTime.of(2019, 5, 22, 0, 0).toInstant(ZoneOffset.UTC));
        Distorted.setGeneroMusical(kslvNoh.getGeneroMusical());
        Distorted.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/01/Distorted_KSLV_Noh.jpg");
        Distorted.setCanciones(Arrays.asList("Fractured", "Shattered Dreams", "Beneath"));

        try {
            // Registrar al artista y obtener el ID generado
            kslvNoh.setAlbumes(Arrays.asList(Void.getId(), Distorted.getId()));
            artistasDAO.registrar(kslvNoh);
            System.out.println("### ID nuevo del artista: " + kslvNoh.getId());

            // Registrar los álbumes en la base de datos
            Void.setReferenciaArtista(kslvNoh.getId());
            Distorted.setReferenciaArtista(kslvNoh.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Void, Distorted));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(kslvNoh.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

        // Artista: Hensonn
        Artista hensonn = new Artista();
        hensonn.setNombreArtista("Hensonn");
        hensonn.setTipo("Solista");
        hensonn.setDescripcion("Hensonn es un productor de música electrónica cuyo estilo combina bass house, deep house y techno.");
        hensonn.setGeneroMusical("Bass House, Deep House, Techno");
        hensonn.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/3/32/Hensonn.jpg");
        hensonn.setIntegrantes(Arrays.asList(
                new Integrante("Hensonn", "Productor", new Date(2016), new Date(2021), true)
        ));

        // Crear álbumes
        Album Afterlife = new Album(new ObjectId());
        Album Eclipse = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Afterlife.setNombre("Afterlife");
        Afterlife.setFechaLanzamiento(LocalDateTime.of(2018, 7, 13, 0, 0).toInstant(ZoneOffset.UTC));
        Afterlife.setGeneroMusical(hensonn.getGeneroMusical());
        Afterlife.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/4b/Afterlife_Hensonn.jpg");
        Afterlife.setCanciones(Arrays.asList("Afterglow", "Fade", "Elysium"));

        Eclipse.setNombre("Eclipse");
        Eclipse.setFechaLanzamiento(LocalDateTime.of(2020, 2, 9, 0, 0).toInstant(ZoneOffset.UTC));
        Eclipse.setGeneroMusical(hensonn.getGeneroMusical());
        Eclipse.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/13/Eclipse_Hensonn.jpg");
        Eclipse.setCanciones(Arrays.asList("Rising Sun", "Gravity", "Shadows"));

        try {
            // Registrar al artista y obtener el ID generado
            hensonn.setAlbumes(Arrays.asList(Afterlife.getId(), Eclipse.getId()));
            artistasDAO.registrar(hensonn);
            System.out.println("### ID nuevo del artista: " + hensonn.getId());

            // Registrar los álbumes en la base de datos
            Afterlife.setReferenciaArtista(hensonn.getId());
            Eclipse.setReferenciaArtista(hensonn.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Afterlife, Eclipse));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(hensonn.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Artista: MoonDeity
        Artista moonDeity = new Artista();
        moonDeity.setNombreArtista("MoonDeity");
        moonDeity.setTipo("Solista");
        moonDeity.setDescripcion("MoonDeity es un productor que fusiona trap y synthwave, creando una atmósfera única y cósmica en su música.");
        moonDeity.setGeneroMusical("Synthwave, Trap");
        moonDeity.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/6/69/MoonDeity.jpg");
        moonDeity.setIntegrantes(Arrays.asList(
                new Integrante("MoonDeity", "Productor", new Date(2017), new Date(2021), true)
        ));

        // Crear álbumes
        Album Stellar = new Album(new ObjectId());
        Album EclipsePhase = new Album(new ObjectId());

        // Configurar datos de los álbumes
        Stellar.setNombre("Stellar");
        Stellar.setFechaLanzamiento(LocalDateTime.of(2019, 3, 21, 0, 0).toInstant(ZoneOffset.UTC));
        Stellar.setGeneroMusical(moonDeity.getGeneroMusical());
        Stellar.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/eb/Stellar_MoonDeity.jpg");
        Stellar.setCanciones(Arrays.asList("Galaxy Drift", "Nebula", "Dark Side"));

        EclipsePhase.setNombre("Eclipse Phase");
        EclipsePhase.setFechaLanzamiento(LocalDateTime.of(2021, 5, 5, 0, 0).toInstant(ZoneOffset.UTC));
        EclipsePhase.setGeneroMusical(moonDeity.getGeneroMusical());
        EclipsePhase.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/d4/EclipsePhase_MoonDeity.jpg");
        EclipsePhase.setCanciones(Arrays.asList("Phase One", "Dawn", "Nightfall"));

        try {
            // Registrar al artista y obtener el ID generado
            moonDeity.setAlbumes(Arrays.asList(Stellar.getId(), EclipsePhase.getId()));
            artistasDAO.registrar(moonDeity);
            System.out.println("### ID nuevo del artista: " + moonDeity.getId());

            // Registrar los álbumes en la base de datos
            Stellar.setReferenciaArtista(moonDeity.getId());
            EclipsePhase.setReferenciaArtista(moonDeity.getId());
            albumesDAO.insercionMasiva(Arrays.asList(Stellar, EclipsePhase));
            System.out.println("Álbumes registrados correctamente.");
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Consultar álbumes por artista
        try {
            System.out.println(albumesDAO.obtenerPorArtista(moonDeity.getId()));
        } catch (DAOException ex) {
            Logger.getLogger(PersistenciaCarlosDamian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
         
    
        


    }
}