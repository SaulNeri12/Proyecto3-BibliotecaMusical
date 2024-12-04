/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

/**
 *
 * @author caarl
 */

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.CancionesDAO;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        try {
            // Obtener la instancia del DAO
            CancionesDAO cancionesDAO = CancionesDAO.getInstance();

            // Probar obtenerCancionesPorGenero
            String generoPrueba = "Rock";
            System.out.println("Probando obtener canciones por género: " + generoPrueba);
            List<String> cancionesPorGenero = cancionesDAO.obtenerCancionesPorGenero(generoPrueba);
            System.out.println("Canciones encontradas: ");
            cancionesPorGenero.forEach(System.out::println);

            // Probar obtenerCancionesPorNombre
            String nombreParcialPrueba = "love";
            System.out.println("\nProbando obtener canciones por nombre parcial: " + nombreParcialPrueba);
            List<String> cancionesPorNombre = cancionesDAO.obtenerCancionesPorNombre(nombreParcialPrueba);
            System.out.println("Canciones encontradas: ");
            cancionesPorNombre.forEach(System.out::println);

        } catch (ConexionException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
*/
    }
}