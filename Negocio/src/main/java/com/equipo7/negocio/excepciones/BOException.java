package com.equipo7.negocio.excepciones;

/**
 * Excepcion usada para el manejo de errores en negocio
 */
public class BOException extends Exception {

    /**
     * Crea una nueva excepcion BOExcepcion con un mensaje
     * @param mensaje Mensaje de error
     */
    public BOException(String mensaje) {
        super(mensaje);
    }
}
