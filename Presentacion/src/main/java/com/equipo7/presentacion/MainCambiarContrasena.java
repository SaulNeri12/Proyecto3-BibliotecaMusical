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

public class MainCambiarContrasena {

    public static void main(String[] args) {
        // Configuración inicial: simular un usuario en PerfilUsuario
        UsuarioDTO usuarioActual = new UsuarioDTO("UsuarioActual", "usuario@correo.com", "Contrasena123");
        PerfilUsuario.setUsuario(usuarioActual);

        // Nueva contraseña
        String nuevaContrasena = "NuevaContrasenaSegura";

        try {
            // Actualizar la contraseña
            IUsuariosBO usuariosBO = UsuariosBO.getInstance();
            usuariosBO.actualizarContrasenhaUsuario(PerfilUsuario.getUsuario().getCorreoElectronico(), nuevaContrasena);

            // Actualizar en PerfilUsuario
            PerfilUsuario.getUsuario().setContrasena(nuevaContrasena);

            // Mostrar mensaje de éxito
            System.out.println("Contraseña actualizada exitosamente.");
        } catch (BOException e) {
            System.err.println("Error al actualizar la contraseña: " + e.getMessage());
        }
    }
}