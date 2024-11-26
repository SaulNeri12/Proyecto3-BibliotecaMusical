/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo7.negocio;

import com.equipo7.negocio.bo.UsuariosBO;
import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;

import java.util.Arrays;

/**
 *
 * @author neri
 */
public class Negocio {

    public static void main(String[] args) {

        IUsuariosBO usuarios = UsuariosBO.getInstance();

        try {
            UsuarioDTO u = usuarios.iniciarSesion("correo@gmail.com", "123456789");
            System.out.println(u);
        } catch (BOException e) {
            throw new RuntimeException(e);
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombreUsuario("ikerumian12");
        usuarioDTO.setCorreoElectronico("shesh@gmail.com");
        usuarioDTO.setContrasena("letsgo1234");
        usuarioDTO.setGenerosRestringidos(Arrays.asList("corridos tumbados"));

        try {
            usuarios.registrarUsuario(usuarioDTO);
            System.out.println("Se registro el usuaro");
        } catch (BOException e) {
            throw new RuntimeException(e);
        }
    }
}
