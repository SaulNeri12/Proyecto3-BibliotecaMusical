/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.presentacion.gui;

import com.equipo7.negocio.dtos.UsuarioDTO;

/**
 * Actua como una instancia unica para acceder al usuario desde cualquier parte del programa.
 * @author Saul Neri
 */
public class PerfilUsuario {
    private static UsuarioDTO usuario;
    
    public static void setUsuario(UsuarioDTO usuarioNuevo) {
        usuario = usuarioNuevo; // Actualiza el usuario siempre
    }
    
    public static UsuarioDTO getUsuario() {
        return usuario;
    }
    
    // Método para cerrar sesión (limpiar el usuario)
    public static void cerrarSesion() {
        usuario = null; // Limpia el usuario actual
    }
}
