/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.equipo7.negocio;

import com.equipo7.negocio.bo.AlbumBO;
import com.equipo7.negocio.bo.UsuariosBO;
import com.equipo7.negocio.bo.interfaces.IAlbumBO;
import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import excepciones.DAOException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author neri
 */
public class Negocio {

    public static void main(String[] args) {

        IUsuariosBO usuarios = UsuariosBO.getInstance();

        IAlbumBO albumesBO = null;

        /*
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
            }*/
        try {
            albumesBO = AlbumBO.getInstance();
        } catch (DAOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println(albumesBO.obtenerTodosPorArtista(new ObjectId("674e04da8e53417fe824d093")));
        } catch (BOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            System.out.println(albumesBO.obtenerTodos());
        } catch (BOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println(albumesBO.obtenerGenerosMusicales());
        } catch (BOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
