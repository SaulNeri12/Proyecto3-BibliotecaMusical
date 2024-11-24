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

        try {
            UsuariosDAO usuarios = UsuariosDAO.getInstance();

            try {
                Usuario usuario = usuarios.iniciarSesion("correo@gmail.com", "123456789");
                System.out.println(usuario);

            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        } catch (ConexionException e) {
            throw new RuntimeException(e);
        }
    }
}
