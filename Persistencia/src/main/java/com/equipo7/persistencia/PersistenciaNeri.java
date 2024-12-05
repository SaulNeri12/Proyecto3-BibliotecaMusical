/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.equipo7.persistencia;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Artista;
import com.equipo7.persistencia.entidades.Integrante;
import excepciones.DAOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public class PersistenciaNeri {

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
Album ghostStories = new Album(new ObjectId());
Album everydayLife = new Album(new ObjectId());

// Configurar datos de los álbumes
parachutes.setNombre("Parachutes");
parachutes.setFechaLanzamiento(LocalDateTime.of(2000, 7, 10, 0, 0).toInstant(ZoneOffset.UTC));
parachutes.setGeneroMusical(coldplay.getGeneroMusical());
parachutes.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a3/Coldplayparachutesalbumcover.jpg");
parachutes.setCanciones(Arrays.asList(
        "Don't Panic", "Shiver", "Yellow"
));

aRushOfBlood.setNombre("A Rush of Blood to the Head");
aRushOfBlood.setFechaLanzamiento(LocalDateTime.of(2002, 8, 26, 0, 0).toInstant(ZoneOffset.UTC));
aRushOfBlood.setGeneroMusical(coldplay.getGeneroMusical());
aRushOfBlood.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/28/Coldplay_-_A_Rush_of_Blood_to_the_Head.png");
aRushOfBlood.setCanciones(Arrays.asList(
        "Politik", "In My Place", "The Scientist"
));

ghostStories.setNombre("Ghost Stories");
ghostStories.setFechaLanzamiento(LocalDateTime.of(2014, 5, 19, 0, 0).toInstant(ZoneOffset.UTC));
ghostStories.setGeneroMusical(coldplay.getGeneroMusical());
ghostStories.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/2e/Coldplay_-_Ghost_Stories.jpg");
ghostStories.setCanciones(Arrays.asList(
        "Always in My Head", "Magic", "Midnight"
));

everydayLife.setNombre("Everyday Life");
everydayLife.setFechaLanzamiento(LocalDateTime.of(2019, 11, 22, 0, 0).toInstant(ZoneOffset.UTC));
everydayLife.setGeneroMusical(coldplay.getGeneroMusical());
everydayLife.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/3c/Coldplay_-_Everyday_Life.png");
everydayLife.setCanciones(Arrays.asList(
        "Orphans", "Everyday Life", "Champion of the World"
));

try {
    // Registrar al artista y obtener el ID generado
    coldplay.setAlbumes(Arrays.asList(
            parachutes.getId(), aRushOfBlood.getId(), ghostStories.getId(), everydayLife.getId()
    ));
    artistasDAO.registrar(coldplay);
    System.out.println("### ID nuevo del artista: " + coldplay.getId());

    // Registrar los álbumes en la base de datos
    parachutes.setReferenciaArtista(coldplay.getId());
    aRushOfBlood.setReferenciaArtista(coldplay.getId());
    ghostStories.setReferenciaArtista(coldplay.getId());
    everydayLife.setReferenciaArtista(coldplay.getId());
    albumesDAO.insercionMasiva(Arrays.asList(parachutes, aRushOfBlood, ghostStories, everydayLife));
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

// Artista: Tupac Shakur
Artista tupac = new Artista();
tupac.setNombreArtista("Tupac Shakur");
tupac.setTipo("Rapper");
tupac.setDescripcion("Tupac Shakur fue un influyente rapero y actor estadounidense, conocido por sus letras que abordan temas de violencia, pobreza y justicia social.");
tupac.setGeneroMusical("Hip Hop");
tupac.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/1/1f/Tupac_Amaru_Shakur_%28cropped%29.jpg");
tupac.setIntegrantes(Arrays.asList(
        new Integrante("Tupac Shakur", "Voz", new Date(1990), new Date(1996), true)
));

// Crear álbumes
Album meAgainstTheWorld = new Album(new ObjectId());
Album allEyezOnMe = new Album(new ObjectId());

// Configurar datos de los álbumes
meAgainstTheWorld.setNombre("Me Against the World");
meAgainstTheWorld.setFechaLanzamiento(LocalDateTime.of(1995, 3, 14, 0, 0).toInstant(ZoneOffset.UTC));
meAgainstTheWorld.setGeneroMusical(tupac.getGeneroMusical());
meAgainstTheWorld.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/e0/Tupac_Shakur_-_Me_Against_the_World.jpg");
meAgainstTheWorld.setCanciones(Arrays.asList(
        "Dear Mama", "So Many Tears", "Temptations"
));

allEyezOnMe.setNombre("All Eyez On Me");
allEyezOnMe.setFechaLanzamiento(LocalDateTime.of(1996, 2, 13, 0, 0).toInstant(ZoneOffset.UTC));
allEyezOnMe.setGeneroMusical(tupac.getGeneroMusical());
allEyezOnMe.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/9/91/2Pac_-_All_Eyez_on_Me.jpg");
allEyezOnMe.setCanciones(Arrays.asList(
        "California Love", "Ambitionz Az a Ridah", "2 of Amerikaz Most Wanted"
));

try {
    tupac.setAlbumes(Arrays.asList(meAgainstTheWorld.getId(), allEyezOnMe.getId()));
    artistasDAO.registrar(tupac);
    albumesDAO.insercionMasiva(Arrays.asList(meAgainstTheWorld, allEyezOnMe));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: The Notorious B.I.G.
Artista biggie = new Artista();
biggie.setNombreArtista("The Notorious B.I.G.");
biggie.setTipo("Rapper");
biggie.setDescripcion("The Notorious B.I.G. fue un rapero estadounidense que se destacó en los años 90, conocido por su flow suave y líricas sobre la vida en las calles.");
biggie.setGeneroMusical("Hip Hop");
biggie.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/4/44/Notorious_BIG_1997.jpg");
biggie.setIntegrantes(Arrays.asList(
        new Integrante("The Notorious B.I.G.", "Voz", new Date(1992), new Date(1997), true)
));

// Crear álbumes
Album readyToDie = new Album(new ObjectId());
Album lifeAfterDeath = new Album(new ObjectId());

// Configurar datos de los álbumes
readyToDie.setNombre("Ready to Die");
readyToDie.setFechaLanzamiento(LocalDateTime.of(1994, 9, 13, 0, 0).toInstant(ZoneOffset.UTC));
readyToDie.setGeneroMusical(biggie.getGeneroMusical());
readyToDie.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/5/56/The_Infamous_Ready_to_Die.jpg");
readyToDie.setCanciones(Arrays.asList(
        "Juicy", "Big Poppa", "One More Chance"
));

lifeAfterDeath.setNombre("Life After Death");
lifeAfterDeath.setFechaLanzamiento(LocalDateTime.of(1997, 3, 25, 0, 0).toInstant(ZoneOffset.UTC));
lifeAfterDeath.setGeneroMusical(biggie.getGeneroMusical());
lifeAfterDeath.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/2e/The_Notorious_B.I.G._-_Life_After_Death.png");
lifeAfterDeath.setCanciones(Arrays.asList(
        "Hypnotize", "Mo Money Mo Problems", "Notorious Thugs"
));

try {
    biggie.setAlbumes(Arrays.asList(readyToDie.getId(), lifeAfterDeath.getId()));
    artistasDAO.registrar(biggie);
    albumesDAO.insercionMasiva(Arrays.asList(readyToDie, lifeAfterDeath));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Jay-Z
Artista jayZ = new Artista();
jayZ.setNombreArtista("Jay-Z");
jayZ.setTipo("Rapper");
jayZ.setDescripcion("Jay-Z es un rapero, productor y empresario estadounidense, conocido como uno de los artistas más exitosos del hip-hop.");
jayZ.setGeneroMusical("Hip Hop");
jayZ.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/a/a1/Jay-Z_in_2010.jpg");
jayZ.setIntegrantes(Arrays.asList(
        new Integrante("Jay-Z", "Voz", new Date(1996), null, true)
));

// Crear álbumes
Album reasonableDoubt = new Album(new ObjectId());
Album theBlueprint = new Album(new ObjectId());

// Configurar datos de los álbumes
reasonableDoubt.setNombre("Reasonable Doubt");
reasonableDoubt.setFechaLanzamiento(LocalDateTime.of(1996, 6, 25, 0, 0).toInstant(ZoneOffset.UTC));
reasonableDoubt.setGeneroMusical(jayZ.getGeneroMusical());
reasonableDoubt.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/4b/Jay-Z_-_Reasonable_Doubt.jpg");
reasonableDoubt.setCanciones(Arrays.asList(
        "Can't Knock the Hustle", "Dead Presidents II", "Brooklyn's Finest"
));

theBlueprint.setNombre("The Blueprint");
theBlueprint.setFechaLanzamiento(LocalDateTime.of(2001, 9, 11, 0, 0).toInstant(ZoneOffset.UTC));
theBlueprint.setGeneroMusical(jayZ.getGeneroMusical());
theBlueprint.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/28/Coldplay_-_A_Rush_of_Blood_to_the_Head.png");
theBlueprint.setCanciones(Arrays.asList(
        "Izzo (H.O.V.A.)", "Girls, Girls, Girls", "Song Cry"
));

try {
    jayZ.setAlbumes(Arrays.asList(reasonableDoubt.getId(), theBlueprint.getId()));
    artistasDAO.registrar(jayZ);
    albumesDAO.insercionMasiva(Arrays.asList(reasonableDoubt, theBlueprint));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: Nas
Artista nas = new Artista();
nas.setNombreArtista("Nas");
nas.setTipo("Rapper");
nas.setDescripcion("Nas es un rapero estadounidense conocido por su lírica introspectiva y su habilidad para contar historias de la vida en las calles.");
nas.setGeneroMusical("Hip Hop");
nas.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/e7/Nas_at_The_Brooklyn_Bowl.jpg");
nas.setIntegrantes(Arrays.asList(
        new Integrante("Nas", "Voz", new Date(1991), null, true)
));

// Crear álbumes
Album illmatic = new Album(new ObjectId());
Album itWasWritten = new Album(new ObjectId());

// Configurar datos de los álbumes
illmatic.setNombre("Illmatic");
illmatic.setFechaLanzamiento(LocalDateTime.of(1994, 4, 19, 0, 0).toInstant(ZoneOffset.UTC));
illmatic.setGeneroMusical(nas.getGeneroMusical());
illmatic.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/9/91/Nas_-_Illmatic.png");
illmatic.setCanciones(Arrays.asList(
        "N.Y. State of Mind", "Life's a Bitch", "The World Is Yours"
));

itWasWritten.setNombre("It Was Written");
itWasWritten.setFechaLanzamiento(LocalDateTime.of(1996, 7, 2, 0, 0).toInstant(ZoneOffset.UTC));
itWasWritten.setGeneroMusical(nas.getGeneroMusical());
itWasWritten.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/d/d4/Nas_-_It_Was_Written.jpg");
itWasWritten.setCanciones(Arrays.asList(
        "If I Ruled the World (Imagine That)", "Street Dreams", "The Message"
));

try {
    nas.setAlbumes(Arrays.asList(illmatic.getId(), itWasWritten.getId()));
    artistasDAO.registrar(nas);
    albumesDAO.insercionMasiva(Arrays.asList(illmatic, itWasWritten));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Kanye West
Artista kanyeWest = new Artista();
kanyeWest.setNombreArtista("Kanye West");
kanyeWest.setTipo("Rapper / Productor");
kanyeWest.setDescripcion("Kanye West es un rapero, productor y diseñador de moda estadounidense, conocido por su estilo innovador y por abordar temas de ego, amor y cultura.");
kanyeWest.setGeneroMusical("Hip Hop");
kanyeWest.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/ec/Kanye_West_2019.jpg");
kanyeWest.setIntegrantes(Arrays.asList(
        new Integrante("Kanye West", "Voz", new Date(2001), null, true)
));

// Crear álbumes
Album graduation = new Album(new ObjectId());
Album myBeautifulDarkTwistedFantasy = new Album(new ObjectId());

// Configurar datos de los álbumes
graduation.setNombre("Graduation");
graduation.setFechaLanzamiento(LocalDateTime.of(2007, 9, 11, 0, 0).toInstant(ZoneOffset.UTC));
graduation.setGeneroMusical(kanyeWest.getGeneroMusical());
graduation.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/08/Kanye_West_-_Graduation.jpg");
graduation.setCanciones(Arrays.asList(
        "Stronger", "Good Life", "Flashing Lights"
));

myBeautifulDarkTwistedFantasy.setNombre("My Beautiful Dark Twisted Fantasy");
myBeautifulDarkTwistedFantasy.setFechaLanzamiento(LocalDateTime.of(2010, 11, 22, 0, 0).toInstant(ZoneOffset.UTC));
myBeautifulDarkTwistedFantasy.setGeneroMusical(kanyeWest.getGeneroMusical());
myBeautifulDarkTwistedFantasy.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/a9/My_Beautiful_Dark_Twisted_Fantasy.jpg");
myBeautifulDarkTwistedFantasy.setCanciones(Arrays.asList(
        "Power", "Runaway", "Monster"
));

try {
    kanyeWest.setAlbumes(Arrays.asList(graduation.getId(), myBeautifulDarkTwistedFantasy.getId()));
    artistasDAO.registrar(kanyeWest);
    albumesDAO.insercionMasiva(Arrays.asList(graduation, myBeautifulDarkTwistedFantasy));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Eminem
Artista eminem = new Artista();
eminem.setNombreArtista("Eminem");
eminem.setTipo("Rapper");
eminem.setDescripcion("Eminem es un rapero estadounidense considerado uno de los más grandes de todos los tiempos, conocido por sus letras polémicas y rápidas.");
eminem.setGeneroMusical("Hip Hop");
eminem.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/f/f2/Eminem_2011.jpg");
eminem.setIntegrantes(Arrays.asList(
        new Integrante("Eminem", "Voz", new Date(1996), null, true)
));

// Crear álbumes
Album theSlimShadyLP = new Album(new ObjectId());
Album theMarshallMathersLP = new Album(new ObjectId());

// Configurar datos de los álbumes
theSlimShadyLP.setNombre("The Slim Shady LP");
theSlimShadyLP.setFechaLanzamiento(LocalDateTime.of(1999, 2, 23, 0, 0).toInstant(ZoneOffset.UTC));
theSlimShadyLP.setGeneroMusical(eminem.getGeneroMusical());
theSlimShadyLP.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/8/83/The_Slim_Shady_LP.jpg");
theSlimShadyLP.setCanciones(Arrays.asList(
        "My Name Is", "Guilty Conscience", "97' Bonnie & Clyde"
));

theMarshallMathersLP.setNombre("The Marshall Mathers LP");
theMarshallMathersLP.setFechaLanzamiento(LocalDateTime.of(2000, 5, 23, 0, 0).toInstant(ZoneOffset.UTC));
theMarshallMathersLP.setGeneroMusical(eminem.getGeneroMusical());
theMarshallMathersLP.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/5/56/The_Marshall_Mathers_LP.jpg");
theMarshallMathersLP.setCanciones(Arrays.asList(
        "Stan", "The Real Slim Shady", "Kim"
));

try {
    eminem.setAlbumes(Arrays.asList(theSlimShadyLP.getId(), theMarshallMathersLP.getId()));
    artistasDAO.registrar(eminem);
    albumesDAO.insercionMasiva(Arrays.asList(theSlimShadyLP, theMarshallMathersLP));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Drake
Artista drake = new Artista();
drake.setNombreArtista("Drake");
drake.setTipo("Rapper / Cantante");
drake.setDescripcion("Drake es un rapero, cantante y productor canadiense que ha dominado las listas de éxitos con su estilo melódico y sus colaboraciones con otros artistas.");
drake.setGeneroMusical("Hip Hop");
drake.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/e/ed/Drake_2016.jpg");
drake.setIntegrantes(Arrays.asList(
        new Integrante("Drake", "Voz", new Date(2006), null, true)
));

// Crear álbumes
Album nothingWasTheSame = new Album(new ObjectId());
Album takeCare = new Album(new ObjectId());

// Configurar datos de los álbumes
nothingWasTheSame.setNombre("Nothing Was the Same");
nothingWasTheSame.setFechaLanzamiento(LocalDateTime.of(2013, 9, 24, 0, 0).toInstant(ZoneOffset.UTC));
nothingWasTheSame.setGeneroMusical(drake.getGeneroMusical());
nothingWasTheSame.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6d/Drake_-_Nothing_Was_the_Same.jpg");
nothingWasTheSame.setCanciones(Arrays.asList(
        "Started From the Bottom", "Hold On, We're Going Home", "All Me"
));

takeCare.setNombre("Take Care");
takeCare.setFechaLanzamiento(LocalDateTime.of(2011, 11, 15, 0, 0).toInstant(ZoneOffset.UTC));
takeCare.setGeneroMusical(drake.getGeneroMusical());
takeCare.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/03/Drake_-_Take_Care.jpg");
takeCare.setCanciones(Arrays.asList(
        "Marvins Room", "Headlines", "Make Me Proud"
));

try {
    drake.setAlbumes(Arrays.asList(nothingWasTheSame.getId(), takeCare.getId()));
    artistasDAO.registrar(drake);
    albumesDAO.insercionMasiva(Arrays.asList(nothingWasTheSame, takeCare));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}




// Artista: Lil Wayne
Artista lilWayne = new Artista();
lilWayne.setNombreArtista("Lil Wayne");
lilWayne.setTipo("Rapper");
lilWayne.setDescripcion("Lil Wayne es un rapero estadounidense reconocido por su estilo único, su habilidad para rimar y por haber influenciado a toda una generación.");
lilWayne.setGeneroMusical("Hip Hop");
lilWayne.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/3/37/Lil_Wayne_2016.jpg");
lilWayne.setIntegrantes(Arrays.asList(
        new Integrante("Lil Wayne", "Voz", new Date(1999), null, true)
));

// Crear álbumes
Album thaCarterIII = new Album(new ObjectId());
Album thaCarterIV = new Album(new ObjectId());

// Configurar datos de los álbumes
thaCarterIII.setNombre("Tha Carter III");
thaCarterIII.setFechaLanzamiento(LocalDateTime.of(2008, 6, 10, 0, 0).toInstant(ZoneOffset.UTC));
thaCarterIII.setGeneroMusical(lilWayne.getGeneroMusical());
thaCarterIII.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6d/Lil_Wayne_-_Tha_Carter_III.jpg");
thaCarterIII.setCanciones(Arrays.asList(
        "Lollipop", "A Milli", "Got Money"
));

thaCarterIV.setNombre("Tha Carter IV");
thaCarterIV.setFechaLanzamiento(LocalDateTime.of(2011, 8, 29, 0, 0).toInstant(ZoneOffset.UTC));
thaCarterIV.setGeneroMusical(lilWayne.getGeneroMusical());
thaCarterIV.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/c4/Lil_Wayne_-_Tha_Carter_IV.jpg");
thaCarterIV.setCanciones(Arrays.asList(
        "6 Foot 7 Foot", "How to Love", "She Will"
));

try {
    lilWayne.setAlbumes(Arrays.asList(thaCarterIII.getId(), thaCarterIV.getId()));
    artistasDAO.registrar(lilWayne);
    albumesDAO.insercionMasiva(Arrays.asList(thaCarterIII, thaCarterIV));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Configurar datos de los álbumes
reasonableDoubt.setNombre("Reasonable Doubt");
reasonableDoubt.setFechaLanzamiento(LocalDateTime.of(1996, 6, 25, 0, 0).toInstant(ZoneOffset.UTC));
reasonableDoubt.setGeneroMusical(jayZ.getGeneroMusical());
reasonableDoubt.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/6/6e/Jay-Z_-_Reasonable_Doubt.jpg");
reasonableDoubt.setCanciones(Arrays.asList(
        "Dead Presidents II", "Brooklyn's Finest", "Can I Live"
));

theBlueprint.setNombre("The Blueprint");
theBlueprint.setFechaLanzamiento(LocalDateTime.of(2001, 9, 11, 0, 0).toInstant(ZoneOffset.UTC));
theBlueprint.setGeneroMusical(jayZ.getGeneroMusical());
theBlueprint.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/e1/Jay-Z_The_Blueprint.jpg");
theBlueprint.setCanciones(Arrays.asList(
        "Izzo (H.O.V.A.)", "Takeover", "Renegade"
));

try {
    jayZ.setAlbumes(Arrays.asList(reasonableDoubt.getId(), theBlueprint.getId()));
    artistasDAO.registrar(jayZ);
    albumesDAO.insercionMasiva(Arrays.asList(reasonableDoubt, theBlueprint));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Snoop Dogg
Artista snoopDogg = new Artista();
snoopDogg.setNombreArtista("Snoop Dogg");
snoopDogg.setTipo("Rapper");
snoopDogg.setDescripcion("Snoop Dogg es un rapero y actor estadounidense conocido por su estilo relajado y su legado en la escena del rap de la costa oeste.");
snoopDogg.setGeneroMusical("Hip Hop");
snoopDogg.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/0/05/Snoop_Dogg_2018.jpg");
snoopDogg.setIntegrantes(Arrays.asList(
        new Integrante("Snoop Dogg", "Voz", new Date(1992), null, true)
));

// Crear álbumes
Album doggystyle = new Album(new ObjectId());
Album thaBlueCarpetTreatment = new Album(new ObjectId());

// Configurar datos de los álbumes
doggystyle.setNombre("Doggystyle");
doggystyle.setFechaLanzamiento(LocalDateTime.of(1993, 11, 23, 0, 0).toInstant(ZoneOffset.UTC));
doggystyle.setGeneroMusical(snoopDogg.getGeneroMusical());
doggystyle.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/c9/Snoop_Dogg_Doggystyle.jpg");
doggystyle.setCanciones(Arrays.asList(
        "Gin and Juice", "Who Am I (What's My Name)?", "Murder Was the Case"
));

thaBlueCarpetTreatment.setNombre("Tha Blue Carpet Treatment");
thaBlueCarpetTreatment.setFechaLanzamiento(LocalDateTime.of(2006, 11, 21, 0, 0).toInstant(ZoneOffset.UTC));
thaBlueCarpetTreatment.setGeneroMusical(snoopDogg.getGeneroMusical());
thaBlueCarpetTreatment.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/0a/Snoop_Dogg_-_Tha_Blue_Carpet_Treatment.jpg");
thaBlueCarpetTreatment.setCanciones(Arrays.asList(
        "That's What Snoop Dogg Do", "Vato", "Candy (Drippin' Like Water)"
));

try {
    snoopDogg.setAlbumes(Arrays.asList(doggystyle.getId(), thaBlueCarpetTreatment.getId()));
    artistasDAO.registrar(snoopDogg);
    albumesDAO.insercionMasiva(Arrays.asList(doggystyle, thaBlueCarpetTreatment));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Nas
Artista nas = new Artista();
nas.setNombreArtista("Nas");
nas.setTipo("Rapper");
nas.setDescripcion("Nas es un rapero estadounidense considerado uno de los más grandes letristas de la historia del rap.");
nas.setGeneroMusical("Hip Hop");
nas.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/7/7d/Nas_at_2018_VA_Marathon.jpg");
nas.setIntegrantes(Arrays.asList(
        new Integrante("Nas", "Voz", new Date(1991), null, true)
));

// Crear álbumes
Album illmatic = new Album(new ObjectId());
Album stillmatic = new Album(new ObjectId());

// Configurar datos de los álbumes
illmatic.setNombre("Illmatic");
illmatic.setFechaLanzamiento(LocalDateTime.of(1994, 4, 19, 0, 0).toInstant(ZoneOffset.UTC));
illmatic.setGeneroMusical(nas.getGeneroMusical());
illmatic.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/2/2c/NasIllmatic.jpg");
illmatic.setCanciones(Arrays.asList(
        "N.Y. State of Mind", "Life's a Bitch", "The World Is Yours"
));

stillmatic.setNombre("Stillmatic");
stillmatic.setFechaLanzamiento(LocalDateTime.of(2001, 12, 18, 0, 0).toInstant(ZoneOffset.UTC));
stillmatic.setGeneroMusical(nas.getGeneroMusical());
stillmatic.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/1/16/Nas_Stillmatic_album.jpg");
stillmatic.setCanciones(Arrays.asList(
        "Ether", "Got Ur Self A...", "One Mic"
));

try {
    nas.setAlbumes(Arrays.asList(illmatic.getId(), stillmatic.getId()));
    artistasDAO.registrar(nas);
    albumesDAO.insercionMasiva(Arrays.asList(illmatic, stillmatic));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Travis Scott
Artista travisScott = new Artista();
travisScott.setNombreArtista("Travis Scott");
travisScott.setTipo("Rapper / Productor");
travisScott.setDescripcion("Travis Scott es un rapero y productor musical estadounidense conocido por su estilo experimental y su energía en vivo.");
travisScott.setGeneroMusical("Hip Hop");
travisScott.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/9/92/Travis_Scott_2019.jpg");
travisScott.setIntegrantes(Arrays.asList(
        new Integrante("Travis Scott", "Voz", new Date(2008), null, true)
));

// Crear álbumes
Album rodeo = new Album(new ObjectId());
Album astroworld = new Album(new ObjectId());

// Configurar datos de los álbumes
rodeo.setNombre("Rodeo");
rodeo.setFechaLanzamiento(LocalDateTime.of(2015, 9, 4, 0, 0).toInstant(ZoneOffset.UTC));
rodeo.setGeneroMusical(travisScott.getGeneroMusical());
rodeo.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/a/af/Travis_Scott_-_Rodeo.jpg");
rodeo.setCanciones(Arrays.asList(
        "Antidote", "3500", "Maria I'm Drunk"
));

astroworld.setNombre("Astroworld");
astroworld.setFechaLanzamiento(LocalDateTime.of(2018, 8, 3, 0, 0).toInstant(ZoneOffset.UTC));
astroworld.setGeneroMusical(travisScott.getGeneroMusical());
astroworld.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/4/4e/Travis_Scott_-_Astroworld.png");
astroworld.setCanciones(Arrays.asList(
        "SICKO MODE", "STOP TRYING TO BE GOD", "Yosemite"
));

try {
    travisScott.setAlbumes(Arrays.asList(rodeo.getId(), astroworld.getId()));
    artistasDAO.registrar(travisScott);
    albumesDAO.insercionMasiva(Arrays.asList(rodeo, astroworld));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}


// Artista: Cardi B
Artista cardiB = new Artista();
cardiB.setNombreArtista("Cardi B");
cardiB.setTipo("Rapper");
cardiB.setDescripcion("Cardi B es una rapera y cantante estadounidense conocida por su estilo crudo y sus letras explícitas.");
cardiB.setGeneroMusical("Hip Hop");
cardiB.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/9/9f/Cardi_B_2018.jpg");
cardiB.setIntegrantes(Arrays.asList(
        new Integrante("Cardi B", "Voz", new Date(2015), null, true)
));

// Crear álbumes
Album invasionOfPrivacy = new Album(new ObjectId());
Album wap = new Album(new ObjectId());

// Configurar datos de los álbumes
invasionOfPrivacy.setNombre("Invasion of Privacy");
invasionOfPrivacy.setFechaLanzamiento(LocalDateTime.of(2018, 4, 6, 0, 0).toInstant(ZoneOffset.UTC));
invasionOfPrivacy.setGeneroMusical(cardiB.getGeneroMusical());
invasionOfPrivacy.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/e5/Cardi_B_-_Invasion_of_Privacy.jpg");
invasionOfPrivacy.setCanciones(Arrays.asList(
        "Bodak Yellow", "I Like It", "Be Careful"
));

wap.setNombre("WAP");
wap.setFechaLanzamiento(LocalDateTime.of(2020, 8, 7, 0, 0).toInstant(ZoneOffset.UTC));
wap.setGeneroMusical(cardiB.getGeneroMusical());
wap.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/3/3f/Cardi_B_-_WAP.jpg");
wap.setCanciones(Arrays.asList(
        "WAP", "Up", "Money"
));

try {
    cardiB.setAlbumes(Arrays.asList(invasionOfPrivacy.getId(), wap.getId()));
    artistasDAO.registrar(cardiB);
    albumesDAO.insercionMasiva(Arrays.asList(invasionOfPrivacy, wap));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}

// Artista: Jay-Z
Artista jayZ = new Artista();
jayZ.setNombreArtista("Jay-Z");
jayZ.setTipo("Rapper / Empresario");
jayZ.setDescripcion("Jay-Z es un rapero, productor y empresario estadounidense, conocido como uno de los artistas más influyentes en la historia del rap.");
jayZ.setGeneroMusical("Hip Hop");
jayZ.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/3/3f/Jay-Z_2018_%28cropped%29.jpg");
jayZ.setIntegrantes(Arrays.asList(
        new Integrante("Jay-Z", "Voz", new Date(1996), null, true)
));

// Crear álbumes
Album reasonableDoubt = new Album(new ObjectId());
Album theBlueprint = new Album(new ObjectId());

// Configurar datos de los álbumes
reasonableDoubt.setNombre("Reasonable Doubt");
reasonableDoubt.setFechaLanzamiento(LocalDateTime.of(1996, 6, 25, 0, 0).toInstant(ZoneOffset.UTC));
reasonableDoubt.setGeneroMusical(jayZ.getGeneroMusical());
reasonableDoubt.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/9/94/Jay-Z_-_Reasonable_Doubt.jpg");
reasonableDoubt.setCanciones(Arrays.asList(
        "Can't Knock the Hustle", "Dead Presidents II", "Brooklyn's Finest"
));

theBlueprint.setNombre("The Blueprint");
theBlueprint.setFechaLanzamiento(LocalDateTime.of(2001, 9, 11, 0, 0).toInstant(ZoneOffset.UTC));
theBlueprint.setGeneroMusical(jayZ.getGeneroMusical());
theBlueprint.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/c/c3/Jay-Z_-_The_Blueprint.jpg");
theBlueprint.setCanciones(Arrays.asList(
        "Izzo (H.O.V.A.)", "Takeover", "Renegade"
));

try {
    jayZ.setAlbumes(Arrays.asList(reasonableDoubt.getId(), theBlueprint.getId()));
    artistasDAO.registrar(jayZ);
    albumesDAO.insercionMasiva(Arrays.asList(reasonableDoubt, theBlueprint));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}




// Artista: Post Malone
Artista postMalone = new Artista();
postMalone.setNombreArtista("Post Malone");
postMalone.setTipo("Rapper / Cantante");
postMalone.setDescripcion("Post Malone es un cantante, rapero y compositor estadounidense conocido por su estilo que fusiona rap, rock y pop.");
postMalone.setGeneroMusical("Hip Hop");
postMalone.setImagenURL("https://upload.wikimedia.org/wikipedia/commons/3/3b/Post_Malone_2018_by_Glenn_Francis.jpg");
postMalone.setIntegrantes(Arrays.asList(
        new Integrante("Post Malone", "Voz", new Date(2013), null, true)
));

// Crear álbumes
Album stoney = new Album(new ObjectId());
Album beerBongsBentleys = new Album(new ObjectId());

// Configurar datos de los álbumes
stoney.setNombre("Stoney");
stoney.setFechaLanzamiento(LocalDateTime.of(2016, 12, 9, 0, 0).toInstant(ZoneOffset.UTC));
stoney.setGeneroMusical(postMalone.getGeneroMusical());
stoney.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/e/e1/Post_Malone_-_Stoney.png");
stoney.setCanciones(Arrays.asList(
        "White Iverson", "Congratulations", "Go Flex"
));

beerBongsBentleys.setNombre("Beer Bongs & Bentleys");
beerBongsBentleys.setFechaLanzamiento(LocalDateTime.of(2018, 4, 27, 0, 0).toInstant(ZoneOffset.UTC));
beerBongsBentleys.setGeneroMusical(postMalone.getGeneroMusical());
beerBongsBentleys.setImagenPortadaUrl("https://upload.wikimedia.org/wikipedia/en/0/0c/Post_Malone_Beer_Bongs_%26_Bentleys.png");
beerBongsBentleys.setCanciones(Arrays.asList(
        "Rockstar", "Psycho", "Better Now"
));

try {
    postMalone.setAlbumes(Arrays.asList(stoney.getId(), beerBongsBentleys.getId()));
    artistasDAO.registrar(postMalone);
    albumesDAO.insercionMasiva(Arrays.asList(stoney, beerBongsBentleys));
} catch (DAOException ex) {
    Logger.getLogger(PersistenciaIlian.class.getName()).log(Level.SEVERE, null, ex);
}




    }
    
}
