/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.dto.ArtistaDTO;
import com.equipo7.persistencia.entidades.Artista;

import java.util.stream.Collectors;

public class ArtistaConverter {

    public ArtistaDTO toDTO(Artista artista) {
        if (artista == null) {
            return null;
        }
        return new ArtistaDTO(
                artista.getId(),
                artista.getNombreArtista(),
                artista.getDescripcion(),
                artista.getGeneroMusical(),
                artista.getAlbumes().stream().map(album -> album.toString()).collect(Collectors.toList())
        );
    }

    public Artista toEntity(ArtistaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Artista(
                dto.getId(),
                dto.getNombreArtista(),
                dto.getDescripcion(),
                dto.getGeneroMusical(),
                dto.getAlbumes().stream().map(album -> new Album(album)).collect(Collectors.toList())
        );
    }
}