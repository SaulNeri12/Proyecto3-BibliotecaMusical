/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.equipo7.presentacion;

/**
 *
 * @author caarl
 */
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MainAgregarUsuario {

    public static void main(String[] args) {
        try {
            // Obtener la instancia del DAO
            UsuariosDAO usuariosDAO = UsuariosDAO.getInstance();

            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario("juan.perez");
            nuevoUsuario.setCorreoElectronico("juan.carlos@example.com");
            nuevoUsuario.setContrasena("12345678");
            nuevoUsuario.setFechaRegistro(Instant.now());

            // Opcional: agregar géneros restringidos
            List<String> generosRestringidos = new ArrayList<>();
            generosRestringidos.add("Reggaeton");
            generosRestringidos.add("Cumbia");
            nuevoUsuario.setGenerosRestringidos(generosRestringidos);

            // Registrar el usuario en la base de datos
            usuariosDAO.registrarUsuario(nuevoUsuario);

            System.out.println("Usuario registrado exitosamente.");

        } catch (ConexionException e) {
            System.err.println("Error de conexión con la base de datos: " + e.getMessage());
        } catch (DAOException e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
        }
    }
}