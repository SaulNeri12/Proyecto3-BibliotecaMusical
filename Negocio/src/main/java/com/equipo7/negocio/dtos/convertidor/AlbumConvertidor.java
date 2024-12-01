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

        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(album.getId());
        albumDTO.setNombre(album.getNombre());
        albumDTO.setFechaLanzamiento(album.getFechaLanzamiento());
        albumDTO.setGeneroMusical(album.getGeneroMusical());
        albumDTO.setImagenPortadaUrl(album.getImagenPortadaUrl());
        // Si es necesario convertir las canciones
        albumDTO.setCanciones(album.getCanciones());
        albumDTO.setReferenciaArtista(album.getReferenciaArtista());

        return albumDTO;
    }

    /**
     * Convierte un DTO AlbumDTO a una entidad Album.
     *
     * @param albumDTO el DTO AlbumDTO a convertir.
     * @return la entidad Album equivalente, o null si la entrada es null.
     */
    public static Album dtoAEntidad(AlbumDTO albumDTO) {
        if (albumDTO == null) return null;

        Album album = new Album();
        album.setId(albumDTO.getId());
        album.setNombre(albumDTO.getNombre());
        album.setFechaLanzamiento(albumDTO.getFechaLanzamiento());
        album.setGeneroMusical(albumDTO.getGeneroMusical());
        album.setImagenPortadaUrl(albumDTO.getImagenPortadaUrl());
        // Si es necesario convertir las canciones
        album.setCanciones(albumDTO.getCanciones());
        album.setReferenciaArtista(albumDTO.getReferenciaArtista());

        return album;
    }
}