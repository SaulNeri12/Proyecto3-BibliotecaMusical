/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

/**
 *
 * @author caarl
 */

import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.persistencia.entidades.Cancion;

public class CancionConvertidor {
    public static CancionDTO entidadADto(Cancion cancion) {
        CancionDTO dto = new CancionDTO();
        dto.setIdAlbum(cancion.getIdAlbum());
        dto.setNombre(cancion.getNombre());
        dto.setImagenPortadaURL(cancion.getImagenPortadaURL());
        return dto;
    }
    
    public static Cancion dtoAEntidad(CancionDTO dto) {
        Cancion cancion = new Cancion();
        
        cancion.setIdAlbum(dto.getIdAlbum());
        cancion.setNombre(dto.getNombre());
        cancion.setImagenPortadaURL(dto.getImagenPortadaURL());
        
        return cancion;
    }
}