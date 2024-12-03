/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.equipo7.presentacion;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.bo.UsuariosBO;
import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.presentacion.gui.PerfilUsuario;

public class MainCambiarNombreUsuario {

    public static void main(String[] args) {
        // Configuración inicial: simular un usuario en PerfilUsuario
        UsuarioDTO usuarioActual = new UsuarioDTO("juan.perez", "juan.perez@example.com", "Contrasena123");
        PerfilUsuario.setUsuario(usuarioActual);

        // Mostrar el nombre de usuario actual
        System.out.println("Nombre de usuario actual: " + PerfilUsuario.getUsuario().getNombreUsuario());

        // Nuevo nombre de usuario
        String nuevoNombre = "NuevoNombreUsuario";

        try {
            // Actualizar el nombre de usuario
            IUsuariosBO usuariosBO = UsuariosBO.getInstance();
            usuariosBO.actualizarNombreUsuario(PerfilUsuario.getUsuario().getCorreoElectronico(), nuevoNombre);

            // Actualizar en PerfilUsuario
            PerfilUsuario.getUsuario().setNombreUsuario(nuevoNombre);

            // Mostrar el nombre actualizado
            System.out.println("Nombre de usuario actualizado: " + PerfilUsuario.getUsuario().getNombreUsuario());
        } catch (BOException e) {
            System.err.println("Error al actualizar el nombre de usuario: " + e.getMessage());
        }
    }
}