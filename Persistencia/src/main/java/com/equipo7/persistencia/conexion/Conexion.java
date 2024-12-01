package com.equipo7.persistencia.conexion;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Conexion a la base de datos de MongoDB para el sistema
 * @author Saul Neri
 */
public class Conexion {

    private static Conexion instance;
    private final MongoClient mongoClient;
    private final MongoDatabase bibliotecaMusicalBD;

    private static final String conexionString = "mongodb://localhost:27017";
    
    /**
     * Constructor privado para la creacion de la instancia unica
     * @throws ConexionException Si ocurre un error en la creacion de la conexion
     */
    private Conexion() throws ConexionException {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(conexionString))
                .codecRegistry(codecRegistry) 
                .build();

        mongoClient = MongoClients.create(clientSettings);
        bibliotecaMusicalBD = mongoClient.getDatabase("bibliotecaMusical");
    }


    /**
     * Obtiene la instancia unica de conexion a la base de datos MongoDB
     * @return Conexion unica
     * @throws ConexionException Si no se puede crear la conexion
     */
    public static Conexion getInstance() throws ConexionException {
        if (instance == null) {
            instance = new Conexion();
        }

        return instance;
    }

    /**
     * Devuelve la base de datos de la biblioteca musical de MongoDB
     * @return Base de datos de la biblioteca musical
     */
    public MongoDatabase getBibliotecaMusicalBD() throws ConexionException {
        if (bibliotecaMusicalBD == null) {
            throw new ConexionException("No se pudo conectar con el servidor, por favor intente mas tarde...");
        }
        return bibliotecaMusicalBD;
    }

}