/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.persistencia.entidades.Artista;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public class ArtistaConvertidor {
  public static ArtistaDTO entidadADto(Artista artista) {
        if (artista == null) return null;

        return new ArtistaDTO(
            artista.getId() != null ? artista.getId().toHexString() : null,
            artista.getNombreArtista(),
            artista.getDescripcion(),
            artista.getTipo(),
            artista.getGeneroMusical(),
            artista.getReferenciasAlbumes() != null
                ? artista.getReferenciasAlbumes().stream().map(ObjectId::toHexString).collect(Collectors.toList())
                : null
        );
    }

    public static Artista dtoAEntidad(ArtistaDTO dto) {
        if (dto == null) return null;

        return new Artista(
            dto.getId() != null ? new ObjectId(dto.getId()) : null,
            dto.getNombreArtista(),
            dto.getTipo(),
            dto.getDescripcion(),
            dto.getGeneroMusical(),
            dto.getReferenciasAlbumes() != null
                ? dto.getReferenciasAlbumes().stream().map(ObjectId::new).collect(Collectors.toList())
                : null
        );
    }
}