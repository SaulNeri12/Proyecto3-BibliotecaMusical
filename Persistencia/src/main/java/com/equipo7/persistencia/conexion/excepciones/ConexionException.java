package com.equipo7.persistencia.conexion.excepciones;

/**
 * Usada para mostrar errores al crear o consultar la conexion del sistema con la base de datos
 * @author Saul Neri
 */
public class ConexionException extends Exception {

    /**
     * Crea una nueva excepcion con un mensaje dado
     * @param mensaje Mensaje de la excepcion
     */
    public ConexionException(String mensaje) {
        super(mensaje);
    }
}
