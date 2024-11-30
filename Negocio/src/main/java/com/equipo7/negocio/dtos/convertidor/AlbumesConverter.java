/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

/**
 *
 * @author caarl
 */
public class AlbumesConverter {
 public static AlbumDTO entidadADto(Album album) {
        return new AlbumDTO(
            album.getId(),
            album.getNombre(),
            album.getFechaLanzamiento(),
            album.getGeneroMusical(),
            album.getImagenPortadaUrl(),
            album.getCanciones()
        );
    }

    public static Album dtoAEntidad(AlbumDTO albumDTO) {
        return new Album(
            albumDTO.getId(),
            albumDTO.getNombre(),
            albumDTO.getFechaLanzamiento(),
            albumDTO.getGeneroMusical(),
            albumDTO.getImagenPortadaUrl(),
            albumDTO.getCanciones()
        );
    }
}