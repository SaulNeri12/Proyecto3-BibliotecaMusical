package excepciones;

/**
 * Excepcion utilizada para manejar errores provenientes de los DAOs
 * @author Saul Neri
 */
public class DAOException extends Exception {

    /**
     * Cosntructor por defecto para la excepcion
     * @param mensaje Mensaje de error
     */
    public DAOException(String mensaje) {
        super(mensaje);
    }
}
