/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

import com.equipo7.negocio.dtos.FiltroBusquedaDTO;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import java.util.List;

/**
 *
 * @author Saul Neri
 */
public class FiltroBusquedaConverter  {
    /**
     * Convierte un objeto FiltroBusqueda a un FiltroBusquedaDTO.
     *
     * @param filtroBusqueda el objeto FiltroBusqueda a convertir.
     * @return un objeto FiltroBusquedaDTO equivalente.
     */
    public static FiltroBusquedaDTO convertToDto(FiltroBusqueda filtroBusqueda) {
        FiltroBusquedaDTO dto = new FiltroBusquedaDTO();
        dto.setCoincidenciaBusqueda(filtroBusqueda.getCoincidenciaBusqueda());
        dto .setNombreArtista(filtroBusqueda.getNombreArtista());
        dto.setAnioDesde(filtroBusqueda.getAnioDesde());
        dto.setAnioHasta(filtroBusqueda.getAnioHasta());
        dto.setGeneros(filtroBusqueda.getGeneros());
        dto.setGenerosRestringidos(filtroBusqueda.getGenerosRestringidos());
        return dto;
    }

    /**
     * Convierte un objeto FiltroBusquedaDTO a un FiltroBusqueda.
     *
     * @param dto el objeto FiltroBusquedaDTO a convertir.
     * @return un objeto FiltroBusqueda equivalente.
     */
    public static FiltroBusqueda convertToEntity(FiltroBusquedaDTO dto) {
        FiltroBusqueda.Builder builder = new FiltroBusqueda.Builder();
        builder.setCoincidenciaBusqueda(dto.getCoincidenciaBusqueda());
        builder.conNombreArtista(dto.getNombreArtista());
        builder.desdeAnio(dto.getAnioDesde());
        builder.hastaAnio(dto.getAnioHasta());

        List<String> generos = dto.getGeneros();
        if (generos != null) {
            generos.forEach(builder::agregarGenero);
        }

        List<String> generosRestringidos = dto.getGenerosRestringidos();
        if (generosRestringidos != null) {
            generosRestringidos.forEach(builder::agregarGeneroRestringido);
        }

        return builder.build();
    }
}
