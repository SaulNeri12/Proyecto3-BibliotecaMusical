/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.presentacion;

import com.equipo7.negocio.bo.UsuariosBO;
import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author Saul Neri
 */
public class PruebaActualizarFavoritos {
    public static void main(String[] args) {
        IUsuariosBO usuariosBO = UsuariosBO.getInstance();
        
        UsuarioDTO usuario = null;
        
        try {
            usuario = usuariosBO.iniciarSesion("parkxin@gmail.com", "shesh12345");
        } catch (BOException ex) {
            Logger.getLogger(PruebaActualizarFavoritos.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        usuario.agregarAlbumAFavoritos(new ObjectId("674f5f12f766715b4f3d9af0"));
                
        try {
            usuariosBO.actualizarFavoritos(usuario);
            System.out.println("actualizados!!!");
        } catch (BOException ex) {
            Logger.getLogger(PruebaActualizarFavoritos.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }
}
