/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

/**
 *
 * @author caarl
 */
import com.equipo7.persistencia.entidades.Album;

import com.equipo7.negocio.dtos.AlbumDTO;
import org.bson.types.ObjectId;

import java.util.stream.Collectors;

public class AlbumConvertidor {
    public static AlbumDTO entidadADto(Album album) {
        if (album == null) return null;
        return new AlbumDTO(
            album.getId() != null ? album.getId().toHexString() : null,
            album.getNombre(),
            album.getFechaLanzamiento(),
            album.getGeneroMusical(),
            album.getImagenPortadaUrl(),
            album.getCanciones() != null ? album.getCanciones().stream().map(ObjectId::toHexString).collect(Collectors.toList()) : null,
            album.getReferenciaArtista() != null ? album.getReferenciaArtista().toHexString() : null
        );
    }

    public static Album dtoAEntidad(AlbumDTO albumDTO) {
        if (albumDTO == null) return null;
        return new Album(
            albumDTO.getId() != null ? new ObjectId(albumDTO.getId()) : null,
            albumDTO.getNombre(),
            albumDTO.getFechaLanzamiento(),
            albumDTO.getGeneroMusical(),
            albumDTO.getImagenPortadaUrl(),
            albumDTO.getCanciones() != null ? albumDTO.getCanciones().stream().map(ObjectId::new).collect(Collectors.toList()) : null
        );
    }
}