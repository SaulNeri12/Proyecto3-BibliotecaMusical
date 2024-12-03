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
        if (artista == null) {
            return null;
        }

        ArtistaDTO a = new ArtistaDTO();

        a.setId(artista.getId());
        a.setNombreArtista(artista.getNombreArtista());
        a.setGeneroMusical(artista.getGeneroMusical());
        a.setDescripcion(artista.getDescripcion());
        a.setImagenURL(artista.getImagenURL());
        a.setReferenciasAlbumes(artista.getAlbumes());
        a.setTipo(artista.getTipo());
        
        if (artista.getIntegrantes() != null) {
            a.setIntegrantes(artista.getIntegrantes().stream().map(IntegranteConvertidor::entidadADto).collect(Collectors.toList()));
        }

        return a;
    }

    public static Artista dtoAEntidad(ArtistaDTO dto) {
        if (dto == null) {
            return null;
        }

        Artista artista = new Artista();

        artista.setId(dto.getId());
        artista.setNombreArtista(dto.getNombreArtista());
        artista.setGeneroMusical(dto.getGeneroMusical());
        artista.setDescripcion(dto.getDescripcion());
        artista.setImagenURL(dto.getImagenURL());
        artista.setAlbumes(dto.getReferenciasAlbumes());
        artista.setTipo(dto.getTipo());

        if (dto.getIntegrantes() != null) {
            artista.setIntegrantes(dto.getIntegrantes().stream().map(IntegranteConvertidor::dtoAEntidad).collect(Collectors.toList()));
        }
        
        
        return artista;
    }
}
