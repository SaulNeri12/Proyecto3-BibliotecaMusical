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
import org.bson.types.ObjectId;

public class CancionConvertidor {

    // Convierte de Cancion a CancionDTO
    public static CancionDTO aDTO(Cancion cancion) {
        if (cancion == null) return null;
        
        return new CancionDTO(
            cancion.getId() != null ? cancion.getId().toHexString() : null,
            cancion.getNombre(),
            cancion.getIdAlbum() != null ? cancion.getIdAlbum().toHexString() : null
        );
    }

    // Convierte de CancionDTO a Cancion
    public static Cancion aEntidad(CancionDTO dto) {
        if (dto == null) return null;

        Cancion cancion = new Cancion();
        cancion.setId(dto.getId() != null ? new ObjectId(dto.getId()) : null);
        cancion.setNombre(dto.getNombre());
        cancion.setIdAlbum(dto.getIdAlbum() != null ? new ObjectId(dto.getIdAlbum()) : null);
        return cancion;
    }
}