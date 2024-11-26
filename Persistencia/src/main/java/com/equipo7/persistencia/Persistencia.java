/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo7.persistencia;

import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;

import java.util.Arrays;

/**
 *
 * @author neri
 */
public class Persistencia {

    public static void main(String[] args) {
        /*
        FiltroBusqueda filtro = new FiltroBusqueda.Builder()
                .conGeneros(Arrays.asList("reggeaton", "rock"))
                .desdeAnio(2000)
                .hastaAnio(2024)
                .build();

         */
        // NOTE: iniciarSesion [funcionando]
        UsuariosDAO usuarios = null;
        try {
            usuarios = UsuariosDAO.getInstance();
        } catch (ConexionException e) {
            throw new RuntimeException(e);
        }

        try {
            Usuario usuario = usuarios.iniciarSesion("correo@gmail.com", "123456789");
            System.out.println(usuario);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        // NOTE: registrar usuario [funcionando]
        Usuario usr = new Usuario();
        usr.setNombreUsuario("locobson13");
        usr.setCorreoElectronico("locobsob13@gmail.com");
        usr.setContrasena("shesh12345");
        usr.setGenerosRestringidos(Arrays.asList("reggeaton", "regional mexicano"));

        System.out.println(usr);

        /*
        try {
            usuarios.registrarUsuario(usr);
            System.out.println("Se agrego al usuario!");
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }*/


        // NOTE: actualizar informacion []

        /*
        usr.setNombreUsuario("shesh13");
        //usr.setCorreoElectronico("correo@gmail.com");
        try {
            usuarios.actualizarContrasenhaUsuario(usr.getCorreoElectronico(), "perro12345");
            System.out.println("Se actualizo la contrasena del usuario");
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }*/

        usr.setNombreUsuario("shesh13");
        //usr.setCorreoElectronico("correo@gmail.com");
        try {
            usuarios.actualizarNombreUsuario(usr.getCorreoElectronico(), usr.getNombreUsuario());
            System.out.println("Se actualizo el nombre del usuario");
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }
}
