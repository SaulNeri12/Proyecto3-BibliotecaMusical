package com.equipo7.persistencia.conexion;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Conexion a la base de datos de MongoDB para el sistema
 * @author Saul Neri
 */
public class Conexion {

    private static Conexion instance;
    private final MongoClient mongoClient;
    private final MongoDatabase bibliotecaMusicalBD;

    /**
     * Constructor privado para la creacion de la instancia unica
     * @throws ConexionException Si ocurre un error en la creacion de la conexion
     */
    private Conexion() throws ConexionException {
        mongoClient = MongoClients.create("mongodb://localhost:27017");

        bibliotecaMusicalBD = mongoClient.getDatabase("bibliotecaMusical");

        if (bibliotecaMusicalBD != null) {
            return;
        }

        throw new ConexionException("No se pudo conectar con el servidor, porfavor intente mas tarde...");
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
